package co.istad.kanhchana.elearninga01m1.features.course;


import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseResponse;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseUpdateRequest;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CreateCourseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CourseResponse createCourse(
            @Valid @RequestBody CreateCourseRequest createCourseRequest,
            @AuthenticationPrincipal Jwt jwt
    ) {
        System.out.println("JWT: " + jwt.getSubject());
        return courseService.createCourse(createCourseRequest,jwt);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{slug}")
    public CourseResponse getCourseBySlug(
            @PathVariable String slug
    ) {
        return courseService.getCourseBySlug(slug);
    }

    @PutMapping("/{id}")
    public CourseResponse updateCourse(
            @PathVariable Integer id,
            @Valid @RequestBody CourseUpdateRequest request
    ) {
        return courseService.updateCourse(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCourse(
            @PathVariable Integer id
    ) {
        courseService.deleteCourse(id);
    }
}