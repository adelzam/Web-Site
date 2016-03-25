package com.springapp.mvc.repository;

import com.springapp.mvc.common.GoodInfo;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
public interface GoodRepository {

    void addGood(GoodInfo goodInfo);

    void updateGood(GoodInfo goodInfo);

    void deleteGood(Long goodId);

    GoodInfo getGoodById(Long goodId);

    List<GoodInfo> getAllGood();
}
