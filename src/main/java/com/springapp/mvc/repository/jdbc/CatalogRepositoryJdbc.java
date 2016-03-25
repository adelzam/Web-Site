package com.springapp.mvc.repository.jdbc;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.repository.CatalogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Repository
public class CatalogRepositoryJdbc implements CatalogRepository {

    //TODO доделать все подключения и запросы
    @Override
    public void addCategory(CategoryInfo categoryInfo) {

    }

    @Override
    public List<CategoryInfo> getSubcategories(CategoryInfo categoryInfo) {
        return null;
    }

    @Override
    public CategoryInfo getCategoryById(Long id) {
        return null;
    }

    @Override
    public List<CategoryInfo> getAllCategories() {
        return null;
    }
}
