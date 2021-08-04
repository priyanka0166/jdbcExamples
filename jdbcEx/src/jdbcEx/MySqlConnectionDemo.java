package jdbcEx;
import java.sql.*;

public class MySqlConnectionDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt;
		ResultSet rs;

		try {
			// Load & register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a connection using getConnection() of DM class
			// Create a Session Between Java & Mysql
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1");      

			// create statement object
			stmt = con.createStatement();

			//execute a query & store in Resultset
			rs = stmt.executeQuery("select * from employees");

			// Traverse Resultset
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString("email")+" "+rs.getString(8));
			}


			/*
			System.out.println("Display specific record from a database");
			rs.absolute(3);  // move the cursor to 3rd row in r
			System.out.println(rs.getInt(1)+" "+rs.getString(3)+" "+rs.getString("email")+" "+rs.getString(8));
			 */
			con.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
