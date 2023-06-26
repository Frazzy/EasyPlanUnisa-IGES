package model.amministratore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;

public class AmministratoreBeanDao {

  /**
   * Metodo che ritorna un amministratore data la chiave.
   * @param username username dell'amministratore
   * @return
   */
  public synchronized AmministratoreBean doRetrieveByKey(String username) {
    Connection conn = null;
    PreparedStatement ps = null;

    try {
      AmministratoreBean ab = new AmministratoreBean();
      ab.setUsername(username);

      conn = DriverManagerConnectionPool.getConnection();

      ps = conn.prepareStatement("SELECT * FROM amministratore WHERE Username=?");
      ps.setString(1, username);

      ResultSet res = ps.executeQuery();

      if (res.next()) {
        ab.setPassword(res.getString("Password"));

        return ab;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
    	// Chiusura delle risorse
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return null;
  }

}
