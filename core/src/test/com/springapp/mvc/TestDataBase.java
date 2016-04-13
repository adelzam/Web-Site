package com.springapp.mvc;

import com.springapp.mvc.common.BrandInfo;
import com.springapp.mvc.common.CategoryInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.BrandService;
import com.springapp.mvc.services.CategoryService;
import com.springapp.mvc.services.GoodService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;

import static junit.framework.Assert.*;

public class TestDataBase {

    private  ApplicationContext applicationContext;
    @Test
    public void testGetBrand() {
        applicationContext = new ClassPathXmlApplicationContext("spring-core.xml");
        BrandService brandService = applicationContext.getBean(BrandService.class);
//        CategoryInfo category = new CategoryInfo(2L, "Молотый кофе", new CategoryInfo(1L, "Кофе", null));
        BrandInfo brandInfo = new BrandInfo(2L, "Lavazza", "lavazza.jpg", "lavazza/lavazzabanner.jpg");
//        GoodInfo good = new GoodInfo(1L, "Cream&Gusto", brandInfo, "Италия", BigDecimal.valueOf(350.00), category,
//        "lavazza/lavazzaCremaGusto.jpg", "Кофе 250 грамм", 1, null);
//        assertEquals(good, goodService.getGoodById(1L));
        assertEquals(brandInfo, brandService.getBrandById(2L));
    }
}
