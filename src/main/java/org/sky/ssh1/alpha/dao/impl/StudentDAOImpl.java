package org.sky.ssh1.alpha.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.sky.ssh1.alpha.dao.StudentDAO;
import org.sky.ssh1.alpha.dbo.StudentDBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO
{
	// private Log logger = LogFactory.getLog(this.getClass());

	// @Autowired
	// private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Map<String, String> sql = null;

	public void setSql(Map<String, String> sql)
	{
		this.sql = sql;
	}

	@Override
	public List<StudentDBO> getAllStudent() throws Exception
	{
		return jdbcTemplate.query((String) sql.get("getAllStudent"), new Object[] {}, stdItemRowMapper());
	}

	public void addStudent(final String stdName) throws Exception
	{
		jdbcTemplate.update((String) sql.get("addStudent"), new PreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps) throws SQLException
			{
				ps.setString(1, stdName);
			}
		});
	}

	public void delStudent(final String stdNo) throws Exception
	{
		jdbcTemplate.update((String) sql.get("delStudent"), new PreparedStatementSetter()
		{
			public void setValues(PreparedStatement ps) throws SQLException
			{
				ps.setString(1, stdNo);
			}
		});
	}

	private RowMapper<StudentDBO> stdItemRowMapper()
	{
		return new RowMapper<StudentDBO>()
		{

			public StudentDBO mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				StudentDBO stdDbo = new StudentDBO();
				stdDbo.setStudentNo(rs.getString(1));
				stdDbo.setStudentName(rs.getString(2));
				return stdDbo;
			}

		};
	}
}
