package co.istad.kanhchana.elearninga01m1.features.course;


import co.istad.kanhchana.elearninga01m1.features.course.dto.CourseResponse;
import co.istad.kanhchana.elearninga01m1.features.course.dto.CreateCourseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course mapCreateCourseRequestToCourse(CreateCourseRequest createCourseRequest);

    CourseResponse mapCourseToCourseResponse(Course course);

}
