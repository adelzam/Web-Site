package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.FilterInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.*;
import com.springapp.mvc.utils.OrderTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adelzamalutdinov on 05.04.16.
 */
@Service
public class FilterServiсe {
    @Autowired
    private GoodRepositoryCustom goodRepositoryCustom;

    @Autowired
    private FilterRepository filterRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Transactional
    public List<GoodInfo> orderBy(OrderTypes type, Long category, Long brand) {
        List<GoodInfo> goods = null;
        List<Long> subcategories_id = new ArrayList<Long>();
        subcategories_id.add(category);
        List<CategoryInfo> subcategories = categoryRepository.findCategoriesByParentId(category);
        if (subcategories!=null) {
            for (CategoryInfo subcategory : subcategories) {
                subcategories_id.add(subcategory.getId());
            }
        }
        switch (type) {
            case BYBRANDASC:
                goods = goodRepositoryCustom.getGoodsInOrder("brand", brandRepository.findOne(brand) , subcategories_id);
                break;
            case BYBRANDDESC:
                goods = goodRepositoryCustom.getGoodsInOrder("brand", brandRepository.findOne(brand) , subcategories_id);
                Collections.reverse(goods);
            break;
            case BYNAMEASC:
                goods = goodRepositoryCustom.getGoodsInOrder("name", brandRepository.findOne(brand) , subcategories_id);
            break;
            case BYNAMEDESC:
                goods = goodRepositoryCustom.getGoodsInOrder("name", brandRepository.findOne(brand), subcategories_id);
                Collections.reverse(goods);
            break;
            case BYPRICEASC:
                goods = goodRepositoryCustom.getGoodsInOrder("price", brandRepository.findOne(brand) , subcategories_id);
            break;
            case BYPRICEDESC:
                goods = goodRepositoryCustom.getGoodsInOrder("price", brandRepository.findOne(brand) , subcategories_id);
                Collections.reverse(goods);
            break;
        }
        return goods;
    }

    @Transactional
    public List<FilterInfo> getAllFilters() {
        return filterRepository.findAll();
    }
}
