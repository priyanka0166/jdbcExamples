package jdbcEx;
import java.sql.*;

public class Employee {

	Connection con;
	PreparedStatement psmt;
	Statement smt;
	ResultSet rs;
	int cnt =0;

	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","priyanka");
		return con;
	}

	public void insertEmployee(String name, String city, String contact) {
		System.out.println("---- Insert new Employees ----");
		try 
		{
			con = Employee.getConnection();
			String sqlInsert = "INSERT INTO EmployeeDetails (Name,City,Contact) VALUES (?,?,?);";
			
			psmt = con.prepareStatement(sqlInsert);
			
			psmt.setString(1, name);
			psmt.setString(2, city);
			psmt.setString(3, contact);
			
			cnt = psmt.executeUpdate();
			System.out.println(String.format("%d Row Inserted ", cnt));
			
			con.close();

		} 
		catch (Exception ex) {
			ex.printStackTrace();

		}
	}
	public void getEmployee()
	{
		System.out.println("\n----- Display Employees -----");
		
		try {
			con = Employee.getConnection();
			
			smt = con.createStatement();
			rs = smt.executeQuery("SELECT * FROM EmployeeDetails;");

			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}

			con.close();

		} 

		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}

	public void updateEmployee(int id,String city)
	{
		System.out.println("---- Update Employees ---\n");

		try {
			con = Employee.getConnection();
			
			String sqlUpdate = "UPDATE EmployeeDetails SET City = ? WHERE EmpId = ? ";
			
			psmt = con.prepareStatement(sqlUpdate);
			
			psmt.setInt(2, id);
			psmt.setString(1, city);


			cnt = psmt.executeUpdate();
			System.out.println(String.format("%d Row Updated ", cnt));


			con.close();

		} 

		catch (Exception ex) {
			ex.printStackTrace();
		}



	}

	public void deleteEmployee(int cid)
	{
		System.out.println("\n---- Delete Employees ----\n");
		try {
			con = Employee.getConnection();
			
			String sqlDelete = "DELETE FROM EmployeeDetails WHERE EmpId = ? ;";
			psmt = con.prepareStatement(sqlDelete);
			
			psmt.setInt(1, cid);
			
			cnt = psmt.executeUpdate();
			System.out.println(String.format("%d Row Deleted ", cnt));
			con.close();

		} 

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
