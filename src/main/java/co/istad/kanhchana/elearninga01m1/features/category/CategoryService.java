package co.istad.kanhchana.elearninga01m1.features.category;

import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.CreateCategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.UpdateCategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.response.categoryresponse.CategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryResponse> getAllCategory(Integer page, Integer size);
    CategoryResponse getCategoryById(Integer id);
    CategoryResponse createCategory(CreateCategoryRequest request);
    CategoryResponse updateCategoryById(Integer id, UpdateCategoryRequest request);
    void deleteCategoryById(Integer id);
}
