package integration;

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

import java.io.File;
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


public class IntTest_SelectionOffertaServlet extends SelectionOffertaServlet {
	
	
	ArrayList<GruppoEsamiObbligatoriBean> obbligatori1List = new ArrayList<GruppoEsamiObbligatoriBean>();
	ArrayList<GruppoEsamiObbligatoriBean> obbligatori2List = new ArrayList<GruppoEsamiObbligatoriBean>();
	ArrayList<GruppoEsamiObbligatoriBean> obbligatori3List = new ArrayList<GruppoEsamiObbligatoriBean>();
	ArrayList<GruppoEsamiOpzionaliBean> opzionali1List = new ArrayList<GruppoEsamiOpzionaliBean>();
	ArrayList<GruppoEsamiOpzionaliBean> opzionali2List = new ArrayList<GruppoEsamiOpzionaliBean>();
	ArrayList<GruppoEsamiOpzionaliBean> opzionali3List = new ArrayList<GruppoEsamiOpzionaliBean>();
	ArrayList<EsameBean> esamiLib= new ArrayList<>();
	ArrayList<EsameBean> esame1list= new ArrayList<EsameBean>();
	ArrayList<EsameBean> esame2list= new ArrayList<EsameBean>();
	ArrayList<EsameBean> esame3list= new ArrayList<EsameBean>();
	
	OffertaFormativaBean offertaFormativa= new OffertaFormativaBean();
	
	GruppoEsamiObbligatoriBean obbligatori1 = new GruppoEsamiObbligatoriBean();
	GruppoEsamiObbligatoriBean obbligatori2 = new GruppoEsamiObbligatoriBean();
	GruppoEsamiObbligatoriBean obbligatori3= new GruppoEsamiObbligatoriBean();
	
	GruppoEsamiOpzionaliBean opzionali1= new GruppoEsamiOpzionaliBean();
	GruppoEsamiOpzionaliBean opzionali2 = new GruppoEsamiOpzionaliBean();
	GruppoEsamiOpzionaliBean opzionali3= new GruppoEsamiOpzionaliBean();
	
	EsameBean esame1= new EsameBean();
	EsameBean esame2= new EsameBean();
	EsameBean esame3= new EsameBean();
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame3.setCfu(22);
        esame3list.add(esame3);
        opzionali3.setTotCfu(24);
        opzionali3.setEsami(esame3list);
        opzionali3List.add(opzionali3);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        opzionali3.setTotCfu(24);
        opzionali3List.add(opzionali3);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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
	 
    	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame3.setCfu(25);
        esame3list.add(esame3);
        opzionali3.setTotCfu(24);
        opzionali3.setEsami(esame3list);
        opzionali3List.add(opzionali3);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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
    
    //TC_1.4.4
    @Test
    public void testDoPostTri4() throws ServletException, IOException {
	 
    	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame3.setCfu(22);
        esame3list.add(esame3);
        opzionali3.setTotCfu(24);
        opzionali3.setEsami(esame3list);
        opzionali3List.add(opzionali3);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
      	
      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
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
	 
    	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame3.setCfu(25);
        esame3list.add(esame3);
        opzionali3.setTotCfu(24);
        opzionali3.setEsami(esame3list);
        opzionali3List.add(opzionali3);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
      	
      	when(sessionMock.getAttribute("totalecfuSelLib")).thenReturn(12);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(22);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        opzionali2.setTotCfu(24);
        opzionali2List.add(opzionali2);
               
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        opzionali1.setTotCfu(24);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(22);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        opzionali1.setTotCfu(24);
        opzionali1List.add(opzionali1);
        
        opzionali2.setTotCfu(24);
        opzionali2List.add(opzionali2);
        
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(28);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(22);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(22);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(28);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(28);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        opzionali2.setTotCfu(24);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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
    
    //TC_1.5.7
    @Test
    public void testDoPostMag7() throws ServletException, IOException {
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        opzionali1.setTotCfu(24);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(28);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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
    
    //TC_1.5.8
    @Test
    public void testDoPostMag8() throws ServletException, IOException {
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(22);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        opzionali2.setTotCfu(24);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
      	
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        opzionali1.setTotCfu(24);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(22);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(28);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(28);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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
    
    //TC_1.5.11
    @Test
    public void testDoPostMag11() throws ServletException, IOException {
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(28);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(22);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(22);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(28);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
	 
      	obbligatori1List.add(obbligatori1);
        obbligatori2List.add(obbligatori2); 
        obbligatori3List.add(obbligatori3);
        
        esame1.setCfu(28);
        esame1list.add(esame1);
        opzionali1.setTotCfu(24);
        opzionali1.setEsami(esame1list);
        opzionali1List.add(opzionali1);
        
        esame2.setCfu(28);
        esame2list.add(esame2);
        opzionali2.setTotCfu(24);
        opzionali2.setEsami(esame2list);
        opzionali2List.add(opzionali2);
       
        // Impostazione del comportamento del mock di HttpSession
      	when(request.getSession(true)).thenReturn(sessionMock);
      	// Impostazione degli attributi della sessione
      	when(request.getParameter("metodo")).thenReturn("fine");
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
      	when(sessionMock.getAttribute("obbligatori1")).thenReturn(obbligatori1List);
      	when(sessionMock.getAttribute("obbligatori2")).thenReturn(obbligatori2List);
      	when(sessionMock.getAttribute("obbligatori3")).thenReturn(obbligatori3List);
      	when(sessionMock.getAttribute("o1")).thenReturn(opzionali1List);
      	when(sessionMock.getAttribute("o2")).thenReturn(opzionali2List);
      	when(sessionMock.getAttribute("o3")).thenReturn(opzionali3List);
      	when(sessionMock.getAttribute("libera")).thenReturn(esamiLib);
        
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
      	when(sessionMock.getAttribute("offertaFormativa")).thenReturn(offertaFormativa);
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


