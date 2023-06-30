package model.utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;

public class UtenteBeanDao {

  /**
   * Metodo che ritorna un utente data la chiave.
   * @param username username dell'utente
   * @return
   */
  public synchronized UtenteBean doRetrieveByKey(String username) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      UtenteBean ab = new UtenteBean();
      ab.setUsername(username);

      conn = DriverManagerConnectionPool.getConnection();

      ps = conn.prepareStatement("SELECT * FROM utente WHERE Username=?");
      ps.setString(1, username);

      ResultSet res = ps.executeQuery();

      if (res.next()) {
        ab.setPassword(res.getString("Password"));

        return ab;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        ps.close();
        DriverManagerConnectionPool.releaseConnection(conn);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return null;
  }
  
  
  public synchronized boolean doSignUp(UtenteBean utente) {
	  Connection conn = null;
	  PreparedStatement ps = null;

	  try {
	    conn = DriverManagerConnectionPool.getConnection();

	    ps = conn.prepareStatement("INSERT INTO utente (Username, Password) VALUES (?, ?)");
	    ps.setString(1, utente.getUsername());
	    ps.setString(2, utente.getPassword());

	    int result = ps.executeUpdate();

	    return result > 0;
	  } catch (SQLException e) {
	    e.printStackTrace();
	  } finally {
	    try {
	      ps.close();
	      DriverManagerConnectionPool.releaseConnection(conn);
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	  return false;
	}

}
