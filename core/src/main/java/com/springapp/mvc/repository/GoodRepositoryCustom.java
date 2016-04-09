package com.springapp.mvc.repository;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 09.04.16.
 */
public interface GoodRepositoryCustom {

    List<GoodInfo> getGoodsInOrder(String order, BrandInfo brand, List<Long> category);
}
