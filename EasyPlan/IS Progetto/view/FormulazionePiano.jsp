<%@page import="model.corso.di.laurea.CorsoDiLaureaBeanDao"%>
<%@page import="model.esame.EsameBeanDao"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.ArrayList"
    pageEncoding="UTF-8" import="model.offerta.formativa.OffertaFormativaBean" import="model.corso.di.laurea.CorsoDiLaureaBean"
    import="model.curriculum.CurriculumBean" import="model.esame.EsameBean" import="model.docente.DocenteBean"
    import="model.gruppo.esami.GruppoEsamiObbligatoriBean" import="model.gruppo.esami.GruppoEsamiOpzionaliBean" 
    import="java.sql.Connection" import="java.sql.DriverManager" import="java.sql.ResultSet"
    import="java.sql.SQLException" import="java.sql.Statement" import="model.DriverManagerConnectionPool" import="model.esame.EsameBeanDao"
    import="model.curriculum.CurriculumBeanDao" import="model.docente.DocenteBean" import="model.docente.DocenteBeanDao" import=" java.util.HashSet"
 %>
    
      
     <%! @SuppressWarnings("unchecked") %>
     <%
     	// Simulazione dati presi dal database
     	//se non è vuota viene presa da una sessione precedentemente salvata come json
  		OffertaFormativaBean of= new OffertaFormativaBean();
      if(request.getAttribute("offertaFormativa")!=null ){
     	 of = (OffertaFormativaBean) request.getAttribute("offertaFormativa");}
      else{
    	   of = (OffertaFormativaBean) session.getAttribute("offertaFormativa");}
      
        
    	ArrayList<CorsoDiLaureaBean> cd = of.getLauree();
    	
    	
    	ArrayList<CurriculumBean> cm = cd.get(0).getCurricula();
    	ArrayList<GruppoEsamiObbligatoriBean> gob = cm.get(0).getGruppi_obbligatori();
    	ArrayList<GruppoEsamiOpzionaliBean> gop = cm.get(0).getGruppi_opzionali();
    	ArrayList<EsameBean> sceltalibera= new ArrayList<>();
    	String utente= null;
    
    	
    	ArrayList<GruppoEsamiObbligatoriBean> ob1 = new ArrayList<GruppoEsamiObbligatoriBean>();
    	ArrayList<GruppoEsamiObbligatoriBean>  ob2 = new ArrayList<GruppoEsamiObbligatoriBean>();
    	ArrayList<GruppoEsamiObbligatoriBean> ob3 = new  ArrayList<GruppoEsamiObbligatoriBean>();
    	ArrayList<GruppoEsamiOpzionaliBean> op1 = new ArrayList<GruppoEsamiOpzionaliBean>();
    	ArrayList<GruppoEsamiOpzionaliBean>  op2 = new ArrayList<GruppoEsamiOpzionaliBean>();
    	ArrayList<GruppoEsamiOpzionaliBean> op3 = new  ArrayList<GruppoEsamiOpzionaliBean>();
    	
    	for(int i = 0; i < gob.size(); i++ ){
    		if(gob.get(i).getAnno() == 1)
    			ob1.add(gob.get(i));
    		else if(gob.get(i).getAnno() == 2)
    			ob2.add(gob.get(i));
    		else if(gob.get(i).getAnno() == 3)
    			ob3.add(gob.get(i));
    	}
    	
    	for(int i = 0; i < gop.size(); i++ ){
    		if(gop.get(i).getAnno() == 1)
    			op1.add(gop.get(i));
    		else if(gop.get(i).getAnno() == 2)
    			op2.add(gop.get(i));
    		else if(gop.get(i).getAnno() == 3)
    			op3.add(gop.get(i));
    	}
    	
    	if(session.getAttribute("obbligatori1") != null){
    		ob1 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori1");
    		session.removeAttribute("obbligatori1");
    		session.setAttribute("obbligatori1", ob1);
    	}else
    		session.setAttribute("obbligatori1", ob1);
    	
    	if(session.getAttribute("obbligatori2") != null){
    		ob2 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori2");
    		session.removeAttribute("obbligatori2");
    		session.setAttribute("obbligatori2", ob2);
    	}
    	else
    		session.setAttribute("obbligatori2", ob2);
    	
    	if(session.getAttribute("obbligatori3") != null){
    		ob3 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori3");
    		session.removeAttribute("obbligatori3");
    		session.setAttribute("obbligatori3", ob3);
    	}else
    		session.setAttribute("obbligatori3", ob3);
    	
    	
    	if(session.getAttribute("opzionali1") != null){
    		op1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali1");
    		session.removeAttribute("opzionali1");
    		session.setAttribute("opzionali1", op1);
    	}else
    		session.setAttribute("opzionali1", op1);
    	
    	if(session.getAttribute("opzionali2") != null){
    		op2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali2");
    		session.removeAttribute("opzionali2");
    		session.setAttribute("opzionali2", op2);
    	}
    	else
    		session.setAttribute("opzionali2", op2);
    	
    	if(session.getAttribute("opzionali3") != null){
    		op3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali3");
    		session.removeAttribute("opzionali3");
    		session.setAttribute("opzionali3", op3);
    	}else
    		session.setAttribute("opzionali3", op3);
    	
    	
    	
    	  //Nuova Sezione dedicata al prelievo di tutti gli esami dell'offerta formativa per creare la scelta libera
    	
 if (session.getAttribute("libera") != null) {
    sceltalibera = (ArrayList<EsameBean>) session.getAttribute("libera");
    session.removeAttribute("libera");
    session.setAttribute("libera", sceltalibera);
} else {
    int codiceob = ob1.get(0).getCodiceGeOb(); // contiene la tipologia tra triennale e magistrale
    Connection conn = DriverManagerConnectionPool.getConnection();
    String query = null;
    String query2 = null;

    if (codiceob > 2) {
        query = "SELECT CodiceEsame FROM formato WHERE CodiceGEOp >= 2";
    } else {
        query = "SELECT CodiceEsame FROM formato WHERE CodiceGEOp = 1";
    }

    Statement statement = conn.createStatement();
    ResultSet res = statement.executeQuery(query);

    EsameBeanDao esamdao = new EsameBeanDao();
    DocenteBeanDao docentdao = new DocenteBeanDao();

    // Use a HashSet to store unique EsameBean objects
    HashSet<EsameBean> uniqueEsami = new HashSet<>();

    while (res.next()) {
        int value = res.getInt("CodiceEsame");
        EsameBean esam = esamdao.doRetrieveByKey(value);
        if (!sceltalibera.contains(esam)) {
            ArrayList<DocenteBean> proflibero = new ArrayList<>();
            query2 = "SELECT CodiceDocente FROM insegnamento WHERE CodiceEsame = '" + value + "'";
            statement = conn.createStatement();
            ResultSet res2 = statement.executeQuery(query2);

            while (res2.next()) {
                DocenteBean doc = docentdao.doRetrieveByKey(res2.getInt("CodiceDocente"));
                proflibero.add(doc);
            }

            esam.setDocenti(proflibero);
            uniqueEsami.add(esam);
        }
    }
    
   

    for (int i = 0; i < gob.size(); i++) {
        ArrayList<EsameBean> esamiDaRimuovere = gob.get(i).getEsami();
        uniqueEsami.removeAll(esamiDaRimuovere);
    }
    HashSet<EsameBean> uniqueEsamiSenzaNull = new HashSet<>(uniqueEsami);

    uniqueEsamiSenzaNull.remove(null);
    // Conversione di uniqueEsami HashSet in ArrayList
    sceltalibera = new ArrayList<>(uniqueEsamiSenzaNull);

  
    session.setAttribute("libera", sceltalibera);
}

    	  
 if(request.getAttribute("utente") != null){
	 
	 
		utente= (String)request.getAttribute("utente");
		System.out.println(utente);
		session.removeAttribute("utente");
		session.setAttribute("utente", utente);}
    	  
 else if(session.getAttribute("utente") != null ){
	 utente= (String)session.getAttribute("utente");
		System.out.println(utente);
		session.removeAttribute("utente");
		session.setAttribute("utente", utente);}
	 
 

    	session.setAttribute("offertaFormativa",of);
    	
     %>
     
     
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>EasyPlan | Piano di studio</title>
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
    .table-wrapper-scroll-y {
		display: block;
		max-height: 200px;
		overflow-y: auto;
		-ms-overflow-style: -ms-autohiding-scrollbar;
	}
	form{
		display:contents;
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
    <form action="getCurriculaFromLaureaOff" method = "post">
    	  <input type="hidden" name="nomeOfferta" value="<%=of.getAnnoOffertaFormativa() %>">
	      <input type="hidden" name="laurea" value="<%=cd.get(0).isTipo()%>">
    	<button name="button" id="laureaScelta" class="btn btn-default btn-responsive left-block">Indietro</button>
    </form>
    <%if(session.getAttribute("errore")!= null){ %>
    	<h4  style="color:red; text-align:center"><%=session.getAttribute("errore") %></h4>
    <%session.removeAttribute("errore");} %>
    <div class="col-md-12">
    	<!-- esami obbligatori anno 1 -->
   		<%for(int i = 0; i < ob1.size(); i++){ %>
    		
    			<h3><b><%=ob1.get(i).getAnno()+"° anno obbligatorio" %></b></h3>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col" style="width:70%">Nome esame</th><th scope="col" style="width:15%">CFU</th><th scope="col"style="width:15%">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for(int j = 0; j < ob1.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=ob1.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=ob1.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=ob1.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=ob1.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < ob1.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=ob1.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=ob1.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=ob1.get(i).getEsami().get(j).getCfu()%></td>
        					<td>
        					<form action="selectionOfferta"  method = "post">
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in" id="" disabled checked>
        							<span class="checkmark"></span>
								</label>
							</form>
        					</td>
      					</tr>
      					
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	    <%} %>
	    <!-- esami opzionali anno 1 -->
    		<%for(int i = 0; i < op1.size(); i++){ %>
    			<h3><b><%=op1.get(i).getAnno()+"° anno opzionale CFU minimi selezionabili: "+ op1.get(i).getTotCfu() %></b></h3>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col" style="width:70%">Nome esame</th><th scope="col" style="width:15%">CFU</th><th scope="col"style="width:15%">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for( int j = 0 ; j < op1.get(i).getEsami().size(); j++){%>
    					  <tr>
    					  
        					  <th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=op1.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=op1.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=op1.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=op1.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < op1.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=op1.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=op1.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=op1.get(i).getEsami().get(j).getCfu()%></td>
        					<td>
        					<form action="selectionOfferta" method = "post">
    						  <input type="hidden" name="gruppoopz" value="opzA1<%=+i%>">
    						  <input type="hidden" name="cfu" value="<%=op1.get(i).getTotCfu()%>">
    						  <input type="hidden" name="esame" value="<%=op1.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<input type="hidden" name="metodo" value="<%=op1.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<% if(op1.get(i).getEsami().get(j).isCheck()) {  %>
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in" checked name="check<%=op1.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">	
        							<span class="checkmark"></span>
								</label>
        					<%}else {  %>
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in"  name="check<%=op1.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">	
        							<span class="checkmark"></span>
								</label>
        					<%} %>	
        					</form>
        					</td>
      					</tr>
						  <%} %>
	     		</tbody>
	     	</table>
	     </div>
		 <%} %>
	   <!-- esami obbligatori anno 2 -->
    	<%for(int i = 0; i < ob2.size(); i++){ %>
    		
    			<h3><b><%=ob2.get(i).getAnno()+"° anno obbligatorio" %></b></h3>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col" style="width:70%">Nome esame</th><th scope="col" style="width:15%">CFU</th><th scope="col"style="width:15%">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for(int j = 0; j < ob2.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=ob2.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=ob2.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=ob2.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=ob2.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < ob2.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=ob2.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=ob2.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=ob2.get(i).getEsami().get(j).getCfu()%></td>
        					<td>
        					<form action="selectionOfferta" method = "post">
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in" id="" disabled checked>
        							<span class="checkmark"></span>
								</label>
							</form>
        					</td>
      					</tr>
      					
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	    <%} %>
	    <!-- esami opzionali anno 2 -->
    		<%for(int i = 0; i < op2.size(); i++){ %>
    			<h3><b><%=op2.get(i).getAnno()+"° anno opzionale CFU minimi selezionabili: "+ op2.get(i).getTotCfu() %></b></h3>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col" style="width:70%">Nome esame</th><th scope="col" style="width:15%">CFU</th><th scope="col"style="width:15%">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for( int j = 0 ; j < op2.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  
        					  <th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=op2.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=op2.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=op2.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=op2.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < op2.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=op2.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=op2.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=op2.get(i).getEsami().get(j).getCfu()%></td>
        					<td>
        					<form action="selectionOfferta" method = "post">
    						  <input type="hidden" name="gruppoopz" value="opzA2<%=+i%>">
    						  <input type="hidden" name="cfu" value="<%=op2.get(i).getTotCfu()%>">
    						  <input type="hidden" name="esame" value="<%=op2.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<input type="hidden" name="metodo" value="<%=op2.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<% if(op2.get(i).getEsami().get(j).isCheck()) {  %>
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in" checked name="check<%=op2.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">	
        							<span class="checkmark"></span>
								</label>
        					<%}else {  %>
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in"  name="check<%=op2.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">	
        							<span class="checkmark"></span>
								</label>
        					<%} %>
        						</form>	
        					</td>
      					</tr>
      				
					 <%} %>
	     		</tbody>
	     	</table>
	     </div>
		 <%} %>
      <!-- esami obbligatori anno 3 -->
    <%for(int i = 0; i < ob3.size(); i++){ %>
    		
    			<h3><b><%=ob3.get(i).getAnno()+"° anno obbligatorio" %></b></h3>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col" style="width:70%">Nome esame</th><th scope="col" style="width:15%">CFU</th><th scope="col"style="width:15%">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for(int j = 0; j < ob3.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  
        					<th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=ob3.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=ob3.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=ob3.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=ob3.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < ob3.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=ob3.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=ob3.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=ob3.get(i).getEsami().get(j).getCfu()%></td>
        					<td>
        					<form action="selectionOfferta" method = "post">
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in" id="" disabled checked>
        							<span class="checkmark"></span>
								</label>
								</form>
        					</td>
      					</tr>
      					
	     			<%} %>
	     		</tbody>
	     	</table>
	     </div>
	    <%} %>
	    <!-- esami opzionali anno 3 -->
    		<%for(int i = 0; i < op3.size(); i++){ %>
    			<h3><b><%=op3.get(i).getAnno()+"° anno opzionale CFU minimi selezionabili: "+ op3.get(i).getTotCfu() %></b></h3>
    			
    			<div class="table-wrapper-scroll-y">
	   				<table class="table table-bordered table-striped">
						<thead>
      						<tr>
				        		<th scope="col" style="width:70%">Nome esame</th><th scope="col" style="width:15%">CFU</th><th scope="col"style="width:15%">Selezionato</th>
      						</tr>
    					</thead>
    				<tbody>
	   					<% for( int j = 0 ; j < op3.get(i).getEsami().size(); j++){ %>
    					  <tr>
    					  
        					  <th scope="row"><a  data-toggle="collapse" href="#collapseExample<%=op3.get(i).getEsami().get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%=op3.get(i).getEsami().get(j).getNome()%></a>
        						<div class="collapse" id="collapseExample<%=op3.get(i).getEsami().get(j).getCodiceEsame()%>">
 			 						<div class="card card-body">
   									  Descrizione <%=op3.get(i).getEsami().get(j).getDescrizione()%><br>
   									  <%for(int z = 0; z < op3.get(i).getEsami().get(j).getDocenti().size(); z++){ %>
   									 	<a href=" <%=op3.get(i).getEsami().get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
   									  <%} %>
   									 ore di lezione <%=op3.get(i).getEsami().get(j).getOreLezione() %><br>
  									</div>
								</div>
       						</th>
        					<td><%=op3.get(i).getEsami().get(j).getCfu()%></td>
        					<td>
        					<form action="selectionOfferta" method = "post">
    						  <input type="hidden" name="gruppoopz" value="opzA3<%=+i%>">
    						  <input type="hidden" name="cfu" value="<%=op3.get(i).getTotCfu()%>">
    						  <input type="hidden" name="esame" value="<%=op3.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<input type="hidden" name="metodo" value="<%=op3.get(i).getEsami().get(j).getCodiceEsame()%>">
        					<% if(op3.get(i).getEsami().get(j).isCheck()) {  %>
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in" checked name="check<%=op3.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">	
        							<span class="checkmark"></span>
								</label>
        					<%}else {  %>
        						<label class="c">
        							<input type="checkbox" class="form-check-input filled-in"  name="check<%=op3.get(i).getEsami().get(j).getCodiceEsame()%>" onChange="this.form.submit()">	
        							<span class="checkmark"></span>
								</label>
        					<%} %>	
        					</form>
        					</td>
      					</tr>
      					
						<%} %>
	     		</tbody>
	     	</table>
	     </div>
	     <%} %>
		  <!-- Scelta libera -->
		  <h3><b>Scelta libera CFU minimi selezionabili: 12</b></h3>

		<div class="table-wrapper-scroll-y">
		  <table class="table table-bordered table-striped">
		    <thead>
		      <tr>
		        <th scope="col" style="width: 70%">Nome esame</th>
		        <th scope="col" style="width: 15%">CFU</th>
		        <th scope="col" style="width: 15%">Selezionato</th>
		      </tr>
		    </thead>
		    <tbody>
		      <% for (int j = 0; j < sceltalibera.size(); j++) { %>
		      <tr>
		        <th scope="row">
		          <a data-toggle="collapse" href="#collapseScelta<%= sceltalibera.get(j).getCodiceEsame() %>" role="button" aria-expanded="false" aria-controls="collapseExample"><%= sceltalibera.get(j).getNome() %></a>
		         <div class="collapse" id="collapseScelta<%= sceltalibera.get(j).getCodiceEsame() %>">
		            <div class="card card-body">
		              Descrizione <%= sceltalibera.get(j).getDescrizione() %><br>
		              <% for (int z = 0; z < sceltalibera.get(j).getDocenti().size(); z++) { %>
		                <a href="<%= sceltalibera.get(j).getDocenti().get(z).getIndirizzoPaginaWeb() %>">link docente <%=(z + 1) %></a><br>
		              <% } %>
		              Ore di lezione <%= sceltalibera.get(j).getOreLezione() %><br>
		            </div>
		          </div>
		        </th>
		        <td><%= sceltalibera.get(j).getCfu() %></td>
		        <td>
		          <form action="selectionOfferta" method="post">
		             <input type="hidden" name="gruppolib" value="lib">
		            <!-- Potrebbe essere necessario reinserire il campo dei CFU -->
		            <input type="hidden" name="esame" value="<%= sceltalibera.get(j).getCodiceEsame() %>">
		            <input type="hidden" name="metodo" value="<%= sceltalibera.get(j).getCodiceEsame() %>">
		            <% if (sceltalibera.get(j).isCheck()) { %>
		              <label class="c">
		                <input type="checkbox" class="form-check-input filled-in" checked name="check<%= sceltalibera.get(j).getCodiceEsame() %>" onChange="this.form.submit()">
		                <span class="checkmark"></span>
		              </label>
		            <% } else { %>
		              <label class="c">
		                <input type="checkbox" class="form-check-input filled-in" name="check<%= sceltalibera.get(j).getCodiceEsame() %>" onChange="this.form.submit()">
		                <span class="checkmark"></span>
		              </label>
		            <% } %>
		          </form>
		        </td>
		      </tr>
		      <% } 
		      %>
		    </tbody>
		  </table>
		</div>

	     
    
    
    </div>
    
    <br>
    <br>
	<form action="selectionOfferta" method="Post">
		<input type="hidden" name="metodo" value="fine">
   		<button name="fine" id="fine" class="btn btn-default btn-responsive center-block buttonwidth">Fine</button>
  	</form>
  	<br>
  	<%
  	 if (utente != null ) {
					%>	
					  
					
  <button id="salva" class="btn btn-default btn-responsive center-block buttonwidth">Salva per dopo</button>

  <div id="nomePopup" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Inserisci un nome</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <input type="text" id="nome" placeholder="Inserisci un nome" class="form-control">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary" id="salvaPopup">Salva</button>
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Annulla</button>
        </div>
      </div>
    </div>
  </div>


  <script>
    $(document).ready(function() {
      $("#salva").click(function() {
        $("#nomePopup").modal('show');
      });

      $("#salvaPopup").click(function() {
        var nome = $("#nome").val();
        var utente = '<%= session.getAttribute("utente") %>';
        var risultato = utente + nome;
        console.log(risultato);

        $.ajax({
          url: "selectionOfferta",
          type: "POST",
          data: {
            metodo: "salva",
            risultato: risultato
          },
          success: function(response) {
            // La richiesta è stata elaborata con successo
            console.log(response);
          },
          error: function(xhr, status, error) {
            // Si è verificato un errore durante la richiesta
            console.error(error);
          }
        });

        $("#nomePopup").modal('hide');
      });
    });
  </script>
  	 <%
   					} %>
  </body>
</html>