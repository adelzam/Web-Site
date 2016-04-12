package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private GoodService goodService;

    /**
     *
     * @param id
     * @param model
     * @return render good's page
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderGood(@PathVariable("id") Long id, ModelMap model) {
        GoodInfo good = goodService.getGoodById(id);
        model.addAttribute("goodPath", goodService.makeGoodPath(good));
        model.addAttribute("good", good);
        return "good/goodPage";

    }

    /**
     *
     * @param model
     * @return render catalog page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderAllGoods(ModelMap  model) {
        List<GoodInfo> goods = goodService.getAllGoods();
        model.addAttribute("goods", goods);
        return "redirect:/catalog";
    }
}
