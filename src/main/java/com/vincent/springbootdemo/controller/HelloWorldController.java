package com.vincent.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class HelloWorldController extends BaseController {

    @RequestMapping(value = {"", "index"})
    public String index() {
        //return VIEW_INDEX;

        return "jsp/manager/test";
    }

    @RequestMapping(value = {"/mindex"})
    public String mindex() {
        return VIEW_M_INDEX;
    }

    @RequestMapping("/thymeleaf_test")
    public String thymeleaf_test(ModelMap map) {
        map.put("text", "hello");
        map.put("href", "http://www.fengyunxiao.cn");
        return "thymeleaf_test";
    }

}
