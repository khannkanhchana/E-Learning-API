package co.istad.kanhchana.elearninga01m1.features.student;


import co.istad.kanhchana.elearninga01m1.features.enrollment.Enrollment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    private String userId;

    private String university;
    private String major;
    private String biography;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "studentProfile")
    private List<Enrollment> enrollments;
}