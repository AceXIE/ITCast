package Dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class UserDao {
	
	private static Properties prop = new Properties();
	static {
		try {
			InputStream in = UserDao.class.getClassLoader().getResourceAsStream("/WEB-INF/classes/db.properties");
			prop.load(in);
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}		
	}

	public void update() {
		System.out.println(prop.getProperty("url"));
	
	}

}
