package co.istad.kanhchana.elearninga01m1.features.course;

import co.istad.kanhchana.elearninga01m1.features.category.Category;
import co.istad.kanhchana.elearninga01m1.features.category.CategoryRepository;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseResponse;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseUpdateRequest;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CreateCourseRequest;
import co.istad.kanhchana.elearninga01m1.features.instructor.InstructorProfile;
import co.istad.kanhchana.elearninga01m1.features.instructor.InstructorProfileRepository;
import co.istad.kanhchana.elearninga01m1.security.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final CourseMapper courseMapper;
    private final InstructorProfileRepository instructorProfileRepository;

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .filter(course -> !Boolean.TRUE.equals(course.getIsDeleted()))
                .map(courseMapper::mapCourseToCourseResponse)
                .toList();
    }

    @Override
    public CourseResponse getCourseBySlug(String slug) {
        Course course = courseRepository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found"
                ));

        if (Boolean.TRUE.equals(course.getIsDeleted())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Course not found"
            );
        }

        return courseMapper.mapCourseToCourseResponse(course);
    }

    @Override
    public CourseResponse updateCourse(Integer id, CourseUpdateRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found"
                ));

        if (Boolean.TRUE.equals(course.getIsDeleted())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Course not found"
            );
        }

        if (request.slug() != null && courseRepository.existsBySlugAndIdNot(request.slug(), id)) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Slug already exists"
            );
        }

        if (request.categoryId() != null) {
            Category category = categoryRepository.findById(request.categoryId())
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Category not found"
                    ));
            course.setCategory(category);
        }

        if (request.slug() != null) course.setSlug(request.slug());
        if (request.keyword() != null) course.setKeyword(request.keyword());
        if (request.title() != null) course.setTitle(request.title());
        if (request.description() != null) course.setDescription(request.description());
        if (request.thumbnail() != null) course.setThumbnail(request.thumbnail());
        if (request.totalHours() != null) course.setTotalHours(request.totalHours());
        if (request.level() != null) course.setLevel(request.level());
        if (request.price() != null) course.setPrice(request.price());
        if (request.discountPercent() != null) course.setDiscountPercent(request.discountPercent());
        if (request.isPublished() != null) course.setIsPublished(request.isPublished());

        course = courseRepository.save(course);
        return courseMapper.mapCourseToCourseResponse(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found"
                ));

        if (Boolean.TRUE.equals(course.getIsDeleted())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Course already deleted"
            );
        }

        course.setIsDeleted(true);
        courseRepository.save(course);
    }

    @Override
    public CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt) {

        // validate slug
        if (courseRepository.existsBySlug(createCourseRequest.slug())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "slug has already been used"
            );
        }

        // validate category
        Category category = categoryRepository.findById(createCourseRequest.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category has not been found"
                ));

        // fetch existing instructor profile
        InstructorProfile instructorProfile = instructorProfileRepository
                .findById(jwt.getSubject())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Instructor profile not found"
                ));

        Course course = courseMapper.mapCreateCourseRequestToCourse(createCourseRequest);

        course.setCategory(category);
        course.setCountRating(0);
        course.setStarRating(0F);
        course.setIsDeleted(false);
        course.setIsPublished(false);
        course.setInstructorProfile(new InstructorProfile(AuthUtils.extractUserId()));

        course = courseRepository.save(course);
        return courseMapper.mapCourseToCourseResponse(course);
    }

}