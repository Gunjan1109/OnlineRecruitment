<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.Blue{
background:#17A2B8;
}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="card">
	<div class="Blue">
    <h5 class="card-header blue-color white-text text-center py-4">
        <strong>Sign up</strong>
    </h5>
	</div>
    <div class="card-body px-lg-5 pt-0">

        <form class="md-form" action="Applicant" method="post" style="color: #757575;">
					
					<input type="text" name="emp_id" id="materialRegisterFormid" class="form-control">
                    <label for="materialRegisterFormFirstName">ID on Card</label>
						
					
                    <input type="text" name="emp_f_name" id="materialRegisterFormFirstName" class="form-control">
                    <label for="materialRegisterFormFirstName">First name</label>

                    <input type="text" name="emp_l_name" id="materialRegisterFormLastName" class="form-control">
                    <label for="materialRegisterFormLastName">Last name</label>

                    <input type="email" name="email" id="materialRegisterFormEmail" class="form-control">
                    <label for="materialRegisterFormEmail">E-mail</label>

                    <input type="password" name="newpass" id="materialRegisterFormPassword" class="form-control" aria-describedby="materialRegisterFormPasswordHelpBlock">
                    <label for="materialRegisterFormPassword">Password</label>

                    <small id="materialRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">
                        At least 5 characters and 1 digit
                    </small>

                    <input type="text" name="number" id="materialRegisterFormPhone" class="form-control" aria-describedby="materialRegisterFormPhoneHelpBlock">
                    <label for="materialRegisterFormPhone">Phone number</label>

                    <small id="materialRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">
                        Optional - for two step authentication
                    </small>

                    


            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" name="action" value="insert" type="submit">Sign in</button>
			<p>Already member?
        <a href="CandidateLogin.jsp">Login</a>
    </p>
			
            <div class="text-center">
               
                <hr>

                <p>By clicking
                    <em>Sign up</em> you agree to our
                    <a href="" target="_blank">terms of service</a> and
                    <a href="" target="_blank">terms of service</a>. </p>
            </div>

        </form>
    </div>
</div>
</body>
</html>