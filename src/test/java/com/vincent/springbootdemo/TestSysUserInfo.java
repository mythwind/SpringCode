package com.vincent.springbootdemo;

import com.vincent.springbootdemo.dao.SysUserInfoMapper;
import com.vincent.springbootdemo.dao.VedioInfoMapper;
import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.entity.VedioInfo;
import com.vincent.springbootdemo.utils.DateHelper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestSysUserInfo extends SpringbootdemoApplicationTests {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    @Autowired
    private VedioInfoMapper vedioInfoMapper;

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
    public void testSaveVedio() {
        VedioInfo info = new VedioInfo();
        //vedio_url,vedio_status,vedio_type,vedio_title,author_id,author_idea,main_image,create_time,update_time,user_good_thumbs,
        String filename = "Warcraft3_End.mp4";
        info.setVedioUrl(filename);
        info.setVedioDesc("Desc");
        info.setVedioTitle(filename.substring(0,filename.lastIndexOf(".")));
        info.setVedioType(1);
        info.setVedioStatus(1);
        info.setAuthorId(123);
        info.setAuthorIdea("mythwind");
        info.setCreateTime(DateHelper.getCurrTimestamp());
        int result = vedioInfoMapper.saveVedioInfo(info);
        System.out.println("==========result===" + result);
    }
    @Test
    public void testFindVedio() {
        List<VedioInfo> lists = vedioInfoMapper.findVedioInfo();
        for (VedioInfo info: lists) {
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
