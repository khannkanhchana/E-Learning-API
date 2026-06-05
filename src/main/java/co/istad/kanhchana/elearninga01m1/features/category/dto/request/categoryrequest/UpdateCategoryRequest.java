package co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest;

import jakarta.validation.constraints.Size;

public record UpdateCategoryRequest(
        @Size(max = 50,message = "Name must not exceed 50 characters")
        String name,
        String icon
) {
}
