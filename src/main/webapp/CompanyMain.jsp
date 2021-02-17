<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
.header .container{
justify-content:space-between;
}

</style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="./css/all.min.css" type="text/css">
    <script src="https://kit.fontawesome.com/e557ea031c.js"></script>
    <link rel="stylesheet" href="./css/page2.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    <div class="header">
        <div class="container">
            <div id="logo">
                <h6>Workconic</h6>
             </div>
             <div id="Update">
                <h6><a href="#">Post Job</a></h6>
             </div>
             <div id="logout">
                <h6><a href="#">Log Out</a></h6>
             </div>
        </div>
    </div>
    <hr color="#ECECEC">
    <div class="main">
        <div class="container">
            <div class="card" style="width: 18rem;">
                <img src="./images/view.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                  
                  <p class="card-text">At Workconic we provide you the future managers of your company around the world</p>
                  <form action="Applicant">
                  <button name="action" type="submit" value="View" class="btn btn-primary">View Applicants</button></form>
                </div>
              </div>
              <div class="card" style="width: 18rem;">
                <img src="./images/download.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text">Add new Jobs for fresh minds out there</p>
                  <a href="#" class="btn btn-primary">Post Test</a>
                </div>
              </div>
              <div class="card" style="width: 18rem;">
                <img src="./images/images.png" class="card-img-top" alt="...">
                <div class="card-body">
                  <p class="card-text">Provide some challenging questions to test the capabilities of the aspirants</p>
           
               <a href="AddJobs.jsp"> <button class="btn btn-primary">Add Jobs</button></a>
                </div>
              </div>
        </div>

    </div>
</body>
</html>