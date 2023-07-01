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

import controller.user.*;

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
        when(request.getSession(false)).thenReturn(session);

        // Chiamata al metodo da testare
        doPost(request, response);

        // Verifica delle interazioni e asserzioni
        verify(session).invalidate();
        verify(response).sendRedirect("Homepage.jsp");
    }
}


