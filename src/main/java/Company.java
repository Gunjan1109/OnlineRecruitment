

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import CompanyServelet.CompanyDBobj;
import CompanyServelet.CompanyDBMethods;
import Candidate.*;
import Jobs.*;

/**
 * Servlet implementation class Company
 */
public class Company extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String lDBUser = "";
	String lDBPswd = "";
	String lDBUrl = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Company() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		System.out.println("initializing controller servlet.");
		ServletContext context = config.getServletContext();
//		Class.forName("com.mysql.cj.jdbc.Driver");
		lDBUser = "root";
		lDBPswd = "7210476954";
		lDBUrl = "jdbc:mysql://localhost:3306/onlinerecruitment";
		super.init(config);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("lErrorMsg",null);
		String target = "";
		String lDBOpr = "";
		CompanyDBMethods employeeDBMethods = new CompanyDBMethods(lDBUser,lDBPswd,lDBUrl);
		CandidateDBMethods candidateDBMethods = new CandidateDBMethods(lDBUser,lDBPswd,lDBUrl);
		JobDBMethods jobDBMethods = new JobDBMethods(lDBUser,lDBPswd,lDBUrl);
		lDBOpr = (String)request.getParameter("dbopr");
		if (request.getParameter("action").equals("insert")){
			CompanyDBobj popEmployeeDBObj = new CompanyDBobj(); 
			popEmployeeDBObj = (CompanyDBobj)employeeDBMethods.populateEmployeeDBObjFromReq(request);
			CompanyDBobj employeeDBObj = new CompanyDBobj();
			employeeDBObj = (CompanyDBobj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.Id,popEmployeeDBObj.Name);
			if ( (popEmployeeDBObj.Id).equals(employeeDBObj.Id) && (popEmployeeDBObj.Name).equals(employeeDBObj.Name) ){
				String lErrorMsg = "Employee Already Exist"; 
				session.setAttribute("lErrorMsg",lErrorMsg);
				System.out.println("Employee:" + lErrorMsg);
				target = "/CompanyRegister.jsp";
			}
			else{
				try {
					int rval =  employeeDBMethods.insertEmployee(popEmployeeDBObj);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CompanyDBobj sEmployeeDBObj = new CompanyDBobj();
				sEmployeeDBObj = (CompanyDBobj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.Id,popEmployeeDBObj.Name);
				session.setAttribute("employeeDBObj",sEmployeeDBObj);
				String lErrorMsg = "Employee is Added!!"; 
				session.setAttribute("lErrorMsg",lErrorMsg);
				target = "/CompanyMain.jsp";  //target = "/jsp/employee_edit.jsp";
		}

		}
		
		else
			if (request.getParameter("action").equals("Login")) {
				System.out.println("in the Login");
					String lUserName = "";	
					String lUserPswd = "";
					lUserName = (String)request.getParameter("Name");
					lUserPswd = (String)request.getParameter("Password");
					CompanyDBobj userLoginDBObj = new CompanyDBobj();
					CompanyDBMethods userLoginDBMethods = new  CompanyDBMethods(lDBUser,lDBPswd,lDBUrl);
					userLoginDBObj = (CompanyDBobj)userLoginDBMethods.getRecord2ByPrimaryKey(lUserName,lUserPswd);
					if ( userLoginDBObj != null && ( userLoginDBObj.Id != null && (userLoginDBObj.Id).length() > 0) ){
						target = "/CompanyMain.jsp";
					}
					else{
						String lErrorMsg = "User Does Not Exist!!"; 
						session.setAttribute("lErrorMsg",lErrorMsg);
						target = "/CompanyLogin.jsp";
					}	
			}
		
			else if(request.getParameter("action").equals("View") ){
				System.out.println("in the View");
				ArrayList candidateList = new ArrayList();
				String criteria = "";
				candidateList = (ArrayList)employeeDBMethods.selectEmployeeByCriteria(criteria);
				session.setAttribute("CompanyList",candidateList);
				target = "/Companies.jsp";			
				//target = "/jsp/employee_search.jsp"; //action = "people_employee_detail";
			} // 
		
			else if(request.getParameter("action").equals("Job") ) {
				JobDBobj popEmployeeDBObj = new JobDBobj(); 
				popEmployeeDBObj = (JobDBobj)jobDBMethods.populateEmployeeDBObjFromReq(request);
				try {
					int rval =  jobDBMethods.insertEmployee(popEmployeeDBObj);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String lErrorMsg = "Employee is Added!!"; 
				session.setAttribute("lErrorMsg",lErrorMsg);
				target = "/CompanyMain.jsp";  //target = "/jsp/employee_edit.jsp";
		}
			

		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(target);
	    requestDispatcher.forward(request, response);
	}

}
