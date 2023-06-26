package model;

	import org.junit.Assert;
	import org.junit.Before;
	import org.junit.Test;
	import java.io.IOException;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import model.esame.EsameBean;
	import model.esame.EsameBeanDao;

	public class Test_EsameDAO {
	  
	  private EsameBeanDao esameBeanDao;

	  @Before
	  public void setUp() {
	    esameBeanDao = new EsameBeanDao();
	  }

	  @Test
	  public void testDoSave() throws IOException {
	    EsameBean esame = new EsameBean();
	    esame.setCodiceEsame(101);
	    esame.setNome("Esame1");
	    esame.setCfu(6);
	    esame.setOreLezione(40);
	    esame.setSemestre("primo");
	    esame.setDescrizione("Descrizione esame 1");

	    int result = esameBeanDao.doSave(esame);

	    Assert.assertEquals(101, result);
	    esameBeanDao.doDelete(101);
	  }
	  
	  @Test
	  public void testDoSaveOrUpdate() throws IOException {
	    EsameBean esame = new EsameBean();
	    esame.setCodiceEsame(101);
	    esame.setNome("Esame Aggiornato");
	    esame.setCfu(6);
	    esame.setOreLezione(40);
	    esame.setSemestre("secondo");
	    esame.setDescrizione("Descrizione esame aggiornata");

	    boolean result = esameBeanDao.doSaveOrUpdate(esame);

	    Assert.assertTrue(result);
	    esameBeanDao.doDelete(101);
	  }

	  @Test
	  public void testDoRetrieveByKey() {
	    int codiceEsame = 1;

	    EsameBean esame = esameBeanDao.doRetrieveByKey(codiceEsame);

	    Assert.assertEquals(codiceEsame, esame.getCodiceEsame());
	  }

	  @Test
	  public void testDoRetriveAll() throws ClassNotFoundException, SQLException {
	    ArrayList<EsameBean> esami = esameBeanDao.doRetriveAll();

	    Assert.assertNotNull(esami);
	    Assert.assertFalse(esami.isEmpty());
	  }

	  @Test
	  public void testDoDelete() throws IOException {
		  EsameBean esame = new EsameBean();
		  esame.setCodiceEsame(101);
		  esame.setNome("Esame1");
		  esame.setCfu(6);
		  esame.setOreLezione(40);
		  esame.setSemestre("primo");
		  esame.setDescrizione("Descrizione esame 1");
		  esameBeanDao.doSave(esame);

	    boolean result = esameBeanDao.doDelete(101);

	    Assert.assertTrue(result);
	  }

	  @Test
	  public void testDoRetrieveLastId() {
	    int lastId = esameBeanDao.doRetrieveLastId();

	    Assert.assertTrue(lastId >= 0);
	  }
	

}
