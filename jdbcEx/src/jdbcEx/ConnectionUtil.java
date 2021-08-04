package jdbcEx;
import java.sql.*;

public class ConnectionUtil {
	public static Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","1");
		return con;
	}

}
