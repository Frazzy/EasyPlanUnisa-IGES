package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.FileReader;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import model.offerta.formativa.OffertaFormativaBean;
import model.esame.EsameBean;
import model.gruppo.esami.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBean;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoadPlanServlet
 */
@WebServlet("/LoadPlanServlet")
public class LoadPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Gson gson = new Gson();
		HttpSession session = request.getSession(true);
		
		String nomeFile=request.getParameter("jsonFile");
		try (FileReader fileReader = new FileReader(nomeFile)) {
		    @SuppressWarnings("deprecation")
			JsonParser jsonParser = new JsonParser();
		    @SuppressWarnings("deprecation")
			JsonElement jsonElement = jsonParser.parse(fileReader);
		    JsonObject json = jsonElement.getAsJsonObject();
		
		
		// Recupera i dati dal JSON
		String offertaFormativaJson = json.get("offertaFormativa").getAsString();
		String obbligatori1Json = json.get("obbligatori1").getAsString();
		String obbligatori2Json = json.get("obbligatori2").getAsString();
		String obbligatori3Json = json.get("obbligatori3").getAsString();
		String opzionali1Json = json.get("opzionali1").getAsString();
		String opzionali2Json = json.get("opzionali2").getAsString();
		String opzionali3Json = json.get("opzionali3").getAsString();
		String o1Json = json.get("o1").getAsString();
		String o2Json = json.get("o2").getAsString();
		String o3Json = json.get("o3").getAsString();
		String liberaJson = json.get("libera").getAsString();
		int totalecfuSelLib = json.get("totalecfuSelLib").getAsInt();
		

		// Assegna i valori alle variabili di sessione
		session.setAttribute("offertaFormativa", gson.fromJson(offertaFormativaJson, OffertaFormativaBean.class));
		session.setAttribute("obbligatori1", gson.fromJson(obbligatori1Json, new TypeToken<ArrayList<GruppoEsamiObbligatoriBean>>() {}.getType()));
		session.setAttribute("obbligatori2", gson.fromJson(obbligatori2Json, new TypeToken<ArrayList<GruppoEsamiObbligatoriBean>>() {}.getType()));
		session.setAttribute("obbligatori3", gson.fromJson(obbligatori3Json, new TypeToken<ArrayList<GruppoEsamiObbligatoriBean>>() {}.getType()));
		session.setAttribute("opzionali1", gson.fromJson(opzionali1Json, new TypeToken<ArrayList<GruppoEsamiOpzionaliBean>>() {}.getType()));
		session.setAttribute("opzionali2", gson.fromJson(opzionali2Json, new TypeToken<ArrayList<GruppoEsamiOpzionaliBean>>() {}.getType()));
		session.setAttribute("opzionali3", gson.fromJson(opzionali3Json, new TypeToken<ArrayList<GruppoEsamiOpzionaliBean>>() {}.getType()));
		session.setAttribute("o1", gson.fromJson(o1Json, new TypeToken<ArrayList<GruppoEsamiOpzionaliBean>>() {}.getType()));
		session.setAttribute("o2", gson.fromJson(o2Json, new TypeToken<ArrayList<GruppoEsamiOpzionaliBean>>() {}.getType()));
		session.setAttribute("o3", gson.fromJson(o3Json, new TypeToken<ArrayList<GruppoEsamiOpzionaliBean>>() {}.getType()));
		session.setAttribute("libera", gson.fromJson(liberaJson, new TypeToken<ArrayList<EsameBean>>() {}.getType()));
		session.setAttribute("totalecfuSelLib", totalecfuSelLib);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
    	rd.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
