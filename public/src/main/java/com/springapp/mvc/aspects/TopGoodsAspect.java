package com.springapp.mvc.aspects;

import com.springapp.mvc.common.FilterInfo;
import com.springapp.mvc.common.GoodInfo;
import com.springapp.mvc.services.FilterServiсe;
import com.springapp.mvc.services.GoodService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by adelzamalutdinov on 10.04.16.
 */
@Aspect
@Component
public class TopGoodsAspect {

    private static final String TOP_GOODS_LIST = "top";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private GoodService goodService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeTopGoods)")
    public void includeTopGoodsMethod() {

    }

    /**
     * render of top goods
     */
    @Before("includeTopGoodsMethod()")
    public void includeTopGoods() {
        List<GoodInfo> goods = goodService.getTopGoods();
        request.setAttribute(TOP_GOODS_LIST, goods);
    }
}
