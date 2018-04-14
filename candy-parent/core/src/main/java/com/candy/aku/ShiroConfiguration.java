package com.candy.aku;

import com.candy.aku.config.CandyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/3/31 0:41
 */
@Configuration
public class ShiroConfiguration {

    private static Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        StopWatch stopWatch = new StopWatch();
        logger.info("start shiroConfiguration.shiroFilter()");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截器
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/swagger**","anon");
        filterChainDefinitionMap.put("/druid/**","anon");
        filterChainDefinitionMap.put("/webjars/**","anon");
        filterChainDefinitionMap.put("/v2/api-docs/**","anon");
        filterChainDefinitionMap.put("/rest/**","anon");
        filterChainDefinitionMap.put("/configuration/**","anon");
        filterChainDefinitionMap.put("/resources/**","anon");
        filterChainDefinitionMap.put("/swagger-ui.html","anon");
        //配置退出过滤器
        filterChainDefinitionMap.put("/logout","logout");
        //配置所有url都必须认证通过才能访问
        filterChainDefinitionMap.put("/**","authc");

        //设置自动寻找根登陆页
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登陆成功后的跳转页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //未授权页
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public CandyShiroRealm candyShiroRealm(){
        return new CandyShiroRealm();
    }
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(candyShiroRealm());
        return securityManager;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
