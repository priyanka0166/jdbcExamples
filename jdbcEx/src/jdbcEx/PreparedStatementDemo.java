package jdbcEx;
import java.sql.*;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt;
		Statement stmt;
		ResultSet rs;
		Scanner scan;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","1");      
			System.out.println("Welcome to database");
			
			pstmt = con.prepareStatement("SELECT customerNumber, customerName,city,country FROM customers"
					+" where country=?");
			
			// create a preparedstatement object
			
			scan = new Scanner(System.in);
			System.out.println("Enter Country name of customers to be displayed : ");
			String country = scan.next();
			
			//assign value for to input parameter of ps
			pstmt.setString(1,country);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}			
			
			System.out.println("***************************************");
			
			scan = new Scanner(System.in);
			System.out.println("Enter Country name of customers to be displayed : ");
			String country1 = scan.next();
			
			// reuse the previous query
			pstmt.setString(1,country1);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


	}

}
