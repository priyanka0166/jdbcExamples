package jdbcEx;
import java.sql.*;
import java.util.Scanner;

class Candidates {
	Connection con;
	PreparedStatement psmt; 
	ResultSet rs;
	String sqlUpdate;
	Scanner s;
	String lastname;
	int cnt=0,  eid;

	public void getConnection() throws Exception {
		con = ConnectionUtil.createConnection();
	}

	public void UpdateCandidate() throws Exception {
		sqlUpdate = "Update candidates set last_name = ? where id = ?";
		psmt = con.prepareStatement(sqlUpdate);

		// prepare data for update
		s = new Scanner(System.in);

		System.out.println("Enter Employee id:");
		eid = s.nextInt();
		System.out.println("Enter employee's new last name :");
		lastname = s.next();

		// passing values to prepared statement using setter methods
		psmt.setString(1, lastname);
		psmt.setInt(2, eid);

		cnt = psmt.executeUpdate();
		System.out.println(String.format("Row affected: %d", cnt));

		// reuse the prepared statement
		lastname = "Bush";
		eid = 101;
		psmt.setString(1, lastname);
		psmt.setInt(2, eid);

		cnt = psmt.executeUpdate();
		System.out.println(String.format("Row affected %d", cnt));

		con.close();
	}
}

public class UpdateDemo {

	public static void main(String[] args) {
		Candidates c1 = new Candidates();
		try {
			c1.getConnection();
			c1.UpdateCandidate();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
