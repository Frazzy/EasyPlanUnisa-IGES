package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controller.user.GetCurriculaFromLaureaOffServlet;
import model.corso.di.laurea.CorsoDiLaureaBeanDao;
import model.curriculum.*;
import model.corso.di.laurea.*;
import model.offerta.formativa.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test_GetCurriculaFromLaureaOffServlet extends GetCurriculaFromLaureaOffServlet {
	
	  @Mock
	    private HttpServletRequest request;

	    @Mock
	    private HttpServletResponse response;

	    @Mock
	    private RequestDispatcher requestDispatcher;


	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	  //TC_1.2.1
	    @Test
	    void testDoPost1() throws ServletException, IOException, ClassNotFoundException, SQLException {
	        // Mock dei parametri della richiesta
	        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
	        when(request.getParameter("laurea")).thenReturn("1");

	        // Mock della RequestDispatcher
	        when(request.getRequestDispatcher("SelezionaCurricula.jsp")).thenReturn(requestDispatcher);

	        // Chiamata al metodo doPost della servlet
	        doPost(request, response);

	        // Verifica delle interazioni e delle asserzioni
	        verify(request).getParameter("nomeOfferta");
	        verify(request).getParameter("laurea");
	        // Verifica che l'offerta formativa abbia i valori desiderati
	        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
	        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
	        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
	        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
	        Assertions.assertEquals(1, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
	        Assertions.assertEquals(1, offertaFormativa.getLauree().get(0).isTipo());
	        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
	        verify(requestDispatcher).forward(request, response);
	    }
	    
	    //TC_1.2.2
	    @Test
	    void testDoPost2() throws ServletException, IOException, ClassNotFoundException, SQLException {
	        // Mock dei parametri della richiesta
	        when(request.getParameter("nomeOfferta")).thenReturn("2018/2019");
	        when(request.getParameter("laurea")).thenReturn("2");

	        // Mock della RequestDispatcher
	        when(request.getRequestDispatcher("SelezionaCurricula.jsp")).thenReturn(requestDispatcher);

	        // Chiamata al metodo doPost della servlet
	        doPost(request, response);

	        // Verifica delle interazioni e delle asserzioni
	        verify(request).getParameter("nomeOfferta");
	        verify(request).getParameter("laurea");
	        // Verifica che l'offerta formativa abbia i valori desiderati
	        ArgumentCaptor<OffertaFormativaBean> offertaFormativaCaptor = ArgumentCaptor.forClass(OffertaFormativaBean.class);
	        verify(request).setAttribute(eq("offertaFormativa"), offertaFormativaCaptor.capture());
	        OffertaFormativaBean offertaFormativa = offertaFormativaCaptor.getValue();
	        Assertions.assertEquals("2018/2019", offertaFormativa.getAnnoOffertaFormativa());
	        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).getIdCorsoDiLaurea());
	        Assertions.assertEquals(2, offertaFormativa.getLauree().get(0).isTipo());
	        Assertions.assertEquals("2018/19", offertaFormativa.getLauree().get(0).getAnnoOffertaFormativa());
	        verify(requestDispatcher).forward(request, response);
	    }

}
