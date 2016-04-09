package com.springapp.mvc.repository;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by adelzamalutdinov on 04.04.16.
 */
public interface CartRepository extends JpaRepository<CartInfo, Long> {

    List<CartInfo> findCartsInfoByOrderInfo(OrderInfo orderInfo);

    CartInfo findCartInfoByOrderInfoAndGoodInfo(OrderInfo orderInfo, GoodInfo goodInfo);

    void deleteByOrderInfo(OrderInfo orderInfo);
}
