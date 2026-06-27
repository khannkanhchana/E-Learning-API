package co.istad.kanhchana.elearninga01m1.features.course.dto;

import co.istad.kanhchana.elearninga01m1.features.category.dto.response.categoryresponse.CategoryResponse;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CourseResponse(
    Integer id,
    String slug,
         String keyword, // use for SEO
         String title,
         String description,
         String thumbnail,
         Float starRating,
         Integer countRating,
        Float totalHours,
        String level,
        BigDecimal price,
        Float discountPercent,
//        LocalDateTime createdAt,
//        LocalDateTime updatedAt,
        CategoryResponse category,
        String instructorName,
        Boolean isPublished
//        String instructorName


) {
}
