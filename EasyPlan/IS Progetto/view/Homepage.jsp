<%@page import="model.curriculum.CurriculumBeanDao"%>
<%@page import="model.curriculum.CurriculumBean"%>
<%@page import="java.util.ArrayList" pageEncoding="UTF-8"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
   String utente = (String) session.getAttribute("utente");
   String amministratore = (String) session.getAttribute("amministratore");
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EasyPlan | Homepage</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- for social icon -->
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
		<!-- -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <link rel="stylesheet" href="centerelements.css">
		<style type="text/css">
	    .navbar-inverse {
	   	 background-color: #ada2b2;
	   	 border-color: #ada2b2;
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
				
					<ul class="nav navbar-nav navbar-right">
					<%
  
  					 if (utente != null || amministratore!= null ) {
					%>	
					  <li><a href="Logout" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
					 <%
   					} else {
						%>
						<!-- Login  -->
						<li><a href="Login.jsp" style="color:#000000">Login</a></li>
						
						<!-- Iscriviti -->
						<li><a href="Subscribe.jsp" style="color:#000000">Iscriviti</a></li>
						<%
   						}
						%>
					</ul>
				</div>
			</div>
		</nav>
		<img alt="logo" src="immagini/logo.png" class="img-responsive center-block centerImg">
		
		<div class="col-md-12">
		<form action="SelezionaOffertaFormativa.jsp" method = "post">
   			<button name="button" class="btn btn-default btn-responsive center-block centerButton buttonwidth">Formula il tuo piano di studi</button>
   		</form>
   		
   		</div>
	</body>
</html>