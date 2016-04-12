package com.springapp.mvc.controllers;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.repository.BrandRepository;
import com.springapp.mvc.repository.GoodRepository;
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
    private GoodRepository goodRepository;
    @Autowired
    private BrandRepository brandRepository;

    @RequestMapping(method = {RequestMethod.GET})
    public String renderAdminPage(Model model) {
        model.addAttribute("goods", (List<GoodInfo>) goodRepository.findAll());
        model.addAttribute("brands", (List<BrandInfo>) brandRepository.findAll());
        return "admin/admin-page";
    }

    @RequestMapping(value = "/deletegood/{id}", method = {RequestMethod.GET})
    public String deleteGoodFromDB(@PathVariable("id") Long id){
        goodRepository.delete(new GoodInfo(id));
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deletebrand/{id}", method = {RequestMethod.GET})
    public String deleteBrandFromDB(@PathVariable("id") Long id){
        brandRepository.delete(new BrandInfo(id));
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
