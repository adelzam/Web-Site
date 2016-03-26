package com.springapp.mvc.repository;

import com.springapp.mvc.common.CategoryInfo;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
public interface CategoryRepository {

    void addCategory(CategoryInfo categoryInfo);

    List<CategoryInfo> getSubcategories(CategoryInfo categoryInfo);

    CategoryInfo getCategoryById(Long id);

    List<CategoryInfo> getAllCategories();
}
