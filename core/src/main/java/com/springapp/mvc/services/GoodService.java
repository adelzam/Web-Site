package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Service
public class GoodService {
    @Autowired
    private GoodRepository goodRepository;

    public GoodInfo getGoodById(Long id) {
        return goodRepository.getOne(id);
    }

    public List<GoodInfo> getAllGoods() {
        return goodRepository.findAll();
    }

    public void addNewGood(GoodInfo good) {
        goodRepository.save(good);
    }

    public void deleteGood(Long id) {
        goodRepository.delete(id);
    }

    public void updateGood(GoodInfo good) {
        //FIXME make update statement
    }
}
