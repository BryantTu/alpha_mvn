package org.sky.ssh1.alpha.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.sky.ssh1.alpha.dao.BasicHibernateDAOSupport;
import org.sky.ssh1.alpha.dao.LoginDAO;
import org.sky.ssh1.alpha.model.TLogin;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOHibernate extends BasicHibernateDAOSupport implements LoginDAO
{

	@Override
	public boolean login(Map<String, String> paramMap) throws Exception
	{
		return login3(paramMap.get("loginId"), paramMap.get("loginPwd"));
	}
	
	boolean login3(String loginId, String loginPwd) throws Exception
	{
		List list = this.getHibernateTemplate().findByNamedParam("select count(tl.loginId) from TLogin as tl where tl.loginId=:loginId and tl.loginPwd=:loginPwd ", 
			new String[]{"loginId", "loginPwd"}, new String[]{loginId, loginPwd});
		Long tLogin = 0L;
		if(list!=null && !list.isEmpty()){
			tLogin = (Long) list.get(0);
		}
		return tLogin.longValue() == 1;
	}

	boolean login(String loginId, String loginPwd) throws Exception
	{
		Long count = new Long(0);
		String sql = "select count(tl.loginId) from TLogin as tl where tl.loginId=:loginId and tl.loginPwd=:loginPwd ";
		Query query = super.getSession().createQuery(sql);
		query.setString("loginId", loginId);
		query.setString("loginPwd", loginPwd);
		count = (Long) query.list().get(0);
		return count.longValue()==1;
	}
	
	boolean login2(String loginId, String loginPwd) throws Exception
	{
		TLogin tLogin = new TLogin();
		tLogin.setLoginId(loginId);
		tLogin.setLoginPwd(loginPwd);
		List list = this.getHibernateTemplate().findByExample(tLogin);
		tLogin = null;
		if(list!=null && !list.isEmpty())
		{
			tLogin = (TLogin) list.get(0);
		}
		return tLogin!=null;
	}
}
