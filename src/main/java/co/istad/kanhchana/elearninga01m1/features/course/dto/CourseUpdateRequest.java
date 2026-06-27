package co.istad.kanhchana.elearninga01m1.features.course.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CourseUpdateRequest(

        @Size(max = 255)
        String slug,

        @Size(max = 255)
        String keyword,

        @Size(max = 255)
        String title,

        String description,

        @Size(max = 255)
        String thumbnail,

        @Positive
        @Max(50)
        Float totalHours,

        @Size(max = 50)
        String level,

        @Positive
        BigDecimal price,

        @Positive
        Float discountPercent,

        Integer categoryId,

        String instructorId,

        Boolean isPublished
) {
}
