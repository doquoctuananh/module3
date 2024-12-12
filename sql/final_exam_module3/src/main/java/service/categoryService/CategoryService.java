package service.categoryService;

import model.Category;
import repository.categoryRepository.CategoryRepository;
import repository.categoryRepository.ICategoryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryRepository categories = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        List<Category> categorieList =categories.findAll();
        return categorieList;
    }
}
