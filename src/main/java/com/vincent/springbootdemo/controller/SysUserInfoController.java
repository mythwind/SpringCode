package com.vincent.springbootdemo.controller;

import com.vincent.springbootdemo.dao.SysUserInfoMapper;
import com.vincent.springbootdemo.entity.ResultEntity;
import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.service.SysUserInfoService;
import com.vincent.springbootdemo.utils.MyConstants;
import com.vincent.springbootdemo.utils.text.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class SysUserInfoController extends BaseController {
    @Autowired
    private SysUserInfoService sysUserInfoService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "login";
    }


    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity login(SysUserInfo user, Model model) {
        logger.info("login===这是一个info日志");
        logger.warn("login这是一个warn日志");
        logger.error("login这是一个error日志");

        ResultEntity resultEntity = sysUserInfoService.login(user.getUsername(), user.getPassword());

        logger.info("===2132=======" + resultEntity.getT().toString());
        if (resultEntity.getCode() == MyConstants.MSG_LOGIN_SUCESSED)
            model.addAttribute("user", resultEntity.getT());//将user存放到session
        return resultEntity;
    }
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
