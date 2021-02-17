package CompanyServelet;

import java.sql.*;
import java.text.ParseException;

import java.util.ArrayList;
import CompanyServelet.CompanyDBobj;
import javax.servlet.http.HttpServletRequest;


public class CompanyDBMethods {

	public String DBUser;
	public String DBPswd;
	public String DBUrl;
	
	public CompanyDBMethods(){ }
	public CompanyDBMethods(String inDBUser, String inDBPswd, String inDBUrl ){
		DBUser = inDBUser ;
		DBPswd = inDBPswd;
		DBUrl  = inDBUrl;
	}
	
	public void initializeCompanyDBobj(CompanyDBobj inCompanyDBObj){
		inCompanyDBObj.Id =  "";
		inCompanyDBObj.Name = "";
		inCompanyDBObj.Address="";
		inCompanyDBObj.number="";
		inCompanyDBObj.password="";
		inCompanyDBObj.email="";
	}
	
	public CompanyDBobj getRecordByPrimaryKey(String inEmpId, String inEmpFName){
		CompanyDBobj  employeeDBObj = new CompanyDBobj();
		try{
			System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString =	"select * from companies  ";
			lSqlString = lSqlString + "where Id='"+inEmpId+"' ";
			if( inEmpFName != null && inEmpFName.length() > 0)
			lSqlString = lSqlString + "and Name='"+inEmpFName+"' ";
			ResultSet rs  = null;
			rs  = stmt.executeQuery(lSqlString);
			System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
			if( rs.next()){
				System.out.println("fffff==="+rs.getString("Id"));
				employeeDBObj.Id =  rs.getString("Id");
				employeeDBObj.Name = rs.getString("Name");
				employeeDBObj.Address = rs.getString("address");
				employeeDBObj.number = rs.getString("number");
				employeeDBObj.password = rs.getString("password");
				employeeDBObj.email = rs.getString("email");
				//System.out.println("fffff==="+rs.getString("cid"));
			}
			else{
				System.out.println("Record Does N't exist");
				// initializeEmployeeDBObj(employeeDBObj);
			}
			System.out.println("fffff====="+employeeDBObj.Id);
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return employeeDBObj;
	}

	public CompanyDBobj getRecord2ByPrimaryKey( String inUserName, String inUserPswd){
		CompanyDBobj  userLoginDBObj = new CompanyDBobj();
		try{
			System.out.println("DBUser=="+DBUser+",DBPswd=="+DBPswd+",DBUrl=="+DBUrl);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString =	"select * from companies where Name='"+inUserName+"' and password='"+inUserPswd+"'";
//			lSqlString = lSqlString + "where user_id='"+inUserId+"' ";
//			lSqlString = lSqlString + "and user_name='"+inUserName+"' ";
//			lSqlString = lSqlString + "and new_pswd='"++inUserPswd+"' ";
			ResultSet rs  = null;
			rs  = stmt.executeQuery(lSqlString);
			System.out.println("lSqlString====trtrt==within getRecordByPrimaryKey== "+lSqlString);
			if( rs.next()){
				System.out.println("fffff==="+rs.getString("Id"));
				userLoginDBObj.Id = rs.getString("Id");
				userLoginDBObj.Name = rs.getString("Name");
				userLoginDBObj.Address = rs.getString("address");
				userLoginDBObj.number = rs.getString("number");
				userLoginDBObj.password = rs.getString("password");
				userLoginDBObj.email = rs.getString("email");
				//System.out.println("fffff==="+rs.getString("user_id"));
			}
			else{
				initializeCompanyDBobj(userLoginDBObj);
			}
				System.out.println("fffff====="+userLoginDBObj.Id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userLoginDBObj;
	}
	
	public int updateEmployeeByPrimaryKey(CompanyDBobj inEmployeeDBObj){
		int recupd = 0; 
		String lQuery = "";
		lQuery = lQuery +"update companies set Name='"+inEmployeeDBObj.Name+"'  "; 
		lQuery = lQuery +" , number='"+inEmployeeDBObj.number+"' ";
		lQuery = lQuery +" , Address='"+inEmployeeDBObj.Address+"' ";
		lQuery = lQuery +" , password='"+inEmployeeDBObj.password+"' ";
		lQuery = lQuery +" , email='"+inEmployeeDBObj.email+"' ";
		lQuery = lQuery + "where Id='"+inEmployeeDBObj.Id+"' ";
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
	
	public  CompanyDBobj populateEmployeeDBObjFromReq(HttpServletRequest inReq){
		 CompanyDBobj  employeeDBObj = new  CompanyDBobj();
		employeeDBObj.Id   =  (String)inReq.getParameter("com_id");
		employeeDBObj.Name = (String)inReq.getParameter("com_Name"); 
		employeeDBObj.Address  = (String)inReq.getParameter("Address");
		employeeDBObj.number = (String)inReq.getParameter("number");
		employeeDBObj.email = (String)inReq.getParameter("email");
		employeeDBObj.password = (String)inReq.getParameter("newpass");
		return employeeDBObj;
	}
	
	public int insertEmployee(CompanyDBobj inEmployeeDBObj) throws ParseException{
		int recupd = 0; 
		//Date date = new ;

		String lQuery = "";
		lQuery = lQuery +"insert into companies  values ( ";
		lQuery = lQuery +" '"+inEmployeeDBObj.Id+"'  ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.Name+"'  ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.Address+"' ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.number+"' ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.password+"' ";
		lQuery = lQuery +" , '"+inEmployeeDBObj.email+"' ";
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

	public ArrayList selectEmployeeByCriteria(String inCriteria){
		ArrayList employeeList = new ArrayList();
		java.util.Date date=new java.util.Date();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection(DBUrl,DBUser,DBPswd);
			Statement stmt = conn.createStatement();
			String lSqlString ="select * from companies";
			if( inCriteria != null && inCriteria.length() > 0 ){
				lSqlString = lSqlString +" "+inCriteria ;
			}
			ResultSet rs  = null;
			lSqlString = lSqlString +" ORDER BY Id" ;
			rs  = stmt.executeQuery(lSqlString);
			while( rs.next()){
				CompanyDBobj  employeeDBObj = new CompanyDBobj();
				employeeDBObj.Id =  rs.getString("Id");
				employeeDBObj.Name = rs.getString("Name");
				employeeDBObj.Address = rs.getString("address");
				employeeDBObj.number = rs.getString("number");
				employeeDBObj.email = rs.getString("email");
				employeeDBObj.password = rs.getString("password");
				employeeList.add(employeeDBObj);
			}
		}
		catch(Exception  ex){
			ex.printStackTrace();
		}
		return employeeList;
	}
}
