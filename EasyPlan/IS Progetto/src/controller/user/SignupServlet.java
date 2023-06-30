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
import javax.swing.JOptionPane;

import model.utente.UtenteBean;
import model.utente.UtenteBeanDao;
/**
 * Servlet implementation class SubscribeServlet
 */



@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	
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
	  
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("pwd");
    if (missingData(username) && validateField(username, "[0-9a-zA-Z\\S]+")) {
    if (missingData(password) && validateField(password, "([A-Za-z0-9]){3,16}")) {
    		
    UtenteBean utente = new UtenteBean();
    utente.setUsername(username);
    utente.setPassword(password);

    UtenteBeanDao utenteDao = new UtenteBeanDao();
    if(utenteDao.doRetrieveByKey(username) == null) {
    boolean isRegistered = utenteDao.doSignUp(utente);

    if (isRegistered) {
      HttpSession session = request.getSession();
      session.setAttribute("utente", username);

      response.sendRedirect("Homepage.jsp");
    }
    }else {
      // Aggiungi il messaggio di errore come parametro nell'URL
      String errorMessage = "Username già in uso, scegliere un altro username";
      String redirectURL = "Subscribe.jsp?error=" + URLEncoder.encode(errorMessage, "UTF-8");
      response.sendRedirect(redirectURL);
    }
    }else{
        RequestDispatcher view = request.getRequestDispatcher("Signup.jsp");
         view.forward(request, response);
    }
    }else {
        RequestDispatcher view = request.getRequestDispatcher("Signup.jsp");
        view.forward(request, response);
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

