package org.sky.ssh1.alpha.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5
{
	public static String getMD5(String str) throws Exception
	{
		String result = null;
		MessageDigest digest = MessageDigest.getInstance("md5");
		InputStream in = new ByteArrayInputStream(str.getBytes());
		byte[] buff = new byte[1024];
		int size = -1;
		while((size=in.read(buff))!=-1)
		{
			digest.update(buff, 0, size);
		}
		in.close();
		BigInteger bigInteger = new BigInteger(1, digest.digest());
		result  = bigInteger.toString(16);
		return result.toUpperCase();
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println(getMD5("bryant.tu"));
	}
}

