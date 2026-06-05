package co.istad.kanhchana.elearninga01m1.features.course;

import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.CategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseResponse;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CreateCourseRequest;
import org.springframework.security.oauth2.jwt.Jwt;

public interface CourseService {

    // Create a new course
    CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt);

}
