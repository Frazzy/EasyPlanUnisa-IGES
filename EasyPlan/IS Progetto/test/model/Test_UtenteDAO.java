package model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import model.utente.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

public class Test_UtenteDAO {

  
  UtenteBeanDao amd = new UtenteBeanDao();
  

  @Test
  public void testdoRetriveByKey() {
	  String username = "admin";
	  UtenteBean ab = new UtenteBean("admin", "admin");
	  assertEquals(ab.toString(), amd.doRetrieveByKey(username).toString());
  }
  
  @Test
  public void testdoSignUp() throws IOException {
	  UtenteBean ab = new UtenteBean("testtest", "admin");
	  assertEquals(true, amd.doSignUp(ab));
	  amd.doDelete("testtest");
  }
  @Test
  public void testdoDelete() throws IOException {
	  UtenteBean ab = new UtenteBean("testtest", "admin");
	  amd.doSignUp(ab);
	  assertEquals(true, amd.doDelete("testtest"));
  }
}