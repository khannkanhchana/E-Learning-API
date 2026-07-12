package co.istad.kanhchana.elearninga01m1.features.student;

import co.istad.kanhchana.elearninga01m1.features.student.dto.StudentProfileResponse;
import co.istad.kanhchana.elearninga01m1.features.student.dto.UpdateStudentProfileRequest;

public interface StudentService {
    StudentProfileResponse me();

    StudentProfileResponse updateProfile(UpdateStudentProfileRequest updateStudentProfileRequest);

}
