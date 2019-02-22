package com.vincent.springbootdemo.service.impl;

import com.vincent.springbootdemo.dao.VedioInfoMapper;
import com.vincent.springbootdemo.entity.VedioInfo;
import com.vincent.springbootdemo.service.VedioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: mythwind
 * @Date: 2019/02/21 19:53
 * @Description:
 */
@Service
public class VedioInfoServiceImpl implements VedioInfoService {

    @Autowired
    private VedioInfoMapper vedioInfoMapper;

    @Override
    public List<VedioInfo> findVedioInfoByType(int vedioType, String vedioTitle) {
        return null;
    }

    @Override
    public List<VedioInfo> findVedioInfo() {
        return vedioInfoMapper.findVedioInfo();
    }

    @Override
    public boolean saveVedioInfo(VedioInfo info) {
        int result = vedioInfoMapper.saveVedioInfo(info);
        return result > 0;
    }
}
