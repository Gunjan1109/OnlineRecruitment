package Candidate;

import java.sql.*;
public class GeneratedId
{
	public int generateEmployeeId(){
	int emp_id=0;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinerecruitment","root","7210476954");
		Statement stmt = conn.createStatement();
		String query="select max(cid) as emp_id from candidateregister ";
		ResultSet rs = null;
		rs = stmt.executeQuery(query);
		if(rs.next()){
			String id = rs.getString("cid");
			emp_id=Integer.parseInt(id);
		}
		emp_id = emp_id + 1;		
	    }
		catch(SQLException  ex){
			ex.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return emp_id;	
	}
}