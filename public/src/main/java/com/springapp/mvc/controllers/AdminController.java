package com.springapp.mvc.controllers;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.BrandRepository;
import com.springapp.mvc.repository.GoodRepository;
import com.springapp.mvc.services.BrandService;
import com.springapp.mvc.services.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private GoodService goodService;
    @Autowired
    private BrandService brandService;

    @RequestMapping(method = {RequestMethod.GET})
    public String renderAdminPage(Model model) {
        model.addAttribute("goods", (List<GoodInfo>) goodService.getAllGoods());
        model.addAttribute("brands", (List<BrandInfo>) brandService.findAll());
        return "admin/admin-page";
    }

    @RequestMapping(value = "/deletegood/{id}", method = {RequestMethod.GET})
    public String deleteGoodFromDB(@PathVariable("id") Long id){
        goodService.deleteGood(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deletebrand/{id}", method = {RequestMethod.GET})
    public String deleteBrandFromDB(@PathVariable("id") Long id){
        brandService.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/newgood", method = {RequestMethod.GET})
    public String addNewGoodToDB(){
        return "redirect:/not-yet";
    }

    @RequestMapping(value = "/newbrand", method = {RequestMethod.GET})
    public String addNewBrandToDB(){
        return "redirect:/not-yet";
    }
}
