package com.springapp.mvc.services.filters;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.GoodRepository;
import com.springapp.mvc.utils.OrderTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adelzamalutdinov on 05.04.16.
 */
@Service
public class GoodsFiltersServies {
    @Autowired
    private GoodRepository goodRepository;


    public List<GoodInfo> orderBy(OrderTypes type, Long category) {
        List<GoodInfo> goods = null;
        switch (type) {
            case BYBRANDASC:
                return goodRepository.findGoodsByCategoryIdOrderByBrandAsc(category);
            case BYBRANDDESC:
                return goodRepository.findGoodsByCategoryIdOrderByBrandDesc(category);
            case BYNAMEASC:
                return goodRepository.findGoodsByCategoryIdOrderByNameAsc(category);
            case BYNAMEDESC:
                return goodRepository.findGoodsByCategoryIdOrderByNameDesc(category);
            case BYPRISEASC:
                return goodRepository.findGoodsByCategoryIdOrderByPriceAsc(category);
            case BYPRISEDESC:
                return goodRepository.findGoodsByCategoryIdOrderByPriceDesc(category);
        }
        return null;
    }
}
