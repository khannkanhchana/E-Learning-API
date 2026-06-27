package co.istad.kanhchana.elearninga01m1.features.instructor;


import co.istad.kanhchana.elearninga01m1.config.auditing.BasedEntity;
import co.istad.kanhchana.elearninga01m1.features.course.Course;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.crypto.Mac;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "instructor_profiles")
public class InstructorProfile extends BasedEntity {
    public InstructorProfile(String id){
        this.userId = id;
    }

    @Id
    private String userId;

    private String biography;
    private String jobTitle;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "instructorProfile")
    private List<Course> courses;
}
