package com.springapp.mvc.services;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adelzamalutdinov on 08.04.16.
 */
@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public BrandInfo getBrandById(Long id) {
        return brandRepository.findOne(id);
    }
}
