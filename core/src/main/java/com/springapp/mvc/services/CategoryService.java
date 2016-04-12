package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     *
     * @param id
     * @return category by id
     */
    public CategoryInfo getCategoryInfo(Long id) {
       return categoryRepository.findOne(id);
    }
}
