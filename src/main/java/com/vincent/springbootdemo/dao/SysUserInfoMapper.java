package com.vincent.springbootdemo.dao;

import com.vincent.springbootdemo.entity.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserInfoMapper {

    //@Select("select * from sys_user_info where username = #{username}")
    public List<SysUserInfo> findByUsername(@Param("username") String username);
    public SysUserInfo login(@Param("username") String username, @Param("password") String password);
    public List<SysUserInfo> findAllUsers();
    public int saveSysUserInfo(SysUserInfo userInfo);
    public int updateSysUser(SysUserInfo userInfo);
    public int deleteByUsername(@Param("username") String username);
}
