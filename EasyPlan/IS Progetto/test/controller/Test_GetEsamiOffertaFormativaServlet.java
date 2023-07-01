package controller;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import model.offerta.formativa.OffertaFormativaBean;
import controller.user.GetEsamiOffertaFormativaServlet;

public class Test_GetEsamiOffertaFormativaServlet extends GetEsamiOffertaFormativaServlet{
	@Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;
    
    @Mock
    private HttpSession session;

    @Mock
    private RequestDispatcher requestDispatcher;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    //TC_1.3.1
    @Test
    void testDoPost1() throws ServletException, IOException, ClassNotFoundException, SQLException {
        // Mock dei parametri della richiesta
        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
        when(request.getParameter("laurea")).thenReturn("1");
        when(request.getParameter("curricula")).thenReturn("1");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn("utente");
        
        // Mock della RequestDispatcher
        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);

       
        // Chiamata al metodo doPost della servlet
        doPost(request, response);

        // Verifica delle interazioni e delle asserzioni
        verify(request).getParameter("nomeOfferta");
        verify(request).getParameter("laurea");
        verify(request).getParameter("curricula");
        // Verifica che l'offerta formativa abbia i valori desiderati
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        Assertions.assertEquals(1, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
        Assertions.assertEquals(1, offertaFormativa.getLauree().get(0).isTipo());
        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
        Assertions.assertEquals(1, offertaFormativa.getLauree().get(0).getCurricula().get(0).getIdCurriculum());
        verify(requestDispatcher).forward(request, response);
    }
   
    //TC_1.3.2
    @Test
    void testDoPost2() throws ServletException, IOException, ClassNotFoundException, SQLException {
        // Mock dei parametri della richiesta
        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
        when(request.getParameter("laurea")).thenReturn("2");
        when(request.getParameter("curricula")).thenReturn("6");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn("utente");

        // Mock della RequestDispatcher
        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);

        // Chiamata al metodo doPost della servlet
        doPost(request, response);

        // Verifica delle interazioni e delle asserzioni
        verify(request).getParameter("nomeOfferta");
        verify(request).getParameter("laurea");
        verify(request).getParameter("curricula");
        // Verifica che l'offerta formativa abbia i valori desiderati
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).isTipo());
        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
        Assertions.assertEquals(6, offertaFormativa.getLauree().get(0).getCurricula().get(0).getIdCurriculum());
        verify(requestDispatcher).forward(request, response);
    }
    
    //TC_1.3.3
    @Test
    void testDoPost3() throws ServletException, IOException, ClassNotFoundException, SQLException {
        // Mock dei parametri della richiesta
        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
        when(request.getParameter("laurea")).thenReturn("2");
        when(request.getParameter("curricula")).thenReturn("4");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn("utente");

        // Mock della RequestDispatcher
        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);

        // Chiamata al metodo doPost della servlet
        doPost(request, response);

        // Verifica delle interazioni e delle asserzioni
        verify(request).getParameter("nomeOfferta");
        verify(request).getParameter("laurea");
        verify(request).getParameter("curricula");
        // Verifica che l'offerta formativa abbia i valori desiderati
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).isTipo());
        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
        Assertions.assertEquals(4, offertaFormativa.getLauree().get(0).getCurricula().get(0).getIdCurriculum());
        verify(requestDispatcher).forward(request, response);
    }
    
   //TC_1.3.4
    @Test
    void testDoPost4() throws ServletException, IOException, ClassNotFoundException, SQLException {
        // Mock dei parametri della richiesta
        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
        when(request.getParameter("laurea")).thenReturn("2");
        when(request.getParameter("curricula")).thenReturn("5");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn("utente");

        // Mock della RequestDispatcher
        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);

        // Chiamata al metodo doPost della servlet
        doPost(request, response);

        // Verifica delle interazioni e delle asserzioni
        verify(request).getParameter("nomeOfferta");
        verify(request).getParameter("laurea");
        verify(request).getParameter("curricula");
        // Verifica che l'offerta formativa abbia i valori desiderati
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).isTipo());
        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
        Assertions.assertEquals(5, offertaFormativa.getLauree().get(0).getCurricula().get(0).getIdCurriculum());
        verify(requestDispatcher).forward(request, response);
    }
    
    //TC_1.3.5
    @Test
    void testDoPost5() throws ServletException, IOException, ClassNotFoundException, SQLException {
        // Mock dei parametri della richiesta
        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
        when(request.getParameter("laurea")).thenReturn("2");
        when(request.getParameter("curricula")).thenReturn("2");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn("utente");

        // Mock della RequestDispatcher
        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);

        // Chiamata al metodo doPost della servlet
        doPost(request, response);

        // Verifica delle interazioni e delle asserzioni
        verify(request).getParameter("nomeOfferta");
        verify(request).getParameter("laurea");
        verify(request).getParameter("curricula");
        // Verifica che l'offerta formativa abbia i valori desiderati
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).isTipo());
        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getCurricula().get(0).getIdCurriculum());
        verify(requestDispatcher).forward(request, response);
    }
    
    //TC_1.3.6
    @Test
    void testDoPost6() throws ServletException, IOException, ClassNotFoundException, SQLException {
        // Mock dei parametri della richiesta
        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
        when(request.getParameter("laurea")).thenReturn("2");
        when(request.getParameter("curricula")).thenReturn("3");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("utente")).thenReturn("utente");

        // Mock della RequestDispatcher
        when(request.getRequestDispatcher("FormulazionePiano.jsp")).thenReturn(requestDispatcher);

        // Chiamata al metodo doPost della servlet
        doPost(request, response);

        // Verifica delle interazioni e delle asserzioni
        verify(request).getParameter("nomeOfferta");
        verify(request).getParameter("laurea");
        verify(request).getParameter("curricula");
        // Verifica che l'offerta formativa abbia i valori desiderati
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).isTipo());
        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
        Assertions.assertEquals(3, offertaFormativa.getLauree().get(0).getCurricula().get(0).getIdCurriculum());
        verify(requestDispatcher).forward(request, response);
    }
    
   
}
