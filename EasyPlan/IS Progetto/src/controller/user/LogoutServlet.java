package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout.
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Costruttore vuoto.
   * @see HttpServlet#HttpServlet()
   */
  public LogoutServlet() {
    super();
  }

  /**
   * Metodo doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    HttpSession session = request.getSession(false); // Otteniamo la sessione esistente senza crearne una nuova
    session.invalidate();
    // Redirect alla homepage di default
    response.sendRedirect("Homepage.jsp");
  }

  /**
   * Metodo doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Chiamata al metodo doGet per gestire il logout
    doGet(request, response);
  }

}

