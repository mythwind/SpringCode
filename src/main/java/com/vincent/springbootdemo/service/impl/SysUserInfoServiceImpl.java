package com.vincent.springbootdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.vincent.springbootdemo.dao.SysUserInfoMapper;
import com.vincent.springbootdemo.entity.common.ResultEntity;
import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.service.SysUserInfoService;
import com.vincent.springbootdemo.utils.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public List<SysUserInfo> findByUsername(String username) {
        List<SysUserInfo> list = sysUserInfoMapper.findByUsername(username);
        // 具体使用
        redisTemplate.opsForList().leftPush("user:user", JSON.toJSONString(list));
        return list;
    }

    @Override
    public ResultEntity login(String username, String password) {
        List<SysUserInfo> list = sysUserInfoMapper.findByUsername(username);
        if (null == list || list.size() < 1) {
            return new ResultEntity(MyConstants.MSG_LOGIN_USER_NOT_EXISTS, "用户名错误！");
        }
        SysUserInfo user = sysUserInfoMapper.login(username, password);
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
