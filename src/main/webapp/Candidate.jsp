<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Candidate.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<body>

<table class="table table-dark">
<%! CandidateDBobj employeeDBObj;
ArrayList candidateList; // = new ArrayList();
								%>
<thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email Id</th>
      <th scope="col">Number</th>
    </tr>
  </thead>
								
<%
candidateList = new ArrayList();
candidateList = (ArrayList) session.getAttribute("EmployeeList");
if (candidateList != null && candidateList.size() > 0) {
	for (int size = 1; size <= candidateList.size(); size++) {
		employeeDBObj = new  CandidateDBobj();
		employeeDBObj = (CandidateDBobj)candidateList.get(size - 1);
		System.out.println(employeeDBObj.emp_f_name);
									%>		
									
 <tbody>
    <tr>
      <td><%=employeeDBObj.emp_f_name%></td>
      <td><%=employeeDBObj.emp_l_name%></td>
      <td><%=employeeDBObj.email%></td>
      <td><%=employeeDBObj.number%></td>
    </tr>			
	</tbody>
	
	
	<%
												}
												}
											%>
		</table>																	

</body>
</html>