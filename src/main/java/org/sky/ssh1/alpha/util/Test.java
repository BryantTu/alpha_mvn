package org.sky.ssh1.alpha.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class Test
{
	public static void main(String[] args)
	{
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword("aaaaaa");
//		System.out.println(encryptor.encrypt("bptdev"));
		System.out.println(encryptor.decrypt("+BhLjVwBTURVMCbqJvU0OQ=="));
	}
}

