package org.sky.ssh1.alpha.index.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.sky.ssh1.alpha.service.StudentService;
import org.sky.ssh1.alpha.student.form.StudentForm;
import org.springframework.stereotype.Controller;

@Controller("/index")
public class IndexAction extends DispatchAction
{
	protected final Log logger = LogFactory.getLog(getClass());

	@Resource
	StudentService stdService;

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		return init(mapping, form, request, response);
	}

	public ActionForward init(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		List<StudentForm> stdList = new ArrayList<StudentForm>();
		try
		{
			stdList = stdService.getAllStudent();
			// logger.info("student size====" + stdList.size());
			request.setAttribute("stdList", stdList);
			return new ActionForward("/index.jsp", false);
		}
		catch (Exception e)
		{
			logger.error("Init Index Exception:" + e.getMessage(), e);
			return mapping.findForward("error");
		}
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String[] stdArray = null;
		try
		{
			stdArray = request.getParameterValues("selectedStudents");
			if (stdArray != null && stdArray.length > 0)
			{
				stdService.delStudent(stdArray);
			}
			return new ActionForward("/index.do", true);
		}
		catch (Exception e)
		{
			logger.error("delStudent error:" + e.getMessage(), e);
			return mapping.findForward("error");
		}
	}

	public ActionForward addStudent(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		String stdName = "";
		try
		{
			stdName = (String) request.getParameter("studentName");
			if (stdName != null && stdName.length() > 0)
			{
				stdService.addStudent(stdName);
			}
			return new ActionForward("/jsp/student/studentAdd.jsp", false);
		}
		catch (Exception e)
		{
			logger.error("addStudent error:" + e.getMessage(), e);
			return mapping.findForward("error");
		}
	}
}
