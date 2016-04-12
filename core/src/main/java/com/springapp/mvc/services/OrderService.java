package com.springapp.mvc.services;

import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;


@Service
public class OrderService {
    public static final String CART = "sessionCart";
    @Autowired
    private OrderRepository orderRepository;

    /**
     *
     * @param orderInfo
     * @param request
     * @return service witch put into db new order
     */

    public OrderInfo createNewOrder(OrderInfo orderInfo, HttpServletRequest request) {
        OrderInfo cessionOrder = orderRepository.findOrderInfoByName(String.valueOf(request.getSession().getId()));
        orderInfo.setId(cessionOrder.getId());
        orderRepository.save(orderInfo);
        request.getSession().setAttribute(CART, null);
        request.getSession().setAttribute("goodcount", 0);
        request.getSession().setAttribute("sum", BigDecimal.valueOf(0));
        return orderInfo;
    }

}
