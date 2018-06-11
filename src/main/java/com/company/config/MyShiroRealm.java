package com.company.config;

import com.company.core.bean.SysPermission;
import com.company.core.bean.SysRole;
import com.company.core.bean.UserInfo;
import com.company.core.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    /**
     *  身份认证 --- 登录.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        /*
         *  1、 获取用户输入的账号.
         *  2、通过username 从数据库中进行查找，活到UserInfo对象.
         *  3、加密. 使用SimpleAuthenticationInfo 进行身份处理.
         *  4、返回身份处理对象.
         */
        //1、 获取用户输入的账号.
        String username = (String)token.getPrincipal();

        //2、通过username 从数据库中进行查找，活到UserInfo对象.
        UserInfo userInfo = userInfoService.findByUsername(username);
        if(userInfo == null){
            return null;
        }
        //3、加密. 使用SimpleAuthenticationInfo 进行身份处理.
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getPassword(),ByteSource.Util.bytes(userInfo.getUserNameAndSalt()), getName());

        //4、返回身份处理对象.
        return simpleAuthenticationInfo;
    }

    /**
     * 权限认证.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //这是shiro提供的.
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取到用户的权限信息.
        UserInfo userInfo = (UserInfo)principals.getPrimaryPrincipal();
        for(SysRole role:userInfo.getRoles()){
            //添加角色.
            authorizationInfo.addRole(role.getRole());
            //添加权限.
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

}
