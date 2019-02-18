package com.vincent.springbootdemo;

import com.vincent.springbootdemo.dao.SysUserInfoMapper;
import com.vincent.springbootdemo.entity.SysUserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestSysUserInfo extends SpringbootdemoApplicationTests {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Test
    public void testFind() {
        List<SysUserInfo> s = sysUserInfoMapper.findByUsername("mythwind");
        Assert.assertEquals("mythwindwang", s.get(0).getNickname());
    }
    // INSERT INTO sys_user_info(username,nickname,password,email,telephone,ip,birthday,sex)
    // VALUES('mythwind','mythwind','111111','qq.com','1','1','1',1)
    @Test
    public void testSave() {
        SysUserInfo user = new SysUserInfo();
        user.setUsername("name1");
        user.setNickname("name1");
        user.setPassword("123456");
        user.setEmail("qq.com");
        int x = sysUserInfoMapper.saveSysUserInfo(user);
        System.out.println("x===========" + x);
        List<SysUserInfo> lists = sysUserInfoMapper.findAllUsers();
        for (SysUserInfo info: lists) {
            System.out.println(info.toString());
        }
    }
    @Test
    public void testFindAll(){
        System.out.println("x===========");
        List<SysUserInfo> lists = sysUserInfoMapper.findAllUsers();
        for (SysUserInfo info: lists) {
            System.out.println(info.toString());
        }
    }
}
