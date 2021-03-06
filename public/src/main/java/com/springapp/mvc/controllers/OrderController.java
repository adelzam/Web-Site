package com.springapp.mvc.controllers;

import com.springapp.mvc.common.OrderInfo;
import com.springapp.mvc.form.FeedbackFormBean;
import com.springapp.mvc.form.NewOrderFormBean;
import com.springapp.mvc.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController {

    private static final String ATTR_NEWORDER_FORM = "orderForm";
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OrderService orderService;


    /**
     *
     * @return page with order form
     */

    @RequestMapping(method = RequestMethod.GET)
    public String renderFeedbackPage() {
        request.setAttribute(ATTR_NEWORDER_FORM, new NewOrderFormBean());
        return "order/newOrderPage";
    }

    /**
     *
     * @param orderFormBean
     * @param bindingResult
     * @param request
     * @param model
     * @return page with results and register order if all elemnts are correct
     */
    @RequestMapping(method = RequestMethod.POST)
    public String feedbackForm(@Valid @ModelAttribute(ATTR_NEWORDER_FORM) NewOrderFormBean orderFormBean,
                               BindingResult bindingResult, HttpServletRequest request, Model model) {
        if (bindingResult.hasErrors()) {
            return "order/newOrderPage";
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OrderInfo orderInfo = new OrderInfo(orderFormBean.getName(), orderFormBean.getAddress(),
                orderFormBean.getEmail(), orderFormBean.getPhone(),
                orderFormBean.getMessage(), null, new Date());
        model.addAttribute("ordernum",orderService.createNewOrder(orderInfo,userDetails.getUsername(), request).getId());
        return "order/result";
    }
}
