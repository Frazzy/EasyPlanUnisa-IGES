package controller;

import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;

import model.esame.EsameBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBean;

public class GruppoEsamiOpzionaliMock extends GruppoEsamiOpzionaliBean {
	ArrayList<EsameBean> esami= new ArrayList<>();
	@Mock
	EsameBean esame=Mockito.mock(EsameBean.class);
	public GruppoEsamiOpzionaliMock() {
		    esami.add(esame);
		  }
	@Override
	  public ArrayList<EsameBean> getEsami() {
	    return this.esami;
	  }

}
