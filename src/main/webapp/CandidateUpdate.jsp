<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="Candidate.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#center{
	margin-left:100px;
}

</style>
<meta charset="ISO-8859-1">
<title>Edit Information</title>

<link rel="stylesheet" href="./css/mystyle.css" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="page-out">
		<div class="page-in">
			<div class="page">
				<div class="main">

					<table width="900" border="0" align="center">
						<tr>
							<td width="750" valign="top" align="center">
								<p>&nbsp;</p>  Details
								<hr width=100% color=#AAAAAA>
								<table border="0" align="top" width=100%>

									<%
									CandidateDBobj employeeDBObj = new CandidateDBobj();
										employeeDBObj = (CandidateDBobj) session.getAttribute("employeeDBObj");
									%>
									<form name="form1" action="Applicant" method="post">
									<tr>
									<td>ID</td>
									<td>	<input  name='emp_id' id='emp_id'
											value="" /> </td>
									<tr>
										<td>First Name</td>
										<td align='left'><input type='text' 
											name='emp_f_name' id='emp_f_name_dup' size='10'
											value="" /></td>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
											<td>Last Name</td>
											<td><input
											type='text'  name='emp_l_name'
											id='emp_l_name' size='10'
											value="" /></td>
										
									</tr>
									<tr>
										<td>Number</td>
										<td align='left'><input type='number'
											name='number' id='org_id' size='10'
											value="" /></td>
										
									</tr>
									<tr>
										<td>Email</td>
										<td align='left'><input type='email' name='email'
											id='dept_id' size='10' value="" />
										</td>
										<td>Password</td>
										<td align='left'><input type='password' name='newpass' id='city'
											size='10' value="" /></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<div id="center">
									<tr>
									<td><input type="submit" name="action" value="Edit"></td>									
									</tr>
									</div>
								
								</table>
								<hr width=100% color=#AAAAAA>
							</td>
						</tr>
					</table>

								</div>
			</div>
		</div>
	</div>
</body>
</html>