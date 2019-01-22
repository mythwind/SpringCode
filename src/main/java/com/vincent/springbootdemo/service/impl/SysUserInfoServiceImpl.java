package com.vincent.springbootdemo.service.impl;

import com.vincent.springbootdemo.dao.SysUserInfoMapper;
import com.vincent.springbootdemo.entity.ResultEntity;
import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.service.SysUserInfoService;
import com.vincent.springbootdemo.utils.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public SysUserInfo findByUsername(String username) {
        return sysUserInfoMapper.findByUsername(username);
    }

    @Override
    public ResultEntity login(String username, String password) {
       SysUserInfo user = sysUserInfoMapper.findByUsername(username);
        if (null == user) {
            return new ResultEntity(MyConstants.MSG_LOGIN_USER_NOT_EXISTS, "用户名错误！");
        }
        user = sysUserInfoMapper.login(username, password);
        if (null == user) {
            return new ResultEntity(MyConstants.MSG_LOGIN_PASSWORD_ERROR, "密码错误！");
        }
        ResultEntity<SysUserInfo> entity = new ResultEntity(MyConstants.MSG_LOGIN_SUCESSED, "登陆成功");
        entity.setT(user);
        return entity;
    }

    @Override
    public int saveSysUserInfo(SysUserInfo userInfo) {
        return sysUserInfoMapper.saveSysUserInfo(userInfo);
    }

    @Override
    public int updateSysUser(SysUserInfo userInfo) {
        return sysUserInfoMapper.updateSysUser(userInfo);
    }

    @Override
    public int deleteByUsername(String username) {
        return sysUserInfoMapper.deleteByUsername(username);
    }
}
