package model;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.*;
import org.junit.jupiter.api.Order;


import model.corso.di.laurea.CorsoDiLaureaBean;
import model.corso.di.laurea.CorsoDiLaureaBeanDao;
 
public class Test_CorsoDiLaureaDAO {
  
  private CorsoDiLaureaBeanDao corsoDao;
  
  @Before
  public void setUp() {
    corsoDao = new CorsoDiLaureaBeanDao();
    
  }
  
  @Test
  public void testDoSave() throws IOException {
    CorsoDiLaureaBean corso = new CorsoDiLaureaBean();
    corso.setIdCorsoDiLaurea(10);
    corso.setTipo(2);
    corso.setAnnoOffertaFormativa("2018/19");
    
    int result = corsoDao.doSave(corso);
    
    assertEquals(10, result);
    corsoDao.doDelete(10);
    
    
  }
 
  @Test
  public void testDoSaveOrUpdate() throws IOException {
    CorsoDiLaureaBean corso = new CorsoDiLaureaBean();
    corso.setIdCorsoDiLaurea(10);
    corso.setTipo(3);
    corso.setAnnoOffertaFormativa("2018/19");
    
    boolean result = corsoDao.doSaveOrUpdate(corso);
    
    assertTrue(result);
    corsoDao.doDelete(10);
    
  }

  @Test
  public void testDoRetrieveByKey() {
    int idCorsoDiLaurea = 1;
    
    CorsoDiLaureaBean corso = corsoDao.doRetrieveByKey(idCorsoDiLaurea);
    
    assertEquals(idCorsoDiLaurea, corso.getIdCorsoDiLaurea());
    
  }

  @Test
  public void testDoRetriveAll() throws ClassNotFoundException, SQLException {
    ArrayList<CorsoDiLaureaBean> lista = corsoDao.doRetriveAll();
    
    assertNotNull(lista);
   
  }
   
  @Test
  public void testGetCorsiLaureaOfferta() {
    String nomeOfferta = "2018/19";
ArrayList<CorsoDiLaureaBean> listaCorsi = corsoDao.getCorsiLaureaOfferta(nomeOfferta);
    
    assertNotNull(listaCorsi);
    
  }

  @Test
  public void testDoRetrieveLastId() {
    int lastId = corsoDao.doRetrieveLastId();
    assertNotNull(lastId);
    
  }

  @Test
  public void testDoRetriveCorsoDiLaureaInOfferta() {
    String annoOfferta = "2018/19";
    
    ArrayList<CorsoDiLaureaBean> listaCorsi = corsoDao.doRetriveCorsoDiLaureaInOfferta(annoOfferta);
    
    assertNotNull(listaCorsi);
    
  }
  
  @Test
  public void testDoDelete() throws IOException {  
	  CorsoDiLaureaBean corso = new CorsoDiLaureaBean();
	    corso.setIdCorsoDiLaurea(11);
	    corso.setTipo(2);
	    corso.setAnnoOffertaFormativa("2018/19");  
	corsoDao.doSave(corso);
    assertEquals(true, corsoDao.doDelete(11));
    
  }
}

