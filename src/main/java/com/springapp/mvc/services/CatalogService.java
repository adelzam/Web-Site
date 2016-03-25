package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервис для работы с категориями товаров
 *
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
    public List<GoodInfo> getGoodsByCategoryId(Long categoryId) {
        List<GoodInfo> goods = new ArrayList<GoodInfo>();
        goods.add(new GoodInfo(1L, "Медведь", new CategoryInfo(1L, "name", null), new BigDecimal(100)));
        goods.add(new GoodInfo(2L, "Кукла 1", new CategoryInfo(1L, "name", null), new BigDecimal(200)));
        goods.add(new GoodInfo(3L, "Кукла 2",new CategoryInfo(1L, "name", null), new BigDecimal(200)));
        goods.add(new GoodInfo(4L, "Кукла 3", new CategoryInfo(1L, "name", null), new BigDecimal(200)));
        goods.add(new GoodInfo(5L, "Кукла 4", new CategoryInfo(1L, "name", null), new BigDecimal(200)));
        goods.add(new GoodInfo(6L, "Автомобиль Audi", new CategoryInfo(1L, "name", null), new BigDecimal(500)));
        goods.add(new GoodInfo(7L, "Автомобиль BMW", new CategoryInfo(1L, "name", null), new BigDecimal(500)));
        goods.add(new GoodInfo(8L, "Автомобиль Lada",new CategoryInfo(1L, "name", null), new BigDecimal(200)));
        return goods;
    }
}
