package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.offerta.formativa.OffertaFormativaBean;
import model.offerta.formativa.OffertaFormativaBeanDao;

public class Test_OffertaFormativaDAO {
	 private static OffertaFormativaBeanDao offertaDao;

	    @BeforeClass
	    public static void setUp() {
	        offertaDao = new OffertaFormativaBeanDao();
	    }

	    @AfterClass
	    public static void tearDown() {
	        offertaDao = null;
	    }

	    @Test
	    public void testDoSave() {
	        OffertaFormativaBean offerta = new OffertaFormativaBean();
	        offerta.setAnnoOffertaFormativa("2023");
	        offerta.setVisibilita(false);

	        try {
	            int result = offertaDao.doSave(offerta);
	            assertEquals(1, result);
	            offertaDao.doDelete("2023");
	        } catch (IOException e) {
	            e.printStackTrace();
	            fail("IOException occurred");
	        }
	    }

	    @Test
	    public void testDoSaveOrUpdate() {
	        OffertaFormativaBean offerta = new OffertaFormativaBean();
	        offerta.setAnnoOffertaFormativa("2024");
	        offerta.setVisibilita(true);

	        try {
	            boolean result = offertaDao.doSaveOrUpdate(offerta);
	            assertTrue(result);
	            offertaDao.doDelete("2024");
	        } catch (IOException e) {
	            e.printStackTrace();
	            fail("IOException occurred");
	        }
	    }

	    @Test
	    public void testDoRetrieveByKey() {
	        String offertaFormativa = "2018/19";

	        OffertaFormativaBean offerta = offertaDao.doRetrieveByKey(offertaFormativa);
	        assertNotNull(offerta);
	        assertEquals(offertaFormativa, offerta.getAnnoOffertaFormativa());
	    }

	    @Test
	    public void testDoDelete() {
	    	OffertaFormativaBean offerta = new OffertaFormativaBean();
	        offerta.setAnnoOffertaFormativa("2023");
	        offerta.setVisibilita(false);
	  
	        try {
	        	offertaDao.doSave(offerta);
	            boolean result = offertaDao.doDelete("2023");
	            assertTrue(result);
	        } catch (IOException e) {
	            e.printStackTrace();
	            fail("IOException occurred");
	        }
	    }

	    @Test
	    public void testDoRetrieveByAll() {
	        try {
	            ArrayList<OffertaFormativaBean> lista = offertaDao.doRetriveByAll();
	            assertNotNull(lista);
	            assertFalse(lista.isEmpty());
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            fail("Exception occurred");
	        }
	    }

}
