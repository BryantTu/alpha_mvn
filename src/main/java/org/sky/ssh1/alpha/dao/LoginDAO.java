package org.sky.ssh1.alpha.dao;

import java.util.Map;

public interface LoginDAO {
	public boolean login(Map<String, String> paramMap) throws Exception;
}
