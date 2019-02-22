package com.vincent.springbootdemo.dao;

import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.entity.VedioInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VedioInfoMapper {

    public int saveVedioInfo(VedioInfo info);

    public List<VedioInfo> findVedioInfo();

}
