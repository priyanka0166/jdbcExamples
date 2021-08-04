package jdbcEx;
import java.sql.*;
import java.util.Scanner;

class Skills
{
	Connection con;
	CallableStatement cstmt;
	ResultSet rs;
	int id;

	public Skills() throws Exception{
		con = ConnectionUtil.createConnection();

	}

	public void getSkills(int candidateId) throws Exception
	{
		cstmt = con.prepareCall("{call get_candidate_skill(?)}");
		cstmt.setInt(1, candidateId);
		rs = cstmt.executeQuery();

		while (rs.next()) {
			System.out.println(String.format("%s - %s",
					rs.getString("first_name") + " "
							+ rs.getString("last_name"),
							rs.getString("skill")));

		}

		con.close();
	}
}

public class CallableStatementDemo {

	public static void main(String[] args) {
		try {

			Skills s = new Skills();
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter Candidate Id : ");

			int id = scan.nextInt();

			s.getSkills(id);
			scan.close();


		}


		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
