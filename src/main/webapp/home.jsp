<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="./css/mainpage.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/mainpage.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    <div id="header">
        <div class="container">
            <div id="logo">
               <h1>Workconic</h1>
            </div>
            <div class="admin">
                <button type="button" class="btn btn-outline-primary waves-effect">HR Admin</button>
            </div>
        </div>
    </div>

    <div id="main">
        <div class="container">
            <div class="image1">
            <img src="./images/1.jpg" height ="300px" width="350px" alt="">
        </div>
            <div id="button1">
                
                  <a href="CompanyRegister.jsp">  <button type="button" class="btn btn-outline-primary waves-effect">For Companies</button></a>

            </div>
        </div>
    </div>
    <div id="main2">
        <div class="fluid-container">
            <div class="image2">
                <img src="./images/2.jpg" height="400px" width="500px" alt="">

            </div>
            <div id="button2">
            
              <a href="CandidateRegister.jsp">      <button type="submit" class="btn btn-outline-primary">For Applications </button></a>
                    
            </div>
        </div>
    </div>
</body>
</html>