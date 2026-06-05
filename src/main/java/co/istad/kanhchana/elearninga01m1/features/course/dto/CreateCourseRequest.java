package co.istad.kanhchana.elearninga01m1.features.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateCourseRequest(

        @NotBlank
        String slug,

        String keyword,

        String title,

        String description,

        String thumbnail,

        Float totalHours,

        String level,

        BigDecimal price,

        Float discountPercent,

        @NotNull
        Integer categoryId
) {
}
