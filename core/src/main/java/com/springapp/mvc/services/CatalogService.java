package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.CartRepository;
import com.springapp.mvc.repository.CategoryRepository;
import com.springapp.mvc.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с категориями товаров
 * <p>
 * Gataullin Kamil
 * 22.02.2016 23:23
 */
@Service
public class CatalogService {

    /**
     * Получение товаров по id категории
     *
     * @param categoryId id категории
     * @return список товаров
     */
    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private List<GoodInfo> goods;

    @Transactional
    public List<GoodInfo> getGoodsByCategoryId(Long category_id) {
        List<CategoryInfo> subcategories = categoryRepository.findCategoriesByParentId(category_id);
        goods = goodRepository.findGoodsByCategoryId(category_id);
        if (subcategories != null) {
            for (CategoryInfo subcategory : subcategories) {
                goods.addAll(goodRepository.findGoodsByCategoryId(subcategory.getId()));
            }
        }
        return goods;
    }

    @Transactional
    public List<GoodInfo> getGoodsByCategoryIdAndBrand(Long category_id, Long brand) {
        List<CategoryInfo> subcategories = categoryRepository.findCategoriesByParentId(category_id);
        goods = goodRepository.findGoodsByCategory_IdAndBrand_Id(category_id, brand);
        if (subcategories != null) {
            for (CategoryInfo subcategory : subcategories) {
                goods.addAll(goodRepository.findGoodsByCategory_IdAndBrand_Id(subcategory.getId(), brand));
            }
        }
        return goods;
    }
}
