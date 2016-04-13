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


@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;

    /**
     *
     * @return list of top goods
     * use for aspect
     */
    @Transactional
    public List<GoodInfo> getTopGoods() {
        return goodRepository.findTop6ByOrderByPopularityAsc();
    }

    /**
     *
     * @param id
     * @return good by id form db
     */
    @Transactional
    public GoodInfo getGoodById(Long id) {
        return goodRepository.getOne(id);
    }

    /**
     *
     * @return all goods
     */
    @Transactional
    public List<GoodInfo> getAllGoods() {
        return goodRepository.getAllByOrderById();
    }

    /**
     *
     * @param good add new good to db
     *             use only by admin
     */
    @Transactional
    public void addNewGood(GoodInfo good) {
        goodRepository.save(good);
    }

    /**
     *
     * @param id
     * delete good from db
     * use only by admin
     */
    @Transactional
    public void deleteGood(Long id) {
        goodRepository.delete(id);
    }

    /**
     *
     * @param good
     * update good information
     * use only by admin
     */
    @Transactional
    public void updateGood(GoodInfo good) {
        goodRepository.save(good);
    }

    /**
     *
     * @param goodInfo
     * @return path to good in catalog
     */
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
