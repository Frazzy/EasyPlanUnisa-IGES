package model;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.docente.DocenteBean;
import model.docente.DocenteBeanDao;

public class Test_DocenteDAO {
    private DocenteBeanDao docenteDao;

	
    @BeforeEach
    public void setup() {
        docenteDao = new DocenteBeanDao();
    }

    @Test
    public void testDoSave() throws IOException {
    	DocenteBean docente = new DocenteBean();
        docente.setCodiceDocente(100);
        docente.setNome("John");
        docente.setCognome("Doe");
        docente.setIndirizzoPaginaWeb("www.example.com");
        docente.setInsegnamento("xa");

        int codiceEsame = 91;
        int result = docenteDao.doSave(docente,codiceEsame);
        Assertions.assertEquals(1, result);
        docenteDao.doDelete(100);
    }

    @Test
    public void testDoSaveOrUpdate() throws IOException {
    	DocenteBean docente = new DocenteBean();
        docente.setCodiceDocente(101);
        docente.setNome("John");
        docente.setCognome("Doe");
        docente.setIndirizzoPaginaWeb("www.example.com");
        docente.setInsegnamento("xb");

        int codiceEsame = 91;

        boolean result = docenteDao.doSaveOrUpdate(docente,codiceEsame);
        Assertions.assertTrue(result);
        docenteDao.doDelete(101);
    }

    @Test
    public void testDoRetrieveByKey() {
        int codiceDocente = 1;
        DocenteBean cb = docenteDao.doRetrieveByKey(codiceDocente);
        Assertions.assertNotNull(cb);
        Assertions.assertEquals(codiceDocente, cb.getCodiceDocente());
    }

    @Test
    public void testDoDelete() throws IOException {
    	DocenteBean docente = new DocenteBean();
        docente.setCodiceDocente(102);
        docente.setNome("John");
        docente.setCognome("Doe");
        docente.setIndirizzoPaginaWeb("www.example.com");
        docente.setInsegnamento("x");

        int codiceEsame = 91;

        docenteDao.doSave(docente,codiceEsame);
        boolean result = docenteDao.doDelete(102);
        Assertions.assertTrue(result);
    }

    @Test
    public void testDoRetrieveDocEsameObb() {
        String anno = "2018/19";
        int laurea = 2;
        String curricula = "Sicurezza Informatica";
        int grOb = 10;
        String nome = "Sicurezza dei Dati";

        ArrayList<DocenteBean> docenti = docenteDao.doRetrieveDocEsameObb(anno, laurea, curricula, grOb, nome);
        assertNotNull(docenti);
    }

    @Test
    public void testDoRetrieveDocEsameOpz() {
    	String anno = "2018/19";
        int laurea = 2;
        String curricula = "Sicurezza Informatica";
        int grOpz = 9;
        String nome = "Reti sociali";
        
        ArrayList<DocenteBean> docenti = docenteDao.doRetrieveDocEsameOpz(anno, laurea, curricula, grOpz, nome);
        assertNotNull(docenti);
            }
    
    @Test
    public void testDoRetrieveLastId() {
       int lastId = docenteDao.doRetrieveLastId();
       assertNotNull(lastId);
        
    }
}
