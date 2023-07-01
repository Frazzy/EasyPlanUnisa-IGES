package controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.user.LoadPlanServlet;

public class Test_LoadPlanServlet extends LoadPlanServlet{
	@Mock
	  private HttpServletRequest request;
	  
	  @Mock
	  private HttpServletResponse response;
	  
	  @Mock
	  private HttpSession session;
	  
	  @Mock
	  private RequestDispatcher requestDispatcher;
	  
	  
	  @Before
	  public void setUp() throws Exception {
	    MockitoAnnotations.openMocks(this);
	  }
	  
	  //TC_5.1_1
	  @Test
	  public void testDoPost1() throws Exception {
		  
	    String dir = System.getProperty("user.dir") + "/test/controller/fileprova.json";
		  	    
	    when(request.getSession(true)).thenReturn(session);
	    when(request.getParameter("jsonFile")).thenReturn(dir);
	    
	    when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);
	    
	    doPost(request, response);
	    verify(requestDispatcher).forward(request, response);
	  }

}
