package MyTaskApp.MyTaskList.categories;

import MyTaskApp.MyTaskList.categories.dtos.CategoryDTO;
import MyTaskApp.MyTaskList.categories.dtos.NewCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable String id){
        return categoryService.getCategoryById(id);
    }
    @PostMapping
    public CategoryDTO postCategory(@RequestBody NewCategoryDTO newCategoryDTO){
        return categoryService.createCategory(newCategoryDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable String id){
        categoryService.deleteCategoryById(id);
        return "Category deleted";
    }
}
