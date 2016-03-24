package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Service
public class GoodService {

    public GoodInfo getGoodById(Long id) {
        return new GoodInfo(id, "новая игрушка", 2l, new BigDecimal(199));
    }
}
