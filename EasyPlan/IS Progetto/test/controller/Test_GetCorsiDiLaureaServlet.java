package controller;

import controller.user.GetCorsiDiLaureaServlet;
import model.corso.di.laurea.CorsoDiLaureaBean;
import model.corso.di.laurea.CorsoDiLaureaBeanDao;
import model.offerta.formativa.OffertaFormativaBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Test_GetCorsiDiLaureaServlet extends GetCorsiDiLaureaServlet {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;
    

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    //TC_1.1.1
    @Test
    public void testDoPost() throws ServletException, IOException {
    	String annoOfferta = "2018/2019";

        when(request.getParameter("nomeOfferta")).thenReturn(annoOfferta);
        when(request.getRequestDispatcher("SelezionaLaurea.jsp")).thenReturn(requestDispatcher);
     
        // Call the doPost method of the servlet
        doPost(request, response);
        // Verify interactions and assertions
        verify(request).getParameter("nomeOfferta");
        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
        verify(requestDispatcher).forward(request, response);
    }
}