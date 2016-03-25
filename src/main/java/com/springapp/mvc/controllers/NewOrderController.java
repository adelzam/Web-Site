package com.springapp.mvc.controllers;

import com.springapp.mvc.form.NewOrderFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Controller
@RequestMapping("/order")
public class NewOrderController {

    public static final String ATTT_NEW_ORDER_FORM = "newOrderForm";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String renderNewOrderPage(){
        request.setAttribute(ATTT_NEW_ORDER_FORM, new NewOrderFormBean());
        return "order/newOrderPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String newOrderForm(@Valid @ModelAttribute(ATTT_NEW_ORDER_FORM) NewOrderFormBean newOrderFromBean, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "order/newOrderPage";
        }
        //Here we need to add new order in database
        System.out.println(newOrderFromBean);
        return "order/result";
    }
}

