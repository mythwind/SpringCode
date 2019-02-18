package com.vincent.springbootdemo.service;

import com.vincent.springbootdemo.entity.common.ResultEntity;
import com.vincent.springbootdemo.entity.SysUserInfo;

import java.util.List;

public interface SysUserInfoService {

    public List<SysUserInfo> findByUsername(String username);
    public ResultEntity login(String username, String password);
    public int saveSysUserInfo(SysUserInfo userInfo);
    public int updateSysUser(SysUserInfo userInfo);
    public int deleteByUsername(String username);
}
