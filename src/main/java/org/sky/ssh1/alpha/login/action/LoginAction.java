package org.sky.ssh1.alpha.login.action;

import org.apache.struts.actions.DispatchAction;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sky.ssh1.alpha.login.form.LoginForm;
import org.sky.ssh1.alpha.service.LoginService;
import org.sky.ssh1.alpha.student.form.StudentForm;
import org.springframework.stereotype.Controller;

@Controller("/login")
public class LoginAction extends DispatchAction
{
	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	LoginService loginService;

	public ActionForward submit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		LoginForm loginForm = (LoginForm) form;
		try
		{
			String loginId = loginForm.getLoginId();
			String loginPwd = loginForm.getLoginPwd();
			if (loginService.login(loginId, loginPwd))
			{
				request.getSession().setAttribute("user", loginId);
				return new ActionForward("/index.do", true);
			}
			else
			{
				request.setAttribute("loginCode", "101");
				return new ActionForward("/jsp/login/login.jsp", false);
			}
		}
		catch (Exception e)
		{
			logger.error("UserLogin Exception:" + e.getMessage(), e);
			return mapping.findForward("error");
		}

	}

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		try
		{
			StudentForm stdForm = new StudentForm();
			request.setAttribute("stdForm", stdForm);
		}
		catch (Exception e)
		{
			logger.error("UserLogin Exception:" + e.getMessage(), e);
			return mapping.findForward("error");
		}
		return null;
	}
}
