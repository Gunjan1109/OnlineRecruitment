package Candidate;

import java.sql.*;
import java.text.ParseException;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import Candidate.CandidateDBobj;



public class CandidateDBMethods {
	public String DBUser;
	public String DBPswd;
	public String DBUrl;
	
	public CandidateDBMethods(){ }
	public CandidateDBMethods(String inDBUser, String inDBPswd, String inDBUrl ){
		DBUser = inDBUser ;
		DBPswd = inDBPswd;
		DBUrl  = inDBUrl;
	}
	

public void initializeCandidateDoObj(CandidateDBobj inEmployeeDBObj){
	inEmployeeDBObj.emp_id =  "";
	inEmployeeDBObj.emp_f_name = "";
	inEmployeeDBObj.emp_l_name = "";
	inEmployeeDBObj.number = "";
	inEmployeeDBObj.email = "";
	inEmployeeDBObj.newpass= "";
}

public CandidateDBobj getRecordByPrimaryKey(String inEmpId, String inEmpFName){
	CandidateDBobj  employeeDBObj = new CandidateDBobj();
	try{
		System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
		Statement stmt = conn.createStatement();
		String lSqlString =	"select * from candidateregister  ";
		lSqlString = lSqlString + "where cid='"+inEmpId+"' ";
		if( inEmpFName != null && inEmpFName.length() > 0)
		lSqlString = lSqlString + "and fname='"+inEmpFName+"' ";
		ResultSet rs  = null;
		rs  = stmt.executeQuery(lSqlString);
		System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
		if( rs.next()){
			System.out.println("fffff==="+rs.getString("cid"));
			employeeDBObj.emp_id =  rs.getString("cid");
			employeeDBObj.emp_f_name = rs.getString("fname");
			employeeDBObj.emp_l_name = rs.getString("lname");
			employeeDBObj.number = rs.getString("number");
			employeeDBObj.email = rs.getString("email");
			employeeDBObj.newpass = rs.getString("newpass");
			//System.out.println("fffff==="+rs.getString("cid"));
		}
		else{
			System.out.println("Record Does N't exist");
			// initializeEmployeeDBObj(employeeDBObj);
		}
		System.out.println("fffff====="+employeeDBObj.emp_id);
	}
	catch(Exception  ex){
		ex.printStackTrace();
	}
	return employeeDBObj;
}

public CandidateDBobj getRecord2ByPrimaryKey( String inUserName, String inUserPswd){
	CandidateDBobj  userLoginDBObj = new CandidateDBobj();
	try{
		System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
		Statement stmt = conn.createStatement();
		String lSqlString =	"select * from candidateregister where fname='"+inUserName+"' and newpass='"+inUserPswd+"'";
//		lSqlString = lSqlString + "where user_id='"+inUserId+"' ";
//		lSqlString = lSqlString + "and user_name='"+inUserName+"' ";
//		lSqlString = lSqlString + "and new_pswd='"++inUserPswd+"' ";
		ResultSet rs  = null;
		rs  = stmt.executeQuery(lSqlString);
		System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
		if( rs.next()){
			System.out.println("fffff==="+rs.getString("cid"));
			userLoginDBObj.emp_id = rs.getString("cid");
			userLoginDBObj.emp_f_name = rs.getString("fname");
			userLoginDBObj.emp_l_name = rs.getString("lname");
			userLoginDBObj.email = rs.getString("email");
			userLoginDBObj.newpass = rs.getString("newpass");
			userLoginDBObj.number = rs.getString("number");
			//System.out.println("fffff==="+rs.getString("user_id"));
		}
		else{
			initializeCandidateDoObj(userLoginDBObj);
		}
			System.out.println("fffff====="+userLoginDBObj.emp_id);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return userLoginDBObj;
}
public int updateEmployeeByPrimaryKey(CandidateDBobj inEmployeeDBObj){
	int recupd = 0; 
	String lQuery = "";
	lQuery = lQuery +"update candidateregister set fname='"+inEmployeeDBObj.emp_f_name+"'  "; 
	lQuery = lQuery +" , lname='"+inEmployeeDBObj.emp_l_name+"' ";
	lQuery = lQuery +" , number='"+inEmployeeDBObj.number+"' ";
	lQuery = lQuery +" , email='"+inEmployeeDBObj.email+"' ";
	lQuery = lQuery +" , newpass='"+inEmployeeDBObj.newpass+"' ";
	lQuery = lQuery + "where cid='"+inEmployeeDBObj.emp_id+"' ";
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
public CandidateDBobj populateEmployeeDBObjFromReq(HttpServletRequest inReq){
	CandidateDBobj  employeeDBObj = new CandidateDBobj();
	employeeDBObj.emp_id   =  (String)inReq.getParameter("emp_id");
	employeeDBObj.emp_f_name = (String)inReq.getParameter("emp_f_name"); 
	employeeDBObj.emp_l_name  = (String)inReq.getParameter("emp_l_name");
	employeeDBObj.number = (String)inReq.getParameter("number");
	employeeDBObj.email = (String)inReq.getParameter("email");
	employeeDBObj.newpass = (String)inReq.getParameter("newpass");
	return employeeDBObj;
}
public ArrayList selectEmployeeByCriteria(String inCriteria){
	ArrayList employeeList = new ArrayList();
	java.util.Date date=new java.util.Date();
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
		Statement stmt = conn.createStatement();
		String lSqlString ="select * from candidateregister";
		if( inCriteria != null && inCriteria.length() > 0 ){
			lSqlString = lSqlString +" "+inCriteria ;
		}
		ResultSet rs  = null;
		lSqlString = lSqlString +" ORDER BY cid" ;
		rs  = stmt.executeQuery(lSqlString);
		while( rs.next()){
			CandidateDBobj  employeeDBObj = new CandidateDBobj();
			employeeDBObj.emp_id =  rs.getString("cid");
			employeeDBObj.emp_f_name = rs.getString("fname");
			employeeDBObj.emp_l_name = rs.getString("lname");
			employeeDBObj.number = rs.getString("number");
			employeeDBObj.email = rs.getString("email");
			employeeDBObj.newpass = rs.getString("newpass");
			employeeList.add(employeeDBObj);
		}
	}
	catch(Exception  ex){
		ex.printStackTrace();
	}
	return employeeList;
}
public int insertEmployee(CandidateDBobj inEmployeeDBObj) throws ParseException{
	int recupd = 0; 
	//Date date = new ;

	String lQuery = "";
	lQuery = lQuery +"insert into candidateregister  values ( ";
	lQuery = lQuery +" '"+inEmployeeDBObj.emp_id+"'  ";
	lQuery = lQuery +" , '"+inEmployeeDBObj.emp_f_name+"'  ";
	lQuery = lQuery +" , '"+inEmployeeDBObj.emp_l_name+"' ";
	lQuery = lQuery +" , '"+inEmployeeDBObj.number+"' ";
	lQuery = lQuery +" , '"+inEmployeeDBObj.email+"' ";
	lQuery = lQuery +" , '"+inEmployeeDBObj.newpass+"' ";
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
		lQuery = lQuery +"delete from  candidateregister "; 
		lQuery = lQuery +" where cid='"+ inEmpId +"' ";
		System.out.println("lSqlString===:"+lQuery);
		stmt.executeQuery(lQuery);
	}
	catch(Exception  ex){
		ex.printStackTrace();
	}
}
}