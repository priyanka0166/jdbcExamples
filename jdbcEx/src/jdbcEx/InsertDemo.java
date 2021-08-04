package jdbcEx;
import java.sql.*;

public class InsertDemo {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet rs;
		int count;
		Statement stmt ;
		
		try
		{
			con = ConnectionUtil.createConnection();
			
			String str = "INSERT INTO skills(name) VALUES ('Node') ";
			
			stmt = con.createStatement();
			
			count = stmt.executeUpdate(str); // return no of records affected
			
			if(count>0)
			{
				System.out.println("Record Inserted Successfully");
			}
			
			//count total no. of records in table
			String str1 = "SELECT COUNT(id) FROM skills";
			rs = stmt.executeQuery(str1);
			int cnt=0;
			while(rs.next())
			{
				cnt=rs.getInt(1);
			}
			System.out.println("Total no. of records is : "+cnt);
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
