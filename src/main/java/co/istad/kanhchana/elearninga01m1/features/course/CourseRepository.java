package co.istad.kanhchana.elearninga01m1.features.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Integer> {
    boolean existsBySlug(String slug);
    boolean existsBySlugAndIdNot(String slug, Integer id);
    Optional<Course> findBySlug(String slug);

    List<Course> allCourses();
    Course byId(Integer id);
}
