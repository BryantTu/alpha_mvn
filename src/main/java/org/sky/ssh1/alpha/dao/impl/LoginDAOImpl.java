package org.sky.ssh1.alpha.dao.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.sky.ssh1.alpha.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO
{

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql = "";

	public void setSql(String sql)
	{
		this.sql = sql;
	}

	@Override
	public boolean login(Map<String, String> paramMap) throws Exception
	{
		boolean answer = false;
		int recordCount = 0;
		String loginId = paramMap.get("loginId");
		String loginPwd = paramMap.get("loginPwd");
		recordCount = jdbcTemplate.queryForInt(sql, loginId, loginPwd);
		if (recordCount == 1)
		{
			answer = true;
		}
		return answer;
	}

}
