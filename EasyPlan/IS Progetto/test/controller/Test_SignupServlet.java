package controller;

import static org.mockito.Mockito.*;

import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import controller.user.*;
import model.utente.UtenteBean;
import model.utente.UtenteBeanDao;

public class Test_SignupServlet extends SignupServlet{
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
  
  //TC_3.1_1
  @Test
  public void testDoPost1() throws Exception {
    String user = "";
    String password = "qualsiasipassword";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_2
  @Test
  public void testDoPost2() throws Exception {
    String user = "ad£min";
    String password = "qualsiasipassword";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
 
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_3
  @Test
  public void testDoPost3() throws Exception {
    String user = "admin";//gia esiste nel db
    String password = "qualsiasipass";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    //when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    String errorMessage = "Username già in uso, scegliere un altro username";
    String redirectURL = "Subscribe.jsp?error=" + URLEncoder.encode(errorMessage, "UTF-8");
    verify(response).sendRedirect(redirectURL);
    
  }
  //TC_3.1_4
  @Test
  public void testDoPost4() throws Exception {
    String user = "qualsiasiid";
    String password = "a";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_5
  @Test
  public void testDoPost5() throws Exception {
    String user = "qualsiasiid";
    String password = "passwordlunghissimissima";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_6
  @Test
  public void testDoPost6() throws Exception {
    String user = "qualsiasiid";
    String password = "Pass%$£word";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_7
  @Test
  public void testDoPost7() throws Exception {
    String user = "francesco1997";
    String password = "a";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_8
  @Test
  public void testDoPost8() throws Exception {
    String user = "francesco1997";
    String password = "passwordlunghissimissima";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_9
  @Test
  public void testDoPost9() throws Exception {
    String user = "francesco1997";
    String password = "Pass%$£word";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
    
    when(request.getRequestDispatcher("Signup.jsp")).thenReturn(requestDispatcher);
    
    doPost(request, response);
    
    
    verify(requestDispatcher).forward(request, response);
  }
  //TC_3.1_10
  @Test
  public void testDoPost10() throws Exception {
    String user = "francescoa";
    String password = "francesco97";
    
    when(request.getParameter("username")).thenReturn(user);
    when(request.getParameter("pwd")).thenReturn(password);
    when(request.getSession(true)).thenReturn(session);
   
    when(request.getRequestDispatcher("Homepage.jsp")).thenReturn(requestDispatcher);
    when(request.getSession()).thenReturn(session);
    
    doPost(request, response);
    
  
    verify(response).sendRedirect("Homepage.jsp");
    UtenteBeanDao canc = new UtenteBeanDao();
    canc.doDelete(user);
    
  }
  
  
}