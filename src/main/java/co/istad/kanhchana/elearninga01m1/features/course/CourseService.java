package co.istad.kanhchana.elearninga01m1.features.course;

import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.CategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseResponse;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseUpdateRequest;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CreateCourseRequest;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseBySlug(String slug);
    CourseResponse updateCourse(Integer id, CourseUpdateRequest request);
    void deleteCourse(Integer id);

    CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt);
}
