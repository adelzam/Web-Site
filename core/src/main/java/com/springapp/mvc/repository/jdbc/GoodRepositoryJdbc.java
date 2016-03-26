package com.springapp.mvc.repository.jdbc;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.GoodRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Repository
public class GoodRepositoryJdbc implements GoodRepository {

    @Override
    public void addGood(GoodInfo goodInfo) {

    }

    @Override
    public void updateGood(GoodInfo goodInfo) {

    }

    @Override
    public void deleteGood(Long goodId) {

    }

    @Override
    public GoodInfo getGoodById(Long goodId) {
        return null;
    }

    @Override
    public List<GoodInfo> getGoodsByCategory(CategoryInfo categoryInfo) {
        return null;
    }

    @Override
    public List<GoodInfo> getAllGood() {
        return null;
    }
}
