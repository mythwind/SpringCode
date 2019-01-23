package com.vincent.springbootdemo.service;

import com.vincent.springbootdemo.entity.ResultEntity;
import com.vincent.springbootdemo.entity.SysUserInfo;

import java.util.Map;

public interface SysUserInfoService {

    public SysUserInfo findByUsername(String username);
    public ResultEntity login(String username, String password);
    public int saveSysUserInfo(SysUserInfo userInfo);
    public int updateSysUser(SysUserInfo userInfo);
    public int deleteByUsername(String username);
}
