package com.springapp.mvc.controllers;

import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.CatalogService;
import com.springapp.mvc.services.filters.GoodsFiltersServies;
import com.springapp.mvc.utils.OrderTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for work with catalog
 */
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private GoodsFiltersServies goodsFiltersServies;

    /**
     * Catalog view
     *
     * @param id    id of category
     * @param page  page count
     * @param limit count of goods in page view
     * @return catalog view
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                @RequestParam(value = "page", required = false, defaultValue = "1") String page,
                                Long limit,
                                Model model) {
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId(id);
        model.addAttribute("goods", goods);
        model.addAttribute("category", goods.get(0).getCategory().getName());
        return "catalog/catalog";
    }

    /**
     * view of main catalog page
     */
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String mainCatalog(HttpServletRequest request) {
        request.setAttribute("message", "Главная страница каталога");
        return "catalog/catalogMain";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, params = "order")
    public String renderCatalogByOrder(@PathVariable("id") Long id,
                                       @RequestParam("order") OrderTypes orderTypes,
                                       Model model) {
        List<GoodInfo> goods = goodsFiltersServies.orderBy(orderTypes, id);
        model.addAttribute("goods", goods);
        model.addAttribute("category", goods.get(0).getCategory().getName());
        return "catalog/catalog";
    }
}
