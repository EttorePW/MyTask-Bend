package MyTaskApp.MyTaskList.categories;

import MyTaskApp.MyTaskList.categories.dtos.CategoryDTO;
import MyTaskApp.MyTaskList.categories.dtos.NewCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(NewCategoryDTO newCategoryDTO){
        Category category = new Category(newCategoryDTO.getCategoryName());
        categoryRepository.save(category);
        return convertCategoryDTOToCategory(category);
    }
    public CategoryDTO convertCategoryDTOToCategory(Category category){
        return new CategoryDTO(category.getCategoryId(),category.getCategoryName());
    }
    public List<CategoryDTO> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        categories.forEach(category -> categoryDTOs.add(convertCategoryDTOToCategory(category)));
        return categoryDTOs;
    }
    public CategoryDTO getCategoryById(String categoryId){
        return convertCategoryDTOToCategory(categoryRepository.findById(categoryId).get()) ;
    }
    public void deleteCategoryById(String categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
