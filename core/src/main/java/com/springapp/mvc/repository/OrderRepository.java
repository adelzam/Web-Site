package com.springapp.mvc.repository;

import com.springapp.mvc.common.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by adelzamalutdinov on 31.03.16.
 */
public interface OrderRepository extends JpaRepository<OrderInfo, Long> {
}
