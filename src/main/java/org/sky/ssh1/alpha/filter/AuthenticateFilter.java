package org.sky.ssh1.alpha.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateFilter implements Filter
{
	protected FilterConfig config;

	@Override
	public void destroy()
	{
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException
	{
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		if(isFilter(httpRequest, httpRequest.getRequestURI(), config.getInitParameter("exclude")))
		{
			httpResponse.sendRedirect("./jsp/login/login.jsp");
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException
	{
		this.config = config;
	}

	private boolean isFilter(HttpServletRequest httpRequest, String uri, String exclude)
	{
		boolean isFilter = true;
		if(httpRequest.getSession()!=null && httpRequest.getSession().getAttribute("user")!=null)
		{
			isFilter = false;
		}
		if(isFilter && uri!=null)
		{
			String[] excludeArr = exclude.split(",");
			for(String str : excludeArr)
			{
				if(uri.endsWith(str))
				{
					isFilter = false;
					break;
				}
			}
		}
		return isFilter;
	}
}
