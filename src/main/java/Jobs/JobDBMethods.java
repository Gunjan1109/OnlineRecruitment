package Jobs;

import java.sql.*;
import java.text.ParseException;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Jobs.JobDBobj;
public class JobDBMethods {
	public String DBUser;
	public String DBPswd;
	public String DBUrl;
	
	public JobDBMethods(){ }
	public JobDBMethods(String inDBUser, String inDBPswd, String inDBUrl ){
		DBUser = inDBUser ;
		DBPswd = inDBPswd;
		DBUrl  = inDBUrl;
	}
	
	public void initializeJobDBobj(JobDBobj inEmployeeDBObj){
		inEmployeeDBObj.Id =  "";
		inEmployeeDBObj.Job = "";
		inEmployeeDBObj.vacancies = "";
		
	}
	
	public JobDBobj getRecordByPrimaryKey(String inEmpId){
		JobDBobj  jobDBObj = new JobDBobj();
		try{
			System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString =	"select * from jobs  ";
			lSqlString = lSqlString + "where job='"+inEmpId+"' ";
			ResultSet rs  = null;
			rs  = stmt.executeQuery(lSqlString);
			System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
			if( rs.next()){
				System.out.println("fffff==="+rs.getString("Id"));
				jobDBObj.Id =  rs.getString("Id");
				jobDBObj.Job = rs.getString("Job");
				jobDBObj.vacancies = rs.getString("vacancies");
			}
			else{
				System.out.println("Record Does N't exist");
				// initializeEmployeeDBObj(employeeDBObj);
			}
			System.out.println("fffff====="+jobDBObj.Id);
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return jobDBObj;
	}

	public JobDBobj getRecord2ByPrimaryKey( String inUserName){
		JobDBobj  userLoginDBObj = new JobDBobj();
		try{
			System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString =	"select * from jobs where Id='"+inUserName+"'";
//			lSqlString = lSqlString + "where user_id='"+inUserId+"' ";
//			lSqlString = lSqlString + "and user_name='"+inUserName+"' ";
//			lSqlString = lSqlString + "and new_pswd='"++inUserPswd+"' ";
			ResultSet rs  = null;
			rs  = stmt.executeQuery(lSqlString);
			System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
			if( rs.next()){
				System.out.println("fffff==="+rs.getString("cid"));
				userLoginDBObj.Id = rs.getString("Id");
				userLoginDBObj.Job = rs.getString("Job");
				userLoginDBObj.vacancies = rs.getString("vacancies");
				
			}
			else{
				initializeJobDBobj(userLoginDBObj);
			}
				System.out.println("fffff====="+userLoginDBObj.Id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userLoginDBObj;
	}
	
	public JobDBobj populateEmployeeDBObjFromReq(HttpServletRequest inReq){
		JobDBobj  employeeDBObj = new JobDBobj();
		employeeDBObj.Id   =  (String)inReq.getParameter("Id");
		employeeDBObj.Job = (String)inReq.getParameter("Job"); 
		employeeDBObj.vacancies  = (String)inReq.getParameter("vacancies");
		return employeeDBObj;
	}
	public ArrayList selectEmployeeByCriteria(String inCriteria){
		ArrayList employeeList = new ArrayList();

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString ="select * from jobs";
			if( inCriteria != null && inCriteria.length() > 0 ){
				lSqlString = lSqlString +" "+inCriteria ;
			}
			ResultSet rs  = null;
			rs  = stmt.executeQuery(lSqlString);
			while( rs.next()){
				JobDBobj  employeeDBObj = new JobDBobj();
				employeeDBObj.Id =  rs.getString("Id");
				employeeDBObj.Job = rs.getString("Job");
				employeeDBObj.vacancies = rs.getString("vacancies");
				employeeList.add(employeeDBObj);
			}
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return employeeList;
	}
	public int insertEmployee(JobDBobj inEmployeeDBObj) throws ParseException{
		int recupd = 0; 
		//Date date = new ;

		String lQuery = "";
		lQuery = lQuery +"insert into jobs  values ( ";
		lQuery = lQuery +" '"+inEmployeeDBObj.Id+"'  ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.Job+"'  ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.vacancies+"' ";
		lQuery = lQuery + " )";
	    System.out.println("lSqlString===:"+lQuery);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			recupd  = stmt.executeUpdate(lQuery);
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return recupd;
	}
	public void deleteEmployee(String inEmpId){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lQuery = "";
			lQuery = lQuery +"delete from  jobs "; 
			lQuery = lQuery +" where Id='"+ inEmpId +"' ";
			System.out.println("lSqlString===:"+lQuery);
			stmt.executeQuery(lQuery);
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
	}
}
