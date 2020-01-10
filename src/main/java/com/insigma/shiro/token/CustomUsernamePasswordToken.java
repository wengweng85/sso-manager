package com.insigma.shiro.token;

import com.insigma.shiro.realm.LoginType;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * CustomUsernamePasswordToken
 */
public class CustomUsernamePasswordToken extends UsernamePasswordToken {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6730381322353623113L;
	
	//用于存储用户输入的校验码
    private String verifycode;
    
    private String isvercode;

    private LoginType loginType;

    public CustomUsernamePasswordToken(String loginname, char[] password,boolean rememberMe, String host, String verifycode,String isvercode,LoginType loginType) {
        //调用父类的构造函数
        super(loginname,password,rememberMe,host);
        this.verifycode=verifycode;
        this.isvercode=isvercode;
        this.loginType=loginType;
    }

	public CustomUsernamePasswordToken(String loginname, char[] password,boolean rememberMe, String host, String verifycode,String isvercode) {
		//调用父类的构造函数
		super(loginname,password,rememberMe,host);
		this.verifycode=verifycode;
		this.isvercode=isvercode;
		this.loginType=LoginType.PASS;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String getIsvercode() {
		return isvercode;
	}

	public void setIsvercode(String isvercode) {
		this.isvercode = isvercode;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}
}
