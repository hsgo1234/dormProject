package com.qddx.configuration;

//import org.apache.shiro.mgt.DefaultSecurityManager;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.mgt.SessionsSecurityManager;
//import org.apache.shiro.spring.boot.autoconfigure.ShiroAutoConfiguration;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/15 22:16
 */
//@Configuration
//public class ShiroCofig {
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//
//        //Shiro的核心安全接口，这个属性是必须的
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //要求登录时的链接。默认会自动寻找web下/login.jsp
//        shiroFilterFactoryBean.setLoginUrl("http://localhost:8080/#/");
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //用户访问未对其授权的资源时，所显示的链接
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        //定义shiro过滤链 Map 结构，Map中key(xml中是指value值)的第一个‘/’代表的路径是相对于httpSerletRequest.getContextPath()的值来的。
//         Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
//        filterChainDefinitionMap.put("/logout","logout");
//        //*anon：它对应的过滤器里面是空的，什么都不做。
//        filterChainDefinitionMap.put("/login","anon");
//        filterChainDefinitionMap.put("/reg","anon");
//        //*authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
//        filterChainDefinitionMap.put("/**","authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//    * 身份认证，权限授权Realm
//    *
//    * @params
//    * @return
//    */
//    @Bean
//    public MyShiroRealm myShiroRealm(){
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        return myShiroRealm;
//    }
//
//    //将 myShiroRealm 注入到 securityManager中
//    @Bean
//    public SessionsSecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        return securityManager;
//    }
//}
