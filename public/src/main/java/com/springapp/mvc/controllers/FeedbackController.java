package com.springapp.mvc.controllers;

import com.springapp.mvc.form.FeedbackFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    private static final String ATTR_FEEDBACK_FORM = "feedbackForm";

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public String renderFeedbackPage() {
        request.setAttribute(ATTR_FEEDBACK_FORM, new FeedbackFormBean());
        return "feedback/feedbackPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String feedbackForm(@Valid @ModelAttribute(ATTR_FEEDBACK_FORM) FeedbackFormBean feedbackFormBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "feedback/feedbackPage";
        }
        // здесь должна происходить регистрация пользователя
        System.out.println(feedbackFormBean);
        return "feedback/result";
    }
}
