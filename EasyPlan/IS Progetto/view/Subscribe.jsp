<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Scelta laurea</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- for social icon -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="loginController.js" ></script>
    <style type="text/css">
        .navbar-inverse {
          background-color: #ada2b2;
          border-color: #ada2b2;
        }
        .navbar-inverse .navbar-nav>li>a {
        color: #000000;
        }
    </style>
    <style>
    .error-message {
        color: red;
        text-align: center;
        margin-top: 20px;
        font-size: 18px;
    }
</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse ">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav navbar-left">
<!-- "Login amministratore" --><li><a href="Homepage.jsp" style="color:#000000" id="BackHome">Torna alla home</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="col-md-12">
      <div class="container">
   		<h2 align="center">Iscriviti</h2>
   		  <%-- Recupera il parametro 'error' dall'URL --%>
			<%
			  String errorMessage = request.getParameter("error");
			%>
			
				<%-- Mostra il messaggio di errore se � presente --%>
			<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
			<div class="error-message">
			    <%= errorMessage %>
			</div>
			<% } %>
    <form class="form-horizontal" id="form" action="SignupServlet" method="post">
    <div class="form-group" >
        <label class="control-label col-sm-5" for="email">Username:</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
      </div>
      <div class="form-group">
        <label class="control-label col-sm-5" for="pwd">Password:</label>
        <div class="col-sm-3">
          <input type="password" class="form-control" id="password" placeholder="Enter password" name="pwd">
        </div>
      </div>
        <div class="col-sm-offset-5 col-sm-10">
          <button type="submit" onclick="validateForm(this.form)" class="btn btn-default" style="margin:0px 0px 0px 45px">Iscriviti</button>
        </div>
			   
     </form>
    </div>
   </div>
  </body>
</html>