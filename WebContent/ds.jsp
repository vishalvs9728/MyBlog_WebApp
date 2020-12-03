
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
      <%@page import="com.major.project.helper.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Structures</title>
<!-- css -->


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="icon" type="image/png" href="images/logo1.jpg" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
<link rel="stylesheet" href="css/myStyle.css">

  
  <style>
  .banner-background
  {clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);}
  .post-title
  {
  font-weight:100;
  font:size:30px;
  }
  .post-content
  {
  font-weight:100;
  font:size:25px;
  text-align:center;
  }
  .post-code
  {
  text-align:center;}
  .post-user
  {
  font-weight:100;
  font:size:30px;
  }
  .useremail
  {
  font-weight:100;
  font:size:25px;
  font-color:black;
  }
  .row-user
  {
  border:1px solid #e2e2e3;
  padding-top:10px;
  }
  </style>
</head>
<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg navbar-dark primary-background">
  <a class="navbar-brand" href="index.jsp"><span class="fa fa-asterisk"></span>MyBlog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="profile.jsp"><span class="fa fa-bell"></span>Profile<span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <span class="fa fa-check-square-o"></span> Catagories   </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Java Servlet</a>
          <a class="dropdown-item" href="#">Java JSP</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Oracle11g</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="contact.jsp"><span class="fa fa-address-book"></span> Contact</a>
      </li>      
       </li>
      <li class="nav-item">
        <a class="nav-link " href="#" data-toggle="modal" data-target="#add-post-modal"><span class="fa fa-check-square-o"></span> DoPost</a>
      </li> 
    </ul>
    
    
    
    
  </div>
  
</nav>

<!-- end of nav -->


<!-- banner -->
 <div class="container-fluid p-0 m-0">

            <div class="jumbotron primary-background text-white banner-background">
                <div class="container">
                    <h3 class="display-3 ">       Welcome to Data Structures </h3>
                    
                    <img src="pics/ds.png">
           <br>
           <br>
               
               
              <p class="text-dark"><b>What is Data Structures</b></p>
<p>Data Structures in C are used to store data in an organised and efficient manner. 
The C Programming language has many data structures like an array, stack, queue, linked list, 
tree, etc. A programmer selects an appropriate data structure and uses it according to their convenience.

Let us look into some of these data structures:</p>
 <ul class="list-group">

  
  <li class="list-group-item list-group-item-primary">Array</li>
  <li class="list-group-item list-group-item-secondary">Stack</li>
  <li class="list-group-item list-group-item-success">Queue</li>
  <li class="list-group-item list-group-item-danger">Linked List</li>
  <li class="list-group-item list-group-item-warning">Circular Linked List</li>
  <li class="list-group-item list-group-item-info">Hashing</li>
  <li class="list-group-item list-group-item-dark">Trees</li>
  
</ul>
 
                 
<bR>
<bR>
<br>
                </div>
            </div>
        </div>

 

<!-- javascript -->

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
 integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" 
 crossorigin="anonymous"></script>
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" 
crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
crossorigin="anonymous"></script>


</body>
</html>