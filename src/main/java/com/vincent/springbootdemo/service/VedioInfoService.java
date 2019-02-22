package com.vincent.springbootdemo.service;

import com.vincent.springbootdemo.entity.SysUserInfo;
import com.vincent.springbootdemo.entity.VedioInfo;
import com.vincent.springbootdemo.entity.common.ResultEntity;

import java.util.List;

public interface VedioInfoService {

    public List<VedioInfo> findVedioInfoByType(int vedioType, String vedioTitle);
    public List<VedioInfo> findVedioInfo();
    public boolean saveVedioInfo(VedioInfo info);

}
