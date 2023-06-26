package controller;

import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.amministratore.AmministratoreBean;
import model.amministratore.AmministratoreBeanDao;
import controller.gestione.amministratore.*;

public class Test_AmministratoreServlet extends AmministratoreServlet{
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
  
  //TC_2.1_1
  @Test
  public void testDoPost1() throws Exception {
    String user = "";
    String password = "qualsiasipassword";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_2
  @Test
  public void testDoPost2() throws Exception {
    String user = "ad£min";
    String password = "qualsiasipassword";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
 
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_3
  @Test
  public void testDoPost3() throws Exception {
    String user = "nonesisteneldb";
    String password = "qualsiasipassword";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
//TC_2.1_4
  @Test
  public void testDoPost4() throws Exception {
    String user = "qualsiasiid";
    String password = "x";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_5
  @Test
  public void testDoPost5() throws Exception {
    String user = "qualsiasiid";
    String password = "passwordlunghissimissima";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_6
  @Test
  public void testDoPost6() throws Exception {
    String user = "qualsiasiid";
    String password = "admi£n";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_7
  @Test
  public void testDoPost7() throws Exception {
    String user = "qualsiasiid";
    String password = "noncorrisponde";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_8
  @Test
  public void testDoPost8() throws Exception {
    String user = "admin";
    String password = "x";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_9
  @Test
  public void testDoPost9() throws Exception {
    String user = "admin";
    String password = "passwordlunghissimissima";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_10
  @Test
  public void testDoPost10() throws Exception {
    String user = "admin";
    String password = "admi£n";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_2.1_11
  @Test
  public void testDoPost11() throws Exception {
    String user = "admin";
    String password = "noncorrisponde";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
 
  //TC_2.1_12
  @Test
  public void testDoPost12() throws Exception {
    String user = "admin";
    String password = "admin";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("GestioneOfferteFormative.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    verify(session).setAttribute("amministratore", user);
    verify(session).setAttribute("password", password);
    verify(requestDispatcher).forward(request, response);
  }
  
}