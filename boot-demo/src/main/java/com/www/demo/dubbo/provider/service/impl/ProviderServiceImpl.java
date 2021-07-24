package com.www.demo.dubbo.provider.service.impl;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import com.www.demo.utils.MyBeanUtils;
import com.www.dubbo.model.SysUserInfo;
import com.www.dubbo.service.ISysUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author www
 * @version 1.0
 * @description 生产者服务
 * @date 2021/7/5 22:45
 */
@Service
public class ProviderServiceImpl implements ISysUserInfoService {
    @Autowired
    private ISysUserService sysUserService;
    /**
     * @author www
     * @date 2021/7/24 09:39
     * @description 根据用户Id查询用户信息
     * @param userId 用户Id
     * @return com.www.model.dubbo.SysUserInfo
     */
    @Override
    public SysUserInfo findSysUserInfoById(String userId) {
        SysUser sysUser = sysUserService.selectByUserId(userId);
        if(sysUser != null){
            SysUserInfo sysUserInfo = new SysUserInfo();
            MyBeanUtils.copyProperties(sysUser,sysUserInfo);
            return sysUserInfo;
        }
        return null;
    }
}