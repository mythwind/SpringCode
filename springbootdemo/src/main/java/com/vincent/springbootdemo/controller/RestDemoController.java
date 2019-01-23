package com.vincent.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 返回的是 json
 * @Controller 返回的是 jsp
 */
@RestController
public class RestDemoController {

    @RequestMapping("/demo")
    public String index() {
        return "index";
    }
}
