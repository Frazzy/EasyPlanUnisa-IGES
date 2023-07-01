package controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import model.corso.di.laurea.CorsoDiLaureaBean;
import model.curriculum.CurriculumBean;
import model.esame.EsameBean;
import model.gruppo.esami.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBean;
import model.offerta.formativa.OffertaFormativaBean;
import controller.user.GetEsamiOffertaFormativaServlet;
import controller.user.SelectionOffertaServlet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;


public class Test_SelectionOffertaServlet extends SelectionOffertaServlet {
	
	ArrayList<GruppoEsamiObbligatoriBean> obbligatori1List = new ArrayList<GruppoEsamiObbligatoriBean>();
	ArrayList<GruppoEsamiObbligatoriBean> obbligatori2List = new ArrayList<GruppoEsamiObbligatoriBean>();
	ArrayList<GruppoEsamiObbligatoriBean> obbligatori3List = new ArrayList<GruppoEsamiObbligatoriBean>();
	ArrayList<GruppoEsamiOpzionaliBean> opzionali1List = new ArrayList<GruppoEsamiOpzionaliBean>();
	ArrayList<GruppoEsamiOpzionaliBean> opzionali2List = new ArrayList<GruppoEsamiOpzionaliBean>();
	ArrayList<GruppoEsamiOpzionaliBean> opzionali3List = new ArrayList<GruppoEsamiOpzionaliBean>();
	ArrayList<EsameBean> esamiLib= new ArrayList<>();
	GruppoEsamiOpzionaliMock opzionali1Mock= new GruppoEsamiOpzionaliMock();
	GruppoEsamiOpzionaliMock opzionali2Mock= new GruppoEsamiOpzionaliMock();
	GruppoEsamiOpzionaliMock opzionali3Mock= new GruppoEsamiOpzionaliMock();
	@Mock
	OffertaFormativaBean offertaFormativaMock= Mockito.mock(OffertaFormativaBean.class);
	@Mock
	GruppoEsamiObbligatoriBean obbligatori1Mock = Mockito.mock(GruppoEsamiObbligatoriBean.class);
	@Mock
	GruppoEsamiObbligatoriBean obbligatori2Mock = Mockito.mock(GruppoEsamiObbligatoriBean.class);
	@Mock
	GruppoEsamiObbligatoriBean obbligatori3Mock= Mockito.mock(GruppoEsamiObbligatoriBean.class);
	
	@Mock
	private HttpSession sessionMock=Mockito.mock(HttpSession.class);
	@Mock
	private HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
	@Mock
	private HttpServletResponse response=Mockito.mock(HttpServletResponse.class);
	@Mock
	private RequestDispatcher requestDispatcherMock=Mockito.mock(RequestDispatcher.class);
   
    
	

	    //TC_1.4.1
	    @Test
	    public void testDoPostTri1() throws ServletException, IOException {
		 
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	
	        opzionali3Mock.setTotCfu(24);
	        
	        opzionali3List.add(opzionali3Mock);
	       
	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
	      	
	    	when(opzionali3List.get(0).getEsami().get(0).getCfu()).thenReturn(23); 
	        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	    //TC_1.4.2
	    @Test
	    public void testDoPostTri2() throws ServletException, IOException {
		 
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	
	        opzionali3Mock.setTotCfu(24);
	        
	        opzionali3List.add(opzionali3Mock);
	       
	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	        
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(11);
	        
	        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	    //TC_1.4.3
	    @Test
	    public void testDoPostTri3() throws ServletException, IOException {
		 
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	
	        opzionali3Mock.setTotCfu(24);
	        
	        opzionali3List.add(opzionali3Mock);
	       
	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	        
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(11);
	        when(opzionali3List.get(0).getEsami().get(0).getCfu()).thenReturn(26); 
	        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	    //TC_1.4.4
	    @Test
	    public void testDoPostTri4() throws ServletException, IOException {
		 
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	
	        opzionali3Mock.setTotCfu(24);
	        
	        opzionali3List.add(opzionali3Mock);
	       
	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	        
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
	        when(opzionali3List.get(0).getEsami().get(0).getCfu()).thenReturn(23); 
	        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	    //TC_1.4.5
	    @Test
	    public void testDoPostTri5() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali3Mock.setTotCfu(24);

	        opzionali3List.add(opzionali3Mock);
	       
	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	        
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
	        when(opzionali3List.get(0).getEsami().get(0).getCfu()).thenReturn(24);

	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("PianoDiStudi.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	  //TC_1.5.1
	    @Test
	    public void testDoPostMag1() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	        when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(22);
	             
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	  //TC_1.5.2
	    @Test
	    public void testDoPostMag2() throws ServletException, IOException {

	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	       when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
  
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	  //TC_1.5.3
	    @Test
	    public void testDoPostMag3() throws ServletException, IOException {

	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(11);
  
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	  //TC_1.5.4
	    @Test
	    public void testDoPostMag4() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	  //TC_1.5.5
	    @Test
	    public void testDoPostMag5() throws ServletException, IOException {

	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);
	        
	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(29);

	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	    }
	    
	  //TC_1.5.6
	    @Test
	    public void testDoPostMag6() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(11);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	  //TC_1.5.7
	    @Test
	    public void testDoPostMag7() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(11);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	  //TC_1.5.8
	    @Test
	    public void testDoPostMag8() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	  //TC_1.5.9
	    @Test
	    public void testDoPostMag9() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	    //TC_1.5.10
	    @Test
	    public void testDoPostMag10() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(11);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	    //TC_1.5.11
	    @Test
	    public void testDoPostMag11() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }

	  //TC_1.5.12
	    @Test
	    public void testDoPostMag12() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(24);
	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	  //TC_1.5.13
	    @Test
	    public void testDoPostMag13() throws ServletException, IOException {
		  
	      	obbligatori1List.add(obbligatori1Mock);
	        obbligatori2List.add(obbligatori2Mock); 
	        obbligatori3List.add(obbligatori3Mock);
	        
	        opzionali1Mock.setTotCfu(28);
	        opzionali2Mock.setTotCfu(28);

	        opzionali1List.add(opzionali1Mock);
	        opzionali2List.add(opzionali2Mock);

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("fine");
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);

	      	when(opzionali1List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(opzionali2List.get(0).getEsami().get(0).getCfu()).thenReturn(29);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("PianoDiStudi.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	     }
	    
	  //TC_4.1.1
	    @Test
	    public void testSalvaPiano1() throws ServletException, IOException {
	    	byte[] array = new byte[7]; // length is bounded by 7
	        new Random().nextBytes(array);
	        String risultato = new String(array, Charset.forName("UTF-8"));
	    	String path=System.getProperty("user.dir") + "/JsonSalvatiTest/";
	    	

	        // Impostazione del comportamento del mock di HttpSession
	      	when(request.getSession(true)).thenReturn(sessionMock);
	      	// Impostazione degli attributi della sessione
	      	when(request.getParameter("metodo")).thenReturn("salva");
	      	when(request.getParameter("risultato")).thenReturn(risultato);
	      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativaMock);
	      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
	      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
	      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
	      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
	      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
	      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
	      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
	      	when(sessionMock.getAttribute("utente")).thenReturn("utente");
	      	ServletContext context = Mockito.mock(ServletContext .class);
	      	when(request.getServletContext()).thenReturn(context);
	      	when(context.getRealPath("/")).thenReturn(path);
	      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
	        // Impostazione del comportamento del mock di RequestDispatcher
	        when(request.getRequestDispatcher("Homepage.jsp")).thenReturn(requestDispatcherMock);
	        // Chiamata del metodo doGet() della servlet
	        doPost(request, response);
	        // Verifica dei comportamenti attesi
	        // Esempio: verifica che il metodo forward sia stato chiamato sul mock di RequestDispatcher
	        verify(requestDispatcherMock).forward(request, response);
	        File file = new File(path+ "jsons/"+ risultato + ".json");

	        if (file.delete()) {
	            System.out.println("Il file è stato eliminato con successo.");
	        } else {
	            System.out.println("Impossibile eliminare il file.");
	        }
	     }
	   
	}


