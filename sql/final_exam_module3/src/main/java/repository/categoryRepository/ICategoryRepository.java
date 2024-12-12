package repository.categoryRepository;

import model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
