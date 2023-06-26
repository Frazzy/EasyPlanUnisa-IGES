package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.gestione.amministratore.*;

import static org.mockito.Mockito.*;

import java.io.IOException;

class Test_LogoutServlet extends LogoutServlet{
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private Cookie cookie;

   

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
    }
    //TC_2.2.1
    @Test
    public void testDoPost() throws ServletException, IOException {
      // Mock delle dipendenze
      HttpServletRequest request = mock(HttpServletRequest.class);
      HttpServletResponse response = mock(HttpServletResponse.class);
      HttpSession session = mock(HttpSession.class);
      RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);
      
      // Configurazione dei mock
      when(request.getSession(true)).thenReturn(session);
      when(request.getRequestDispatcher("Login.html")).thenReturn(requestDispatcher);
      when(request.getCookies()).thenReturn(new Cookie[]{});
      when(session.getAttribute("amministratore")).thenReturn(true);
      when(session.getAttribute("password")).thenReturn(true);
      
      // Chiamata al metodo da testare
      doPost(request, response);
      
      // Verifica delle interazioni e asserzioni
      verify(session).invalidate();
      verify(request).getCookies();
      verify(requestDispatcher).forward(request, response);
    }
}


