

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Candidate.CandidateDBMethods;
import Candidate.CandidateDBobj;
import Jobs.JobDBobj;
import Jobs.JobDBMethods;

/**
 * Servlet implementation class Applicant
 */
public class Applicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String lDBUser = "";
	String lDBPswd = "";
	String lDBUrl = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Applicant() {
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
		CandidateDBMethods employeeDBMethods = new CandidateDBMethods(lDBUser,lDBPswd,lDBUrl);
		JobDBMethods jobDBMethods = new JobDBMethods(lDBUser,lDBPswd,lDBUrl);
		lDBOpr = (String)request.getParameter("dbopr");
		if (request.getParameter("action").equals("insert")){
			CandidateDBobj popEmployeeDBObj = new CandidateDBobj(); 
			popEmployeeDBObj = (CandidateDBobj)employeeDBMethods.populateEmployeeDBObjFromReq(request);
			CandidateDBobj employeeDBObj = new CandidateDBobj();
			employeeDBObj = (CandidateDBobj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.emp_id,popEmployeeDBObj.emp_f_name);
			if ( (popEmployeeDBObj.emp_id).equals(employeeDBObj.emp_id) && (popEmployeeDBObj.emp_f_name).equals(employeeDBObj.emp_f_name) ){
				String lErrorMsg = "Employee Already Exist"; 
				session.setAttribute("lErrorMsg",lErrorMsg);
				System.out.println("Employee:" + lErrorMsg);
				target = "/CandidateRegister.jsp";
			}
			else{
				try {
					int rval =  employeeDBMethods.insertEmployee(popEmployeeDBObj);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CandidateDBobj sEmployeeDBObj = new CandidateDBobj();
				sEmployeeDBObj = (CandidateDBobj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.emp_id,popEmployeeDBObj.emp_f_name);
				session.setAttribute("employeeDBObj",sEmployeeDBObj);
				String lErrorMsg = "Employee is Added!!"; 
				session.setAttribute("lErrorMsg",lErrorMsg);
				target = "/CandidateMain.jsp";  //target = "/jsp/employee_edit.jsp";
		}

		}
		else
		if (request.getParameter("action").equals("Login")) {
			System.out.println("in the Login");
				String lUserName = "";	
				String lUserPswd = "";
				lUserName = (String)request.getParameter("Name");
				lUserPswd = (String)request.getParameter("Password");
				CandidateDBobj userLoginDBObj = new CandidateDBobj();
				 CandidateDBMethods userLoginDBMethods = new  CandidateDBMethods(lDBUser,lDBPswd,lDBUrl);
				userLoginDBObj = (CandidateDBobj )userLoginDBMethods.getRecord2ByPrimaryKey(lUserName,lUserPswd);
				if ( userLoginDBObj != null && ( userLoginDBObj.emp_id != null && (userLoginDBObj.emp_id).length() > 0) ){
					target = "/CandidateMain.jsp";
				}
				else{
					String lErrorMsg = "User Does Not Exist!!"; 
					session.setAttribute("lErrorMsg",lErrorMsg);
					target = "/CandidateLogin.jsp";
				}	
		}
		else
			if(request.getParameter("action").equals("View")) {
				ArrayList employeeList = new ArrayList();
				String criteria = "";
				employeeList = (ArrayList)employeeDBMethods.selectEmployeeByCriteria(criteria);
				session.setAttribute("EmployeeList",employeeList);
				target = "/Candidate.jsp";	
			}
			else
				if(request.getParameter("action").equals("Update")) {
					target="/CandidateUpdate.jsp";
				}
				else 
					if(request.getParameter("action").equals("Edit")) {
						System.out.println("in the Edit");
						CandidateDBobj popEmployeeDBObj = new CandidateDBobj();
						popEmployeeDBObj = (CandidateDBobj)employeeDBMethods.populateEmployeeDBObjFromReq(request);
						int rval;
						try {
							rval = employeeDBMethods.updateEmployeeByPrimaryKey(popEmployeeDBObj);
						
						if ( rval > 0 ){   
							CandidateDBobj employeeDBObj = new CandidateDBobj();
                						employeeDBObj = (CandidateDBobj)employeeDBMethods.getRecordByPrimaryKey(popEmployeeDBObj.emp_id,popEmployeeDBObj.emp_f_name);
							session.setAttribute("employeeDBObj",employeeDBObj);
							String lErrorMsg = "Employee is Updated!!"; 
							session.setAttribute("lErrorMsg",lErrorMsg);
							target = "/CandidateMain.jsp";// "/jsp/employee_edit.jsp";
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
		
					else
						if(request.getParameter("action").equals("search")) {
							System.out.println("in the Search jobs");
							
								String lEmpId = "";
								
								lEmpId = (String)request.getParameter("job");
								JobDBobj jobDBObj = new JobDBobj();
								jobDBObj = (JobDBobj)jobDBMethods.getRecordByPrimaryKey(lEmpId);
								System.out.println("iiiii="+jobDBObj.Job);
								if ( (jobDBObj.Job != null)){
									ArrayList employeeList = new ArrayList();
									String criteria = "where Job ='"+jobDBObj.Job+"' ";
									employeeList = (ArrayList)jobDBMethods.selectEmployeeByCriteria(criteria);
									session.setAttribute("EmployeeList",employeeList);
									target = "/JobSearch.jsp";
								}
								else{
									String lErrorMsg = "doesn't Exist"; 
									session.setAttribute("lErrorMsg",lErrorMsg);
									System.out.println("job" + lErrorMsg);
									target = "/CandidateMain.jsp";  // Added here in stead of people_default.jsp
								    }
							}   
						
					
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(target);
	    requestDispatcher.forward(request, response);
		
	}
}
