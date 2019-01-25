package com.vincent.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/vedio")
    public String vedio() {
        return "vedio_play";
    }


}
