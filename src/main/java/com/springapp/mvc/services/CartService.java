package com.springapp.mvc.services;

import com.springapp.mvc.common.GoodInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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
       BigDecimal sum = (BigDecimal) request.getSession().getAttribute("sum");
        if (cart == null) {
            cart = new ArrayList<GoodInfo>();
            sum = BigDecimal.valueOf(0);
        }
        cart.add(goodInfo);
        request.getSession().setAttribute(CART,cart);
        request.getSession().setAttribute("goodcount", (Integer) cart.size());
        request.getSession().setAttribute("sum", sum.add(goodInfo.getPrice().setScale(2)));
        return cart;
    }
}
