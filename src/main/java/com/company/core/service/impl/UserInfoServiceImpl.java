package com.company.core.service.impl;

import com.company.core.bean.UserInfo;
import com.company.core.repository.UserInfoRepository;
import com.company.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String name) {
        return userInfoRepository.findByUsername(name);
    }

}
