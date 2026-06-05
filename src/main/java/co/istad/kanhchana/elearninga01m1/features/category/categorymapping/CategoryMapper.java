package co.istad.kanhchana.elearninga01m1.features.category.categorymapping;

import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.CategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.CreateCategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.response.categoryresponse.CategoryResponse;
import co.istad.kanhchana.elearninga01m1.features.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toEntity(CreateCategoryRequest request){
        Category category = new Category();
        category.setName(request.name());
        category.setIcon(request.icon());
        category.setIsDeleted(false);
        return category;
    }
    public CategoryResponse toResponse(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getIcon()
        );
    }
    public void updateEntity(Category category, CategoryRequest request){
        category.setName(request.name());
        category.setIcon(request.icon());
    }
}
