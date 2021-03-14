package test;
import java.sql.*;
public class DbConnection {
private static Connection con;
public DbConnection() {}
static {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Avdesh","Abishek");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public static Connection getCon() {
	return con;
}
}
