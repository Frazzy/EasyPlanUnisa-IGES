package controller.user;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.utente.UtenteBean;
import model.utente.UtenteBeanDao;

/**
 * Servlet implementation class LoginServlet.
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * costruttore vuoto.
   * @see HttpServlet#HttpServlet()
   */
  public LoginServlet() {
    super();
  }

  // Controlla se la stringa passata come parametro e' nulla oppure vuota
  private boolean missingData(String x) {
    if (x == null || x.equals("")) {
      return false;
    } else {
      return true;
    }
  }

  // controlla se un campo rispetta un certo pattern
  private boolean validateField(String x, String pattern) {
    // se la stringa x rispetta il pattern e non e' nulla ritorna true
    if (Pattern.matches(pattern, x) && missingData(x)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * metodo doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String user = request.getParameter("username");
    String password = request.getParameter("pwd");

    HttpSession session = request.getSession(true);
    synchronized (session) {
      if (missingData(user) && validateField(user, "[0-9a-zA-Z\\S]+")) {
        if (missingData(password) && validateField(password, "([A-Za-z0-9]){3,16}")) {
          UtenteBeanDao amDao = new UtenteBeanDao();
          UtenteBean am = amDao.doRetrieveByKey(user);

          if (am != null && am.getPassword().equals(password) && am.getUsername().equals("admin")) {
            session.setAttribute("amministratore", user);
            session.setAttribute("password", password);

            RequestDispatcher view = request.getRequestDispatcher("GestioneOfferteFormative.jsp");
            view.forward(request, response);
            

          } 
        //Login per l'utente
         else if(am != null && am.getPassword().equals(password)) {
        	  session.setAttribute("utente", user);
              session.setAttribute("password", password);
              
              RequestDispatcher view = request.getRequestDispatcher("Homepage.jsp");
              view.forward(request, response);
          }
        	  
        	  
          else
          {
        	// Aggiungi il messaggio di errore come parametro nell'URL
              String errorMessage = "Username o password errati";
              String redirectURL = "Login.jsp?error=" + URLEncoder.encode(errorMessage, "UTF-8");
              response.sendRedirect(redirectURL);
            
          }
        } else {
          RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
          view.forward(request, response);
        }
      } else {
        RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
        view.forward(request, response);
      }
    }
  }

  /**
   * Metodo doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}