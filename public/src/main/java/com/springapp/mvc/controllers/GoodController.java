package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by adelzamalutdinov on 25.03.16.
 */
@Controller
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderGood(@PathVariable("id") Long id, ModelMap model) {
        GoodInfo good = goodService.getGoodById(id);
        model.addAttribute("good", good);
        return "good/goodPage";

    }
    @RequestMapping(method = RequestMethod.GET)
    public String renderAllGoods(ModelMap  model) {
        List<GoodInfo> goods = goodService.getAllGoods();
        model.addAttribute("goods", goods);
        return "redirect:/catalog";
    }
}
