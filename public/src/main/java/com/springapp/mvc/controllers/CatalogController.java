package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeFilterInfo;
import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.BrandService;
import com.springapp.mvc.services.CatalogService;
import com.springapp.mvc.services.CategoryService;
import com.springapp.mvc.services.FilterServiсe;
import com.springapp.mvc.utils.OrderTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private FilterServiсe goodsFiltersService;

    /**
     * Catalog view
     *
     * @param id id of category
     * @return catalog view
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String renderCatalog(@PathVariable("id") Long id,
                                Model model) {
        List<GoodInfo> goods = catalogService.getGoodsByCategoryId(id);
        List<BrandInfo> brands = new ArrayList<BrandInfo>();
        for (GoodInfo good : goods) {
            if (brands.isEmpty() || (brands.indexOf(good.getBrand()) == -1)) {
                brands.add(good.getBrand());
            }
        }
        if (brands.size() > 1) {
            brands.add(brandService.getBrandById(0L));
        }
        model.addAttribute("brands", brands);
        model.addAttribute("goods", goods);
        model.addAttribute("category", categoryService.getCategoryInfo(id));
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

    /**
     * Catalog view
     *
     * @param id         id of category
     * @param orderTypes type of goods order
     * @return page with list of goods in the determined order in category
     */
    @IncludeFilterInfo
    @RequestMapping(value = "/{id}/{brand}", method = RequestMethod.GET, params = "order")
    public String renderCatalogByOrder(@PathVariable("id") Long id, @PathVariable("brand") Long brand,
                                       @RequestParam("order") String orderTypes,
                                       Model model) {
        List<GoodInfo> goods = goodsFiltersService.orderBy(OrderTypes.valueOf(orderTypes.toUpperCase()), id, brand);
        model.addAttribute("goods", goods);
        model.addAttribute("brands", null);
        if (brand != 0) {
            model.addAttribute("banner", goods.get(0).getBrand().getBannerURL());
        }
        model.addAttribute("category", categoryService.getCategoryInfo(id));
        return "catalog/catalog";
    }

    /**
     * Catalog view
     *
     * @param id    id of category
     * @param brand name of brand, which need render in page
     * @return page with list of good with determined brand and category
     */

    @IncludeFilterInfo
    @RequestMapping(value = "/{id}/{brand}", method = RequestMethod.GET)
    public String renderCatalogByBrandAndCategory(@PathVariable("id") Long id,
                                                  @PathVariable("brand") Long brand,
                                                  Model model) {
        List<GoodInfo> goods = null;
        String banner = null;
        if (brand != 0) {
            goods = catalogService.getGoodsByCategoryIdAndBrand(id, brand);
            banner = goods.get(0).getBrand().getBannerURL();
        } else {
            goods = catalogService.getGoodsByCategoryId(id);
        }
        model.addAttribute("goods", goods);
        model.addAttribute("brands", null);
        model.addAttribute("banner", banner);
        model.addAttribute("category", categoryService.getCategoryInfo(id));
        return "catalog/catalog";
    }
}
