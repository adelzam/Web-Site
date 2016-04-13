package com.springapp.mvc.services;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by adelzamalutdinov on 08.04.16.
 */
@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    /**
     * @param id - id of brand
     * @return brand witch have such id
     */
    public BrandInfo getBrandById(Long id) {
        return brandRepository.findOne(id);
    }

    public void delete(Long id) {
        brandRepository.delete(new BrandInfo(id));
    }

    public List<BrandInfo> findAll() {
        return brandRepository.findAllByOrderById();
    }
}
