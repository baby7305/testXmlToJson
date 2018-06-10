package com.company.core.repository;

import com.company.core.bean.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户持久化类.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年10月14日
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
	
	//通过用户名查找用户信息.
	public UserInfo findByUsername(String name);
}
