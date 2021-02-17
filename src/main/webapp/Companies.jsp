<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="CompanyServelet.*"%>
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
<%! CompanyDBobj employeeDBObj2;
ArrayList employeeList; // = new ArrayList();
								%>
<thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Email Id</th>
    </tr>
  </thead>
								
<%
employeeList = new ArrayList();
employeeList = (ArrayList)session.getAttribute("CompanyList");
if (employeeList != null && employeeList.size() > 0) {
	for (int size = 1; size <= employeeList.size(); size++) {
		employeeDBObj2 = new  CompanyDBobj();
		employeeDBObj2 = (CompanyDBobj)employeeList.get(size - 1);
		System.out.println(employeeDBObj2.Name);
									%>		
									
 <tbody>
    <tr>
      <td><%=employeeDBObj2.Name%></td>
      <td><%=employeeDBObj2.email%></td>
    </tr>			
	</tbody>
	
	
	<%
												}
												}
											%>
		</table>																	

</body>
</html>