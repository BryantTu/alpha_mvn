package org.sky.ssh1.alpha.login.form;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {

	private String loginId = "";
	private String loginPwd = "";

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
}
