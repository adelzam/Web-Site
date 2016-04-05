package com.springapp.mvc.services;

import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;


    @Transactional
    public GoodInfo getGoodById(Long id) {
        return goodRepository.getOne(id);
    }

    @Transactional
    public List<GoodInfo> getAllGoods() {
        return goodRepository.findAll();
    }

    @Transactional
    public void addNewGood(GoodInfo good) {
        goodRepository.save(good);
    }

    @Transactional
    public void deleteGood(Long id) {
        goodRepository.delete(id);
    }

    @Transactional
    public void updateGood(GoodInfo good) {
        //FIXME make update statement
    }

    public List<CategoryInfo> makeGoodPath(GoodInfo goodInfo){
        List<CategoryInfo> goodPath = new ArrayList<CategoryInfo>();
        CategoryInfo category = goodInfo.getCategory();
        while (category!=null) {
            goodPath.add(category);
            category = category.getParent();
        }
        Collections.reverse(goodPath);
        return goodPath;
    }
}
