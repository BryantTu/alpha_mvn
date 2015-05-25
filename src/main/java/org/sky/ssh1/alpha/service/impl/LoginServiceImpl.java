package org.sky.ssh1.alpha.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sky.ssh1.alpha.dao.LoginDAO;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements org.sky.ssh1.alpha.service.LoginService
{
	private Log logger = LogFactory.getLog(this.getClass());

	@Resource(name = "loginDAOHibernate")
	private LoginDAO loginDAO;

	public boolean login(String loginId, String loginPwd) throws Exception
	{
		boolean answer = false;
		try
		{
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("loginId", loginId);
			paramMap.put("loginPwd", loginPwd);
			answer = loginDAO.login(paramMap);
		}
		catch (Exception e)
		{
			logger.error("login error:" + e.getMessage(), e);
		}
		return answer;
	}

}
