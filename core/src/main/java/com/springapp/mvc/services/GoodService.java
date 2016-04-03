package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Service
public class GoodService {
    private CatalogService catalogService;

    public GoodInfo getGoodById(Long id) {
        return new GoodInfo(id, "новая игрушка", new CategoryInfo(1L, "name", null), new BigDecimal(199));
    }

    public List<GoodInfo> getAllGoods() {
        //FIXME Add connection with database and read all goods from it
        return catalogService.getGoodsByCategoryId(1L);
    }
}
