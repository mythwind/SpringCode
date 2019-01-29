package com.vincent.springbootdemo.controller;

import com.vincent.springbootdemo.utils.text.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    public static final String PREFIX_JSP = "jsp/";
    protected static final String VIEW_INDEX = "jsp/index";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected String jspView(String viewName) {
        if(TextUtils.isEmpty(viewName)) {
            return "jsp/index";
        }
        return PREFIX_JSP + viewName;
    }
    protected String thymeleafView(String viewName) {
        if(TextUtils.isEmpty(viewName)) {
            return "jsp/index";
        }
        return PREFIX_JSP + viewName;
    }

}
