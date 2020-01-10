package com.insigma.shiro.credential;

import com.insigma.shiro.realm.LoginType;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import com.insigma.shiro.token.CustomUsernamePasswordToken;

public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,AuthenticationInfo info) {
		CustomUsernamePasswordToken authtoken = (CustomUsernamePasswordToken) token;
		if (authtoken.getLoginType().equals(LoginType.NO_PASS)) {
			return true;
		} 
	    return super.doCredentialsMatch(token, info);
	}
}
