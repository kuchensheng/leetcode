package com.candy.aku.config;

import com.candy.aku.domain.SysPermission;
import com.candy.aku.domain.SysRole;
import com.candy.aku.domain.UserInfo;
import com.candy.aku.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/4/1 20:53
 */
public class CandyShiroRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(CandyShiroRealm.class);
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //TODO 权限配置
        logger.info("权限配置-->>"+getClass().getSimpleName()+".doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            logger.info(role.getPermissions().toString());
            for(SysPermission p : role.getPermissions()){
                logger.info("sysPermission is {}",p);
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证信息（身份验证）authenticationToken是用来验证用户身份
     * @param authenticationToken
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info(getClass().getSimpleName()+"doGetAuthenticationInfo()");
        logger.info("input username is {}",String.valueOf(authenticationToken.getPrincipal()));
        String usrname = String.valueOf(authenticationToken.getPrincipal());
        logger.info("input credentials is {}",authenticationToken.getCredentials());
        UserInfo userInfo = userInfoService.findByUserName(usrname);
        logger.info("userInfo is {}",userInfo);
        if(null == userInfo)
            return  null;
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getCredentialsSalt()),getName());
        return authenticationInfo;
    }
}
