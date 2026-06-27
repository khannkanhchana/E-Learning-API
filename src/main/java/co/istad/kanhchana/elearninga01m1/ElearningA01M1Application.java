package co.istad.kanhchana.elearninga01m1;

import co.istad.kanhchana.elearninga01m1.features.course.Course;
import co.istad.kanhchana.elearninga01m1.features.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class ElearningA01M1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ElearningA01M1Application.class, args);
    }

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) {
//        List<Course> courses = courseRepository.findAll();
//
//        Course course = courseRepository.byId(11);
//
//        IO.print(course.getTitle());
    }
}

/* ✅ Same file (no import needed) */
//class IO {
//    public static void print(Object obj) {
//        System.out.println(obj);
//    }
//}