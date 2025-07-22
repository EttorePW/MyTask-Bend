package MyTaskApp.MyTaskList.categories;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category,String> {
    Optional<Object> findCategoryByCategoryName(String categoryName);
}
