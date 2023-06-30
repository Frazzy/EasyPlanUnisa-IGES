<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8" import="model.offerta.formativa.OffertaFormativaBean" import="model.corso.di.laurea.CorsoDiLaureaBean"
    import="model.curriculum.CurriculumBean"%>
    
    
     <%
     	// Simulazione dati presi dal database
     	OffertaFormativaBean of = (OffertaFormativaBean) request.getAttribute("offertaFormativa"); 
    	ArrayList<CorsoDiLaureaBean> cd = of.getLauree();
    	ArrayList<CurriculumBean> cm = cd.get(0).getCurricula();
    	String utente = (String) session.getAttribute("utente");
     %>
     
     
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Scelta curricula</title>
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
    
    .centerImg{
    	 position: relative;
	margin-top:4%;
	margin-bottom:2%;
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
  
  					 if (utente != null) {
					%>	
					  <li><a href="Logout" style="color:#000000">Log out <span class="glyphicon glyphicon-log-out"></span></a></li>
					   <li><a href="PlanLoader.jsp" style="color:#000000">Carica un piano <span class="glyphicon glyphicon-log-out"></span></a></li>
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
		    <form action="getCorsiDiLaureaServlet" method = "post">
    	<input type="hidden" name="nomeOfferta" value="<%=of.getAnnoOffertaFormativa() %>">
    	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive left-block">Indietro</button>
    </form>
    <img alt="logo" src="immagini/logo.png" class="img-responsive center-block centerImg">
    <div class="col-md-12">
	    <%for(int i = 0; i < cm.size(); i++){ %>
	    <form action="getEsamiOffertaFormativa" method = "post">
		    <input type="hidden" name="nomeOfferta" value="<%=of.getAnnoOffertaFormativa() %>">
	      	<input type="hidden" name="laurea" value="<%=cd.get(0).isTipo()%>">
	        <input type="hidden" name=curricula value="<%=cm.get(i).getIdCurriculum()%>">
	        <%if(cm.get(i).getNomeCurriculum().equalsIgnoreCase("Sistemi Informatici e Tecnologie del Software (SITS)")){ %>
	        <button name="button" id="c"<%=+cm.get(i).getIdCurriculum()%> class="btn btn-default btn-responsive center-block buttonwidth"><%="SITS" %></button>
	        <%}else{ %>
		    <button name="button" id="c"<%=+cm.get(i).getIdCurriculum()%> class="btn btn-default btn-responsive center-block buttonwidth"><%=cm.get(i).getNomeCurriculum() %></button>
		    <%} %>
		    <br>
	    </form>
	     <%}%>
    </div>
  </body>
</html>