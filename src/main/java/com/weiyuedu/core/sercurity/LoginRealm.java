package com.weiyuedu.core.sercurity;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * 描述:
 * 创建人: w349037273@163.com
 * 日期: 2017-11-14
 * 时间: 22:25
 */
public class LoginRealm implements Realm {
    public String getName() {
        return null;
    }

    public boolean supports(AuthenticationToken authenticationToken) {

        System.out.println("认证判断");
        return false;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("权限判断");

        return null;
    }
}
