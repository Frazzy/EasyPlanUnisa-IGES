package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.curriculum.CurriculumBean;
import model.curriculum.CurriculumBeanDao;

public class Test_CurriculumDAO {
    private CurriculumBeanDao curriculumDao;

    @BeforeEach
    public void setup() {
        curriculumDao = new CurriculumBeanDao();
    }

    @Test
    public void testDoSave() throws IOException {
        CurriculumBean cb = new CurriculumBean();
        cb.setIdCurriculum(100);
        cb.setNomeCurriculum("Curriculum Test");
        cb.setIdCorsoDiLaurea(1);

        int result = curriculumDao.doSave(cb);
        Assertions.assertEquals(1, result);
        curriculumDao.doDelete(100);
    }

    @Test
    public void testDoSaveOrUpdate() throws IOException {
        CurriculumBean cb = new CurriculumBean();
        cb.setIdCurriculum(100);
        cb.setNomeCurriculum("Curriculum Test");
        cb.setIdCorsoDiLaurea(1);

        boolean result = curriculumDao.doSaveOrUpdate(cb);
        Assertions.assertTrue(result);
        curriculumDao.doDelete(100);
    }

    @Test
    public void testDoRetrieveByKey() {
        int idCurriculum = 1;
        CurriculumBean cb = curriculumDao.doRetrieveByKey(idCurriculum);
        Assertions.assertNotNull(cb);
        Assertions.assertEquals(idCurriculum, cb.getIdCurriculum());
    }

    @Test
    public void testDoDelete() throws IOException {
    	CurriculumBean cb = new CurriculumBean();
        cb.setIdCurriculum(101);
        cb.setNomeCurriculum("Curriculum Test");
        cb.setIdCorsoDiLaurea(1);

        curriculumDao.doSave(cb);
        boolean result = curriculumDao.doDelete(101);
        Assertions.assertTrue(result);
    }

    @Test
    public void testDoRetrieveByAll() throws ClassNotFoundException, SQLException {
        ArrayList<CurriculumBean> lista = curriculumDao.doRetriveByAll();
        Assertions.assertNotNull(lista);
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void testDoRetrieveByCorsoDiLaureaOffertaFormativa() throws ClassNotFoundException, SQLException {
        int laurea = 2;
        String anno = "2018/19";
        ArrayList<CurriculumBean> lista = curriculumDao.doRetriveByCorsoDiLaureaOffertaFormativa(laurea, anno);
        Assertions.assertNotNull(lista);
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void testDoRetrieveByIdMaggiore() {
        int idMaggiore = curriculumDao.doRetrieveByIdMaggiore();
        Assertions.assertTrue(idMaggiore > 0);
    }
}





