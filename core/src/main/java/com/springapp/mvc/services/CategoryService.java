package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adelzamalutdinov on 08.04.16.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryInfo getCategoryInfo(Long id) {
       return categoryRepository.findOne(id);
    }
}
