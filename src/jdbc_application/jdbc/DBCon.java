package jdbc_application.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;	
	
	public static DBCon getInstance() {
		return instance;
	}


	public Connection getConnection() {
		return connection;
	}

	private DBCon(){
		Properties properties = getPropertys("conf.properties");
		try {
			String user = properties.getProperty("user");
			String pwd = properties.getProperty("pwd");
			String url = properties.getProperty("url");
			
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	private Properties getPropertys(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}


}
