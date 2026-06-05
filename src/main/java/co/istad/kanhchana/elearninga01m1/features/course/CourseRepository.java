package co.istad.kanhchana.elearninga01m1.features.course;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Integer> {

    boolean existsBySlug(String slug);

}
