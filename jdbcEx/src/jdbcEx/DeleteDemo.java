package jdbcEx;
import java.sql.*;
public class DeleteDemo {

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		int cnt=0;

		try {
			con = ConnectionUtil.createConnection();
			String sql = "DELETE from candidates where rtrim(last_name) "
					+"LIKE \'K%g\';";
			
			String sql1 = "DELETE from candidates where id = 101; ";
			
			stmt = con.createStatement();
			cnt = stmt.executeUpdate(sql1);
			if(cnt > 0)
			{
				System.out.println(cnt+" Records Deleted");
			}
			else
			{
				System.out.println("Record Not Found");
			}
			
			con.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
