package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by adelzamalutdinov on 24.02.16.
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodService goodService;
    @Autowired
    private CartService cartService;

    /**
     * @param id
     * @return page with cart after add new good to cart
     * add new good to user's cart
     */
    @RequestMapping(value = "/add/{id}", method = {RequestMethod.GET})
    public String addToCart(@PathVariable("id") Long id) {
        GoodInfo goodInfo = goodService.getGoodById(id);
        cartService.addInCart(goodInfo, request);
        return "redirect:/cart";
    }

    /**
     * @return page with message that cart is empty
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderCart() {
        if (cartService.emptyCart(request)) return "cart/emptyCart";
        return "cart/cartMain";
    }

    /**
     * @param index
     * @return page with cart after remote some good from cart
     * remote user's cart after some action
     */
    @RequestMapping(value = "/remote/{index}", method = {RequestMethod.GET})
    public String remoteFromCart(@PathVariable("index") Integer index) {
        cartService.remoteFromCart(index, request);
        return "redirect:/cart";
    }
}
