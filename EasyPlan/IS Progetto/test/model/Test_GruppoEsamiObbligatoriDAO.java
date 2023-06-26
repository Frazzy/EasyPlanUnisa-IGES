package model;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.*;
import org.junit.jupiter.api.Assertions;

import model.gruppo.esami.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.GruppoEsamiObbligatoriBeanDao;


public class Test_GruppoEsamiObbligatoriDAO {
	private GruppoEsamiObbligatoriBeanDao dao;
	  
	  @Before
	  public void setUp() {
	    dao = new GruppoEsamiObbligatoriBeanDao();
	  }
	  
	  @After
	  public void tearDown() {
	    dao = null;
	  }
	  
	  @Test
	  public void testDoSave() throws IOException {
	    GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
	    gb.setCodiceGeOb(101);
	    gb.setAnno(2);
	    gb.setIdCurriculum(2);
	    
	   
	      int result = dao.doSave(gb);
	      Assertions.assertEquals(2, result);
	      dao.doDelete(101);
	    
	  }
	  
	  @Test
	  public void testDoSaveOrUpdate() throws IOException {
	    GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
	    gb.setCodiceGeOb(101);
	    gb.setAnno(2);
	    gb.setIdCurriculum(2);
	    
	    
	      boolean result = dao.doSaveOrUpdate(gb);
	      Assertions.assertTrue(result);
	      dao.doDelete(101);
	  }
	  
	  @Test
	  public void testDoRetrieveByKey() {
	    int codiceGeOb = 1;
	    
	    GruppoEsamiObbligatoriBean gb = dao.doRetrieveByKey(codiceGeOb);
	    assertNotNull(gb);
	    Assertions.assertEquals(codiceGeOb, gb.getCodiceGeOb());
	  }
	  
	  @Test
	  public void testDoRetriveAll() throws ClassNotFoundException, SQLException {
	    ArrayList<GruppoEsamiObbligatoriBean> lista = dao.doRetriveAll();
	    assertNotNull(lista);
	    Assertions.assertFalse(lista.isEmpty());
	  }
	  
	  @Test
	  public void testDoDelete() throws IOException {
		 GruppoEsamiObbligatoriBean gb = new GruppoEsamiObbligatoriBean();
		 gb.setCodiceGeOb(101);
		 gb.setAnno(2);
		 gb.setIdCurriculum(2);
		 dao.doSave(gb);
	     boolean result = dao.doDelete(101);
	     Assertions.assertTrue(result);
	    
	  }
	  
	  @Test
	  public void testDoRetriveGruppoEsamiObbByOfferta() throws ClassNotFoundException, SQLException {
	    String anno = "2018/19";
	    int laurea = 1;
	    String curricula = "Curriculum Standard";
	    
	    ArrayList<GruppoEsamiObbligatoriBean> lista = dao.doRetriveGruppoEsamiObbByOfferta(anno, laurea, curricula);
	    assertNotNull(lista);
	    Assertions.assertFalse(lista.isEmpty());
	  }
	  
	  @Test
	  public void testDoRetriveGruppoEsamiObbByOffertaAndAnno() throws ClassNotFoundException, SQLException {
	    String offertaForm = "2018/19";
	    int laurea = 1;
	    String curricula = "Curriculum Standard";
	    int anno = 1;
	    
	    ArrayList<GruppoEsamiObbligatoriBean> lista = dao.doRetriveGruppoEsamiObbByOffertaAndAnno(offertaForm, laurea, curricula, anno);
	    assertNotNull(lista);
	    Assertions.assertFalse(lista.isEmpty());
	  }
	  
	  @Test
	  public void testDeleteEsame() {
		  int codiceEsame=13;
	      int codiceGruppo=1;
		  try {
			dao.insertEsameInGruppo(codiceGruppo, codiceEsame);
			int result= dao.deleteEsame(codiceGruppo, codiceEsame);
			Assertions.assertEquals(1, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  @Test
	  public void testDeleteEsameInGruppo() {
		  int codiceEsame=13;
	      int codiceGruppo=1;
		  try {
			dao.insertEsameInGruppo(codiceGruppo, codiceEsame);
			int result= dao.deleteEsameInGruppo(codiceGruppo, codiceEsame);
			Assertions.assertEquals(1, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	  }

	   @Test
	  public void testInsertEsameInGruppo()  {
	    
	     int codiceEsame=13;
	     int codiceGruppo=1;
	     try {
			int result= dao.insertEsameInGruppo(codiceGruppo, codiceEsame);
			Assertions.assertEquals(1, result);
			dao.deleteEsameInGruppo(codiceGruppo, codiceEsame);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  @Test
	  public void testDoRetrieveLastId() {
	  
	      int lastId = dao.doRetrieveLastId();
	      Assertions.assertTrue(lastId > 0);
	  
	  }
	  

}
