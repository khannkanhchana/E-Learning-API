package co.istad.kanhchana.elearninga01m1.features.category;

import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.CreateCategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.request.categoryrequest.UpdateCategoryRequest;
import co.istad.kanhchana.elearninga01m1.features.category.dto.response.categoryresponse.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public Page<CategoryResponse> getAllCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return categoryService.getAllCategory(page,size);
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@Valid @RequestBody CreateCategoryRequest request){
        return categoryService.createCategory(request);
    }

    @PatchMapping("/{id}")
    public CategoryResponse updateCategoryById(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCategoryRequest request
    ){
        return categoryService.updateCategoryById(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }

}

