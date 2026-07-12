package co.istad.kanhchana.elearninga01m1.features.student;


import co.istad.kanhchana.elearninga01m1.config.props.KeycloakAdminClientProps;
import co.istad.kanhchana.elearninga01m1.features.student.dto.StudentProfileResponse;
import co.istad.kanhchana.elearninga01m1.features.student.dto.UpdateStudentProfileRequest;
import co.istad.kanhchana.elearninga01m1.security.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService{
    private final Keycloak keycloak;
    private final KeycloakAdminClientProps props;
    private final StudentProfileMapper studentProfileMapper;
    private final StudentProfileRepository studentProfileRepository;

    @Override
    public StudentProfileResponse updateProfile(UpdateStudentProfileRequest updateStudentProfileRequest) {

        // Extract userId from JWT access token
        String userId = AuthUtils.extractUserId();

        // retrieve profile from keycloak
        UserResource userResource = keycloak.realm(props.getTargetRealm())
                .users()
                .get(userId);

        UserRepresentation keycloakUser = userResource.toRepresentation();
        if (updateStudentProfileRequest.firstName() != null)
            keycloakUser.setFirstName(updateStudentProfileRequest.firstName());
        if (updateStudentProfileRequest.lastName() != null)
            keycloakUser.setLastName(updateStudentProfileRequest.lastName());

        Map<String , List<String >> attributes = new HashMap<>();
        if (updateStudentProfileRequest.gender() != null)
            attributes.put("gender",List.of(updateStudentProfileRequest.gender().getGender()));
        if (updateStudentProfileRequest.biography() != null)
            attributes.put("biography",List.of(updateStudentProfileRequest.biography()));

        keycloakUser.setAttributes(attributes);

        userResource.update(keycloakUser);

        StudentProfile studentProfile = studentProfileRepository.findById(keycloakUser.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student profile has not been found"
                ));
        studentProfileMapper.mapUpdateStudentProfileRequestToStudentProfile(updateStudentProfileRequest,studentProfile);
        studentProfileRepository.save(studentProfile);

        return studentProfileMapper.toStudentProfileResponse(studentProfile,keycloakUser);
    }

    @Override
    public StudentProfileResponse me() {

        // Extract userId from JWT access token
        String userId = AuthUtils.extractUserId();
        // retrieve profile from keycloak
        UserRepresentation user = keycloak.realm(props.getTargetRealm())
                .users()
                .get(userId)
                .toRepresentation();
        log.info("User {} logged in ", user);


        // retrieve profile from database table

        StudentProfile studentProfile = studentProfileRepository.findById(user.getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student profile has not been found"
                ));
        return studentProfileMapper.toStudentProfileResponse(studentProfile,user);
    }

//    @Override
//    public StudentProfileResponse update(UpdateStudentProfileRequest updateStudentProfileRequest) {
//        // Extract userId from JWT access token
//        String userId = AuthUtils.extractUserId();
//
//        // retrieve profile from keycloak
//        UserRepresentation user = keycloak.realm(props.getTargetRealm())
//                .users()
//                .get(userId)
//                .toRepresentation();
//        log.info("User {} logged in", user);
//
////        UserRepresentation keycloakUser =
//        return studentProfileMapper.mapUserRepresentationToStudentProfileResponse(user);
//
//
//
//    }
}
