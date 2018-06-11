package com.company.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 这是Shiro 配置类：
 * -----------------------
 * （1）需要配置ShiroFilterFactory :ShiroFilterFactoryBean
 * （2）配置SecurityManager
 */
@Configuration //这是配置类.
public class ShiroConfiguration {
    /**
     * 定义shiro Filter 工厂类.
     *
     * @param securityManager
     * @return
     */
    @Bean //注入shiroFilter.
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        /*
         * 1、定义ShiroFactoryBean.
         * 2、设置SecurityManager;
         * 3、配置拦截器+配置登录和登录成功的地址.
         * 4、返回ShiroFactoryBean.
         */
        //1、定义ShiroFactoryBean.
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //2、设置SecurityManager;
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //3、配置拦截器.: 使用Map进行配置:LinkedHashMap ，LinkedHashMap是有序的, shiro会根据添加的顺序进行拦截.
        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();

        //配置退出. 过滤器：logout,这个由shiro进行实现的.
        filterChainMap.put("/logout", "logout");

        //配置记住我 认证通过的才可以访问.
        filterChainMap.put("/index", "user");
        filterChainMap.put("/", "user");

        //userInfo/userAdd : 一旦重新启动，仍然需要重新登录的.

        //允许favicon.ico可以匿名访问（anon）
        filterChainMap.put("/favicon.ico", "anon");

        //authc:所有的URL都必须认证通过才可以访问.
        filterChainMap.put("/**", "authc");

        //设置默认登录的URL.
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置成功之后要跳转的链接.
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权界面.
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        //4、返回ShiroFactoryBean.
        return shiroFilterFactoryBean;


    }

    /**
     * 定义Shiro的安全管理器.
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //设置自定义的realm
        securityManager.setRealm(myShiroRealm());

        //注入缓存管理器.
        securityManager.setCacheManager(ehCacheManager());

        //配置记住我.
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 密码加密算法.
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//加密算法.
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数.
        return hashedCredentialsMatcher;
    }

    /**
     * 开启Shiro aop注解支持.
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        attributeSourceAdvisor.setSecurityManager(securityManager);//设置安全管理器
        return attributeSourceAdvisor;
    }

    /**
     * 注入Ehcache缓存.
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager ehCacheManager = new EhCacheManager();
        //配置缓存文件.
        ehCacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return ehCacheManager;
    }

    /**
     * 配置cookie对象. -- 记住我cookie
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //cookie的名称，也即是 前端 checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //可选： 配置cookie的生效时间，单位是秒. 60*60*24 = 1天.
        simpleCookie.setMaxAge(60 * 60 * 24);
        return simpleCookie;
    }


    /**
     * cookie的管理对象.
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        //需要管理我们的cookie对象.
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }

    /**
     * 是shiro - thymeleaf 解析.
     *
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect() {
        ShiroDialect shiroDialect = new ShiroDialect();
        return shiroDialect;
    }
}
