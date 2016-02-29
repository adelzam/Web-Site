package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Service
public class CartService {

    public static final String CART = "sessionCart";

    public List<GoodInfo> addInCart(GoodInfo goodInfo, HttpServletRequest request) {
        List<GoodInfo> cart = (List<GoodInfo>) request.getSession().getAttribute(CART);
        if (cart == null) {
            cart = new ArrayList<GoodInfo>();
        }
        cart.add(goodInfo);
        request.getSession().setAttribute(CART,cart);
        return cart;
    }
}
