package model;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import model.gruppo.esami.GruppoEsamiOpzionaliBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBeanDao;

public class Test_GruppoEsamiOpzionaliDAO {
	private GruppoEsamiOpzionaliBeanDao dao;
	  
	  @Before
	  public void setUp() {
	    dao = new GruppoEsamiOpzionaliBeanDao();
	  }
	  
	  @After
	  public void tearDown() {
	    dao = null;
	  }
	  
	  @Test
	  public void testDoSave() throws IOException {
	    GruppoEsamiOpzionaliBean gb = new GruppoEsamiOpzionaliBean();
	    gb.setCodiceGeOp(101);
	    gb.setAnno(2);
	    gb.setTotCfu(30);
	    gb.setIdCurriculum(2);
	    
	   
	      int result = dao.doSave(gb);
	      Assertions.assertEquals(2, result);
	      dao.doDelete(101);
	    
	  }
	  
	  @Test
	  public void testDoSaveOrUpdate() throws IOException {
	    GruppoEsamiOpzionaliBean gb = new GruppoEsamiOpzionaliBean();
	    gb.setCodiceGeOp(102);
	    gb.setAnno(2);
	    gb.setTotCfu(30);
	    gb.setIdCurriculum(2);
	    
	    
	   boolean result = dao.doSaveOrUpdate(gb);
	   Assertions.assertTrue(result);
	   dao.doDelete(102);
	  }
	  
	  @Test
	  public void testDoRetrieveByKey() {
	    int codiceGeOb = 1;
	    
	    GruppoEsamiOpzionaliBean gb = dao.doRetrieveByKey(codiceGeOb);
	    assertNotNull(gb);
	    Assertions.assertEquals(codiceGeOb, gb.getCodiceGeOp());
	  }
	  
	  @Test
	  public void testDoRetriveAll() throws ClassNotFoundException, SQLException {
	    ArrayList<GruppoEsamiOpzionaliBean> lista = dao.doRetriveAll();
	    assertNotNull(lista);
	    Assertions.assertFalse(lista.isEmpty());
	  }
	  
	  @Test
	  public void testDoDelete() throws IOException {
		 GruppoEsamiOpzionaliBean gb = new GruppoEsamiOpzionaliBean();
		 gb.setCodiceGeOp(103);
		 gb.setAnno(2);
		 gb.setTotCfu(30);
		 gb.setIdCurriculum(2);
		 dao.doSave(gb);
	     boolean result = dao.doDelete(103);
	     Assertions.assertTrue(result);
	    
	  }
	  
	  @Test
	  public void testDoRetriveGruppoEsamiOpzByOfferta() throws ClassNotFoundException, SQLException {
	    String anno = "2018/19";
	    int laurea = 1;
	    String curricula = "Curriculum Standard";
	    
	    ArrayList<GruppoEsamiOpzionaliBean> lista = dao.doRetriveGruppoEsamiOpzByOfferta(anno, laurea, curricula);
	    assertNotNull(lista);
	    Assertions.assertFalse(lista.isEmpty());
	  }
	  
	  @Test
	  public void testDoRetriveGruppoEsamiOpzByOffertaAndAnno() throws ClassNotFoundException, SQLException {
	    String offertaForm = "2018/19";
	    int laurea = 2;
	    String curricula = "Sicurezza Informatica";
	    int anno = 1;
	    
	    ArrayList<GruppoEsamiOpzionaliBean> lista = dao.doRetriveGruppoEsamiOpzByOffertaAndAnno(offertaForm, laurea, curricula, anno);
	    assertNotNull(lista);
	    Assertions.assertFalse(lista.isEmpty());
	  }
	  
	  @Test
	  public void testDeleteEsame() {
		  int codiceEsame=39;
		  int codiceGruppo=1;;
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
		  int codiceEsame=39;
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
	    
	     int codiceEsame=39;
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
		  public void testUpdateTotCfu()  {
		   GruppoEsamiOpzionaliBean gb = new GruppoEsamiOpzionaliBean();
			 gb.setCodiceGeOp(104);
			 gb.setAnno(2);
			 gb.setTotCfu(30);
			 gb.setIdCurriculum(2);
			 try {
				dao.doSave(gb);
				boolean result= dao.updateTotCfu(104, 24);
				Assertions.assertTrue(result);
				dao.doDelete(104);
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
