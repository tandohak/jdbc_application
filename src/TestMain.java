

import java.sql.Connection;

import jdbc_application.jdbc.DBCon;
import jdbc_application.jdbc.JdbcUtil;

public class TestMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance();		
		
		Connection connection = dbCon.getConnection();
		System.out.println(connection);		
		
		
		JdbcUtil.close(connection);
	}

}
