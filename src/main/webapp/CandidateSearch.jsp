<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
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
								<p>&nbsp;</p>
								<div align=center>Enter Your Id & First Name</div>
								<hr bgcolor="#AAAAAA" width=500>
								<table border="0" align="top" width=50% align="right">
									<form action="Applicant" name="form1" method="post">
										<tr>
											<td>Employee Id</td>
											<td align='left'><input type='text' name='emp_id'
												id='emp_id ' value='' /></td>
										</tr>
										<tr>
											<td>First Name</td>
											<td align='left'><input type='text' name='emp_f_name'
												id='emp_f_name ' size='10' value='' /></td>
										</tr>
										<tr>
											<td align='center' colspan='2'><input type='submit'
												name='action' value="Edit" /></td>
										</tr>
										
									</form>
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