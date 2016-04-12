package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeTopGoods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	/**
	 * @return main page
     */
	@IncludeTopGoods
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome() {
		return "main/main";
	}

	@RequestMapping(value = "/not-yet", method = RequestMethod.GET)
	public String renderNotYetPage() {
		return "main/notyet";
	}
}