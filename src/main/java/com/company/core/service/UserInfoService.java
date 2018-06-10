package com.company.core.service;

import com.company.core.bean.UserInfo;

public interface UserInfoService {

    public UserInfo findByUsername(String name);

}
