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

@Controller
@RequestMapping("/login")
public class SysUserInfoController {
    @Autowired
    private SysUserInfoService sysUserInfoService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity login(SysUserInfo user, Model model) {
        System.out.println(user.toString());
        ResultEntity resultEntity = sysUserInfoService.login(user.getUsername(), user.getPassword());
        if (resultEntity.getCode() == MyConstants.MSG_LOGIN_SUCESSED)
            model.addAttribute("user", resultEntity.getT());//将user存放到session
        return resultEntity;
    }
    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
