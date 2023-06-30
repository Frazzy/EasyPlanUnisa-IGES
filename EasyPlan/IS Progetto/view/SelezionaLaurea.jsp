<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8" import="model.offerta.formativa.OffertaFormativaBean" import="model.corso.di.laurea.CorsoDiLaureaBean"%>
    
    <%
    	OffertaFormativaBean of = (OffertaFormativaBean) request.getAttribute("offertaFormativa"); 
    	ArrayList<CorsoDiLaureaBean> cd = of.getLauree();
    	String utente = (String) session.getAttribute("utente");
    	   
    %>
    
    
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
  
  					 if (utente != null ) {
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
    <form action="SelezionaOffertaFormativa.jsp" method = "post">
    	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive left-block">Indietro</button>
    </form>
    <img alt="logo" src="immagini/logo.png" class="img-responsive center-block centerImg">

    <div class="col-md-12">
    <%for(int i =0; i < cd.size(); i++){ %>
    <%if(cd.get(i).isTipo()==1){ %>
    <form action="getCurriculaFromLaureaOff" method = "post">
      	<input type="hidden" name="nomeOfferta" value="<%=of.getAnnoOffertaFormativa() %>">
      	<input type="hidden" name="laurea" value="<%=cd.get(i).isTipo()%>">
         <button name="button" id="l<%=+cd.get(i).getIdCorsoDiLaurea() %>" <%=+cd.get(i).getIdCorsoDiLaurea() %> class="btn btn-default btn-responsive center-block buttonwidth">Laurea triennale</button>
    </form>
    <%}else{
    	%>
    	<form action="getCurriculaFromLaureaOff" method = "post">
      	<br>
      	<input type="hidden" name="nomeOfferta" value="<%=of.getAnnoOffertaFormativa() %>">
      	<input type="hidden" name="laurea" value="<%=cd.get(i).isTipo()%>">
         <button name="button" id="l<%=+cd.get(i).getIdCorsoDiLaurea() %>" <%=+cd.get(i).getIdCorsoDiLaurea() %> class="btn btn-default btn-responsive center-block buttonwidth">Laurea magistrale</button>
    </form>
    <%} %>
   <%} %>
       </div>
  </body>
</html>