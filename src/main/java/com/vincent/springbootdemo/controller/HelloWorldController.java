package com.vincent.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController extends BaseController {

    @RequestMapping(value={"","index"})
    public String index() {
        return VIEW_INDEX;
    }

    @RequestMapping("/vedio")
    public String vedio() {
        return "vedio_play";
    }

    @RequestMapping("/thymeleaf_test")
    public String thymeleaf_test(ModelMap map) {
        map.put("text", "hello");
        map.put("href", "http://www.fengyunxiao.cn");
        return "thymeleaf_test";
    }

}
