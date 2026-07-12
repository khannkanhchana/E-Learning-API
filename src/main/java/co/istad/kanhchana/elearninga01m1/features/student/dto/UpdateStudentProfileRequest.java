package co.istad.kanhchana.elearninga01m1.features.student.dto;

import co.istad.kanhchana.elearninga01m1.features.auth.dto.GenderOptions;

public record UpdateStudentProfileRequest(
        String firstName,
        String lastName,
        GenderOptions gender,
        String biography,

        String profilePicture,
        String university,
        String major,
        String phoneNumber,
        String githubLink,
        String facebookLink
) {
}
