package org.sky.ssh1.alpha.ibatis;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

public class IBatisTransactionFactory implements TransactionFactory
{

	private DataSource dataSource;

	public IBatisTransactionFactory(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public void setProperties(Properties properties)
	{
	}

	public Transaction newTransaction(Connection connection, boolean flag)
	{
		return new IBatisTransaction(dataSource, connection, flag);
	}

}
