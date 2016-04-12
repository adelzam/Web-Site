package com.springapp.mvc.aspects;

import com.springapp.mvc.common.FilterInfo;
import com.springapp.mvc.services.FilterServiсe;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by adelzamalutdinov on 09.04.16.
 */
@Aspect
@Component
public class FiltersAspect {

    private static final String FILTER_LIST = "filters";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private FilterServiсe filterSevice;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeFilterInfo)")
    public void includeFilterInfoMethod() {

    }

    /**
     * render of filters list
     */
    @Before("includeFilterInfoMethod()")
    public void includeFilterInfo() {
        List<FilterInfo> filters = filterSevice.getAllFilters();
        request.setAttribute(FILTER_LIST, filters);
    }
}
