package com.springapp.mvc.repositories;

import com.springapp.mvc.common.GoodInfo;

/**
 * Created by adelzamalutdinov on 22.03.16.
 */
public interface GoodRepository {

    void addGood(GoodInfo goodInfo);

    void updateGood(GoodInfo goodInfo);

    void deleteGood(Long goodId);

    GoodInfo getGoodById(Long goodId);
}

