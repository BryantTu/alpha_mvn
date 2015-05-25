package alpha_mvn;

import org.jasypt.util.text.BasicTextEncryptor;


public class Test
{
	public static void main(String[] args)
	{
		BasicTextEncryptor encryptor = new BasicTextEncryptor();
		encryptor.setPassword("aaaaaa");
		System.out.println(encryptor.encrypt("bptdev"));
	}
}
