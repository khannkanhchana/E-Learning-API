package co.istad.kanhchana.elearninga01m1.features.category.mapper;

import co.istad.kanhchana.elearninga01m1.features.category.Category;
import co.istad.kanhchana.elearninga01m1.features.category.dto.CategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.CategoryResponse;


public class CategoryMapper {

    public static Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.name());
        category.setIcon(request.icon());
        category.setIsDeleted(false);
        return category;
    }

    public static CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .icon(category.getIcon())
                .build();
    }
}
