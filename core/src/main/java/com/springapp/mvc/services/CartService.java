package com.springapp.mvc.services;

import com.springapp.mvc.common.CartInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.repository.CartRepository;
import com.springapp.mvc.repository.GoodRepository;
import com.springapp.mvc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Service
public class CartService {

    public static final String CART = "sessionCart";
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Transactional
    public List<CartInfo> addInCart(GoodInfo goodInfo, HttpServletRequest request) {
        BigDecimal sum = (BigDecimal) request.getSession().getAttribute("sum");
        Integer goodcount = (Integer) request.getSession().getAttribute("goodcount");
        OrderInfo orderInfo = orderRepository.findOrderInfoByName(String.valueOf(request.getSession().getId()));
        if (sum == null) {
            sum = BigDecimal.valueOf(0);
            goodcount = 0;
        }
        if (orderInfo == null) {
            orderRepository.save(new OrderInfo(String.valueOf(request.getSession().getId())));
            orderInfo = orderRepository.findOrderInfoByName(String.valueOf(request.getSession().getId()));
        }
        CartInfo cartInfo = cartRepository.findCartInfoByOrderInfoAndGoodInfo(orderInfo, goodInfo);
        if (cartInfo == null) {
            cartInfo = new CartInfo(goodInfo, orderInfo, 1);
        } else {
            cartInfo.setNumber(cartInfo.getNumber() + 1);
        }
        goodcount++;
        sum = sum.add(goodInfo.getPrice().setScale(2));
        cartRepository.save(cartInfo);
        List<CartInfo> cart = cartRepository.findCartsInfoByOrderInfo(orderInfo);
        request.getSession().setAttribute(CART, cart);
        request.getSession().setAttribute("goodcount", goodcount);
        request.getSession().setAttribute("sum", sum);
        return cart;
    }

    public boolean emptyCart(HttpServletRequest request) {
        List<GoodInfo> cart = (List<GoodInfo>) request.getSession().getAttribute(CART);
        if ((cart == null) || (cart.size() == 0)) return true;
        else return false;
    }

    @Transactional
    public List<CartInfo> remoteFromCart(Integer index, HttpServletRequest request) {
        BigDecimal sum = (BigDecimal) request.getSession().getAttribute("sum");
        Integer goodcount = (Integer) request.getSession().getAttribute("goodcount");
        OrderInfo orderInfo = orderRepository.findOrderInfoByName(String.valueOf(request.getSession().getId()));
        List<CartInfo> cart = cartRepository.findCartsInfoByOrderInfo(orderInfo);
        GoodInfo good = cart.get(index).getGoodInfo();
        CartInfo cartInfo = cart.get(index);
        request.getSession().setAttribute("sum", sum.subtract(good.getPrice().setScale(2)));
        if (cartInfo.getNumber() == 1) {
            cartRepository.delete(cartInfo);
            cart.remove(index.intValue());
        } else {
            cartInfo.setNumber(cartInfo.getNumber() - 1);
            cart.set(index, cartInfo);
            cartRepository.save(cartInfo);
        }
        goodcount--;
        request.getSession().setAttribute(CART, cart);
        request.getSession().setAttribute("goodcount", goodcount);
        return cart;
    }

    @Transactional
    public void clearCart(HttpServletRequest request) {
        OrderInfo orderInfo = orderRepository.findOrderInfoByName(String.valueOf(request.getSession().getId()));
        cartRepository.deleteByOrderInfo(orderInfo);
        request.getSession().setAttribute(CART, null);
        request.getSession().setAttribute("goodcount", 0);
        request.getSession().setAttribute("sum", BigDecimal.valueOf(0));
    }

    @Transactional
    public List<CartInfo> remoteGood(Integer index, HttpServletRequest request) {
        BigDecimal sum = (BigDecimal) request.getSession().getAttribute("sum");
        Integer goodcount = (Integer) request.getSession().getAttribute("goodcount");
        OrderInfo orderInfo = orderRepository.findOrderInfoByName(String.valueOf(request.getSession().getId()));
        List<CartInfo> cart = cartRepository.findCartsInfoByOrderInfo(orderInfo);
        GoodInfo good = cart.get(index).getGoodInfo();
        CartInfo cartInfo = cart.get(index);
        request.getSession().setAttribute("sum", sum.subtract(good.getPrice().multiply(
                BigDecimal.valueOf(cartInfo.getNumber()))).setScale(2));
        request.getSession().setAttribute("goodcount", goodcount - cartInfo.getNumber());
        cart.remove(index.intValue());
        cartRepository.delete(cartInfo);
        request.getSession().setAttribute(CART, cart);
        return cart;
    }
}
