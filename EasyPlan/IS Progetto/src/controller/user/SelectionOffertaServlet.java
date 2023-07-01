package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.google.gson.JsonObject;

import model.esame.EsameBean;
import model.esame.EsameBeanDao;
import model.gruppo.esami.GruppoEsamiObbligatoriBean;
import model.gruppo.esami.GruppoEsamiOpzionaliBean;
import model.offerta.formativa.OffertaFormativaBean;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Servlet implementation class selectionOfferta.
 */
@WebServlet("/selectionOfferta")
public class SelectionOffertaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Metodo costruttore.
   * @see HttpServlet#HttpServlet()
   */
  public SelectionOffertaServlet() {
    super();
  }

  /**
   * Metodo doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @SuppressWarnings("unchecked")
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    if (request.getParameter("metodo").equals("fine")) {
      HttpSession session = request.getSession(true);
      synchronized (session) {
        OffertaFormativaBean of = (OffertaFormativaBean) session.getAttribute("offertaFormativa");
        int totaleCFUselezionatisceltalibera=0;
        ArrayList<GruppoEsamiObbligatoriBean> ob1 = (ArrayList<GruppoEsamiObbligatoriBean>) session
            .getAttribute("obbligatori1");
        ArrayList<GruppoEsamiObbligatoriBean> ob2 = (ArrayList<GruppoEsamiObbligatoriBean>) session
            .getAttribute("obbligatori2");
        ArrayList<GruppoEsamiObbligatoriBean> ob3 = (ArrayList<GruppoEsamiObbligatoriBean>) session
            .getAttribute("obbligatori3");

        ArrayList<GruppoEsamiOpzionaliBean> op1 = 
            (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o1");
        ArrayList<GruppoEsamiOpzionaliBean> op2 = 
            (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o2");
        ArrayList<GruppoEsamiOpzionaliBean> op3 = 
            (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o3");
        
        ArrayList<EsameBean> sceltalibera = (ArrayList<EsameBean>) session.getAttribute("libera");
          if(session.getAttribute("totalecfuSelLib")!=null) {
              totaleCFUselezionatisceltalibera = (int) session.getAttribute("totalecfuSelLib");
          }

        boolean check1 = false;
        boolean check2 = false;

        if (op1 == null || op2 == null || op3 == null || sceltalibera== null ) { //Modificato l'OR per la CR2
          RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
          request.setAttribute("offertaFormativa", of);
          session.setAttribute("errore", "CFU minimi dei gruppi opzionali  non rispettati");
          rd.forward(request, response);
          return;
        }

        if (op1.size() == 0 && op2.size() == 0) {
          check2 = true;
        }

        if (op1.size() == 0 && op3.size() == 0) {
          check1 = true;
        }
        if (op1.size() == 0) {
          check1 = true;
        }

        boolean pass = false;

        // controllo gruppi opzionali anno 1
        for (int i = 0; i < op1.size(); i++) {
          int cfu = op1.get(i).getTotCfu();

          int compCfu = 0;
          if (op1.get(i).getEsami() != null) {
            for (int j = 0; j < op1.get(i).getEsami().size(); j++) {
              compCfu += op1.get(i).getEsami().get(j).getCfu();
            }
            if (cfu > compCfu) {
              pass = false;
              session.setAttribute("errore",
                  "CFU minimi del gruppo opzionale del 1° anno da " + cfu + " cfu non rispettati");
            } else if (cfu <= compCfu) {
              pass = true;
            }
          }
          if (pass == true) {
            check1 = true;
            pass = false;
          } else {
            request.setAttribute("offertaFormativa", of);
            session.setAttribute("errore",
                "CFU minimi del gruppo opzionale del 1° anno da " + cfu + " cfu non rispettati");

            session.removeAttribute("o1");
            session.setAttribute("o1", op1);
            session.removeAttribute("o2");
            session.setAttribute("o2", op2);
            session.removeAttribute("o3");
            session.setAttribute("o3", op3);
            session.removeAttribute("libera");
            session.setAttribute("libera", sceltalibera);
            session.removeAttribute("totalecfuSelLib");
            session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);

            RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
            rd.forward(request, response);
          }
        }

        if (check1 == true) {
          // controllo gruppi opzionali anno 2
          for (int i = 0; i < op2.size(); i++) {
            int cfu = op2.get(i).getTotCfu();

            int compCfu = 0;
            if (op2.get(i).getEsami() != null) {
              for (int j = 0; j < op2.get(i).getEsami().size(); j++) {
                compCfu += op2.get(i).getEsami().get(j).getCfu();
              }
              if (cfu > compCfu) {
                pass = false;
                session.setAttribute("errore",
                    "CFU minimi del gruppo opzionale del 2° anno da "
                        + cfu + " cfu non rispettati");
              } else if (cfu <= compCfu) {
                pass = true;
              }
            }
            if (pass == true) {
              check2 = true;
              pass = false;

            } else {
              request.setAttribute("offertaFormativa", of);
              session.setAttribute("errore",
                  "CFU minimi del gruppo opzionale del 2° anno da " + cfu + " cfu non rispettati");

              session.removeAttribute("o1");
              session.setAttribute("o1", op1);
              session.removeAttribute("o2");
              session.setAttribute("o2", op2);
              session.removeAttribute("o3");
              session.setAttribute("o3", op3);
              session.removeAttribute("libera");
              session.setAttribute("libera", sceltalibera);
              session.removeAttribute("totalecfuSelLib");
              session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);
              
              RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
              rd.forward(request, response);
              return;
            }
          }
        }

        if (check2 == true) {
          // controllo gruppi opzionali anno 3
          for (int i = 0; i < op3.size(); i++) {
            int cfu = op3.get(i).getTotCfu();

            int compCfu = 0;
            if (op3.get(i).getEsami() != null) {
              for (int j = 0; j < op3.get(i).getEsami().size(); j++) {
                compCfu += op3.get(i).getEsami().get(j).getCfu();
              }
              if (cfu > compCfu) {
                pass = false;
                session.setAttribute("errore",
                    "CFU minimi del gruppo opzionale del 3° anno da " 
                        + cfu + " cfu non rispettati");
              } else if (cfu <= compCfu) {
                pass = true;
              }
            }
            if (pass == true) {
              pass = true;
            } else {
              request.setAttribute("offertaFormativa", of);
              session.setAttribute("errore",
                  "CFU minimi del gruppo opzionale del 3° anno da " + cfu + " cfu non rispettati");

              session.removeAttribute("o1");
              session.setAttribute("o1", op1);
              session.removeAttribute("o2");
              session.setAttribute("o2", op2);
              session.removeAttribute("o3");
              session.setAttribute("o3", op3);
              session.removeAttribute("libera");
              session.setAttribute("libera", sceltalibera);
              session.removeAttribute("totalecfuSelLib");
              session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);

              RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
              rd.forward(request, response);
              return;
            }
          }
        }
        
        
        
        if (check2 == true) {
            // controllo scelta libera
            
              int cfu = totaleCFUselezionatisceltalibera;

                if (12 > totaleCFUselezionatisceltalibera) {
                  pass = false;
                  session.setAttribute("errore",
                      "CFU minimi della scelta libera da " 
                          + 12 + " cfu non rispettati");
                } else if (12 <= totaleCFUselezionatisceltalibera) {
                  pass = true;
                }
              
              if (pass == true) {
                pass = false;
              } else {
                request.setAttribute("offertaFormativa", of);
                session.setAttribute("errore",
                		"CFU minimi della scelta libera da " 
                                + 12 + " cfu non rispettati");

                session.removeAttribute("o1");
                session.setAttribute("o1", op1);
                session.removeAttribute("o2");
                session.setAttribute("o2", op2);
                session.removeAttribute("o3");
                session.setAttribute("o3", op3);
                session.removeAttribute("libera");
                session.setAttribute("libera", sceltalibera);
                session.removeAttribute("totalecfuSelLib");
                session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);
                

                RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
                rd.forward(request, response);
                return;
              }
            }
          
        // if con tutte lo combinazioni possibili di correttezza
        if (pass == true && check1 == true && check2 == true) {
          session.removeAttribute("o1");
          session.setAttribute("o1", op1);
          session.removeAttribute("o2");
          session.setAttribute("o2", op2);
          session.removeAttribute("3");
          session.setAttribute("o3", op3);

          session.removeAttribute("obbligatori1");
          session.setAttribute("obbligatori1", ob1);
          session.removeAttribute("obbligatori2");
          session.setAttribute("obbligatori2", ob2);
          session.removeAttribute("obbligatori3");
          session.setAttribute("obbligatori3", ob3);
          session.removeAttribute("libera");
          session.setAttribute("libera", sceltalibera);
          session.removeAttribute("totalecfuSelLib");
          session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);

          RequestDispatcher rd = request.getRequestDispatcher("PianoDiStudi.jsp");
          rd.forward(request, response);
        } else if (check1 == true && pass == true || check1 == true && pass == false) {
          session.removeAttribute("o1");
          session.setAttribute("o1", op1);
          session.removeAttribute("o2");
          session.setAttribute("o2", op2);
          session.removeAttribute("3");
          session.setAttribute("o3", op3);

          session.removeAttribute("obbligatori1");
          session.setAttribute("obbligatori1", ob1);
          session.removeAttribute("obbligatori2");
          session.setAttribute("obbligatori2", ob2);
          session.removeAttribute("obbligatori3");
          session.setAttribute("obbligatori3", ob3);
          
          session.removeAttribute("libera");
          session.setAttribute("libera", sceltalibera);
          session.removeAttribute("totalecfuSelLib");
          session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);

          RequestDispatcher rd = request.getRequestDispatcher("PianoDiStudi.jsp");
          rd.forward(request, response);
          
        } else if (check1 == true && check2 == true && pass == false) {
          session.removeAttribute("o1");
          session.setAttribute("o1", op1);
          session.removeAttribute("o2");
          session.setAttribute("o2", op2);
          session.removeAttribute("3");
          session.setAttribute("o3", op3);

          session.removeAttribute("obbligatori1");
          session.setAttribute("obbligatori1", ob1);
          session.removeAttribute("obbligatori2");
          session.setAttribute("obbligatori2", ob2);
          session.removeAttribute("obbligatori3");
          session.setAttribute("obbligatori3", ob3);
          session.removeAttribute("libera");
          session.setAttribute("libera", sceltalibera);
          session.removeAttribute("totalecfuSelLib");
          session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);

          RequestDispatcher rd = request.getRequestDispatcher("PianoDiStudi.jsp");
          rd.forward(request, response);
        }
      }
    } 
    
    
    else if (request.getParameter("metodo").equals("salva")) {
    	//If per salvare l'attuale sessione e continuare in un secondo momento
    	
    	
    	HttpSession session = request.getSession(true);
        OffertaFormativaBean of = (OffertaFormativaBean) session.getAttribute("offertaFormativa");

        ArrayList<GruppoEsamiObbligatoriBean> ob1 = (ArrayList<GruppoEsamiObbligatoriBean>) session
            .getAttribute("obbligatori1");
        ArrayList<GruppoEsamiObbligatoriBean> ob2 = (ArrayList<GruppoEsamiObbligatoriBean>) session
            .getAttribute("obbligatori2");
        ArrayList<GruppoEsamiObbligatoriBean> ob3 = (ArrayList<GruppoEsamiObbligatoriBean>) session
            .getAttribute("obbligatori3");


		  ArrayList<GruppoEsamiOpzionaliBean> op1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali1");
	        ArrayList<GruppoEsamiOpzionaliBean> op2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali2");
	        ArrayList<GruppoEsamiOpzionaliBean> op3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali3");
        
        
        ArrayList<GruppoEsamiOpzionaliBean> opz1 = 
            (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o1");
        ArrayList<GruppoEsamiOpzionaliBean> opz2 = 
            (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o2");
        ArrayList<GruppoEsamiOpzionaliBean> opz3 = 
            (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o3");
        
        ArrayList<EsameBean> sceltalibera = (ArrayList<EsameBean>) session.getAttribute("libera");
        int totaleCFUselezionatisceltalibera = (int) session.getAttribute("totalecfuSelLib");
        String utente= (String) session.getAttribute("utente");
    	
    	Gson gson = new Gson();

    	
    	
    	// Crea un oggetto JSON
    	JsonObject json = new JsonObject();

    	// Aggiungi i dati all'oggetto JSON per la serializzazione
    	json.addProperty("offertaFormativa", gson.toJson(of));
    	json.addProperty("obbligatori1", gson.toJson(ob1));
    	json.addProperty("obbligatori2", gson.toJson(ob2));
    	json.addProperty("obbligatori3", gson.toJson(ob3));
    	json.addProperty("opzionali1", gson.toJson(op1));
    	json.addProperty("opzionali2", gson.toJson(op2));
    	json.addProperty("opzionali3", gson.toJson(op3));
    	json.addProperty("o1", gson.toJson(opz1));
    	json.addProperty("o2", gson.toJson(opz2));
    	json.addProperty("o3", gson.toJson(opz3));
    	json.addProperty("libera", gson.toJson(sceltalibera));
    	json.addProperty("totalecfuSelLib", totaleCFUselezionatisceltalibera);
    	
    	
    	
    
    	//la path andrebbe corretta per funzionare ovunque
    	
		
    	
    	String projectPath = request.getServletContext().getRealPath("/");
    	String jsonsFolderPath = projectPath + "jsons/";
   
         
         String nomeFile = jsonsFolderPath + request.getParameter("risultato") + ".json";
    	
		try (FileWriter fileWriter = new FileWriter(nomeFile)) {
		    fileWriter.write(json.toString());
		    fileWriter.flush();
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		
    	
    	
    	RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
    	rd.forward(request, response);
    	
    }
    
    
    
    
    //Sezione di if per gli esami liberi
    else if  ( (!request.getParameter("esame").isEmpty()) && (request.getParameter("gruppolib")!=null) ) {
    	
    	
    	
    	
    	OffertaFormativaBean of = null;
        int totaleCFUselezionatisceltalibera = 0;
    	int esame = Integer.parseInt(request.getParameter("esame"));
    	String lib = request.getParameter("gruppolib");
    	  EsameBeanDao esB = new EsameBeanDao();
    	  
    	  HttpSession session = request.getSession(true);
		EsameBean cercato = esB.doRetrieveByKey(esame);
		if(session.getAttribute("totalecfuSelLib")!= null) {
			totaleCFUselezionatisceltalibera=(int) session.getAttribute("totalecfuSelLib");
			
		}
		ArrayList<EsameBean> sceltalibera = new ArrayList<EsameBean>();  
		sceltalibera= (ArrayList<EsameBean>) session.getAttribute("libera");
		String utente=null;
		
		
		 
		  synchronized (session) {
		 // aggiunta esami nel gruppo libero
			  of = (OffertaFormativaBean) session.getAttribute("offertaFormativa");
			  utente=(String) session.getAttribute("utente");
			  
			  ArrayList<GruppoEsamiOpzionaliBean> op1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali1");
		        ArrayList<GruppoEsamiOpzionaliBean> op2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali2");
		        ArrayList<GruppoEsamiOpzionaliBean> op3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali3");
		        
		        ArrayList<GruppoEsamiOpzionaliBean> opz1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o1");
		        ArrayList<GruppoEsamiOpzionaliBean> opz2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o2");
		        ArrayList<GruppoEsamiOpzionaliBean> opz3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o3");
			  
	        for (int i = 0; i < sceltalibera.size(); i++) {
	              if (sceltalibera.get(i).getCodiceEsame() == cercato.getCodiceEsame() &&  !sceltalibera.get(i).isCheck()) {
	            	  sceltalibera.get(i).setCheck(true);
	            	  totaleCFUselezionatisceltalibera+=sceltalibera.get(i).getCfu();
	            	  System.out.println("Elemento messo nella  scelta, totale CFU scelti:"+totaleCFUselezionatisceltalibera);
	              }
	         else if (sceltalibera.get(i).getCodiceEsame() == cercato.getCodiceEsame() &&  sceltalibera.get(i).isCheck()){
	            	  sceltalibera.get(i).setCheck(false);
	            	  totaleCFUselezionatisceltalibera-=sceltalibera.get(i).getCfu();
	            	  System.out.println("Elemento rimosso dalla scelta, totale CFU scelti:"+totaleCFUselezionatisceltalibera);
	            }
	          
	              }
	        
	        // rimozione opzionali 1
	        if(opz1!=null) {
	        for (int i = 0; i < opz1.size(); i++) {
	            opz1.get(i).getEsami().remove(cercato);
	            for (int z = 0; z < op1.get(i).getEsami().size(); z++) {
	              if (op1.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
	                op1.get(i).getEsami().get(z).setCheck(false);
	              }
	            }
	          }
	        }
	        //  opzionali 2 e eventuale rimozione
	        if(opz2!=null) {
	        for (int i = 0; i < opz2.size(); i++) {
	            opz2.get(i).getEsami().remove(cercato);
	            for (int z = 0; z < op2.get(i).getEsami().size(); z++) {
	              if (op2.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
	                op2.get(i).getEsami().get(z).setCheck(false);
	              }
	            }
	          }
	        }
	        // rimozione esami nei gruppi opzionali 3
	        if(opz3!=null) {
	        for (int i = 0; i < opz3.size(); i++) {
	        	opz3.get(i).getEsami().remove(cercato);
	            for (int z = 0; z < op3.get(i).getEsami().size(); z++) {
	              if (op3.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
	                op3.get(i).getEsami().get(z).setCheck(false);
	              }
	            }
	          }
	        }
	        
	        
	        
	        
	        
		        session.removeAttribute("opzionali1");
		        session.setAttribute("opzionali1", op1);
		        session.removeAttribute("opzionali2");
		        session.setAttribute("opzionali2", op2);
		        session.removeAttribute("opzionali3");
		        session.setAttribute("opzionali3", op3);
	
		        session.removeAttribute("o1");
		        session.removeAttribute("o2");
		        session.removeAttribute("o3");
		        session.setAttribute("o1", opz1);
		        session.setAttribute("o2", opz2);
		        session.setAttribute("o3", opz3);
		        session.removeAttribute("libera");
		        session.removeAttribute("totalecfuSelLib");
		        session.setAttribute("libera",sceltalibera);
		        session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);  
		        
		        
		        session.removeAttribute("utente");
		        session.setAttribute("utente", utente);
	            }
	          
	      
    	
		  request.removeAttribute("offertaFormativa");
          request.setAttribute("offertaFormativa", of);

    	

          RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
          rd.forward(request, response);
    	
    	
    	
    	
    	
    }
    
    
    
    else {
      
      String gruppo = request.getParameter("gruppoopz");
      int esame = Integer.parseInt(request.getParameter("esame"));
      int totaleCFUselezionatisceltalibera=0;
      

      EsameBeanDao esB = new EsameBeanDao();
     
      EsameBean cercato;
	
      cercato = esB.doRetrieveByKey(esame);

      ArrayList<GruppoEsamiOpzionaliBean> opz1 = new ArrayList<GruppoEsamiOpzionaliBean>();
      ArrayList<GruppoEsamiOpzionaliBean> opz2 = new ArrayList<GruppoEsamiOpzionaliBean>();
      ArrayList<GruppoEsamiOpzionaliBean> opz3 = new ArrayList<GruppoEsamiOpzionaliBean>();
      
      ArrayList<EsameBean> sceltalibera= new ArrayList<EsameBean>();

      HttpSession session = request.getSession(true);
      OffertaFormativaBean of = null;
      ArrayList<GruppoEsamiOpzionaliBean> op1 = null;
      ArrayList<GruppoEsamiOpzionaliBean> op2 = null;
      ArrayList<GruppoEsamiOpzionaliBean> op3 = null;
      ArrayList<GruppoEsamiObbligatoriBean> ob1 = null;
      ArrayList<GruppoEsamiObbligatoriBean> ob2 = null;
      ArrayList<GruppoEsamiObbligatoriBean> ob3 = null;
      String utente=null;
      
      synchronized (session) {
    	  utente=(String) session.getAttribute("utente");
        of = (OffertaFormativaBean) session.getAttribute("offertaFormativa");
        ob1 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori1");
        ob2 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori2");
        ob3 = (ArrayList<GruppoEsamiObbligatoriBean>) session.getAttribute("obbligatori3");

        op1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali1");
        op2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali2");
        op3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("opzionali3");

        sceltalibera= (ArrayList<EsameBean>) session.getAttribute("libera");
        if(session.getAttribute("totalecfuSelLib")!= null) {
			totaleCFUselezionatisceltalibera=(int) session.getAttribute("totalecfuSelLib");
			
		}
        
        
        if (session.getAttribute("o1") == null) {
          for (int i = 0; i < op1.size(); i++) {
            opz1.add(new GruppoEsamiOpzionaliBean());
            opz1.get(i).setTotCfu(op1.get(i).getTotCfu());
            opz1.get(i).setEsami(new ArrayList<EsameBean>());
          }
        } else {
          opz1 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o1");
        }

        if (session.getAttribute("o2") == null) {
          for (int i = 0; i < op2.size(); i++) {
            opz2.add(new GruppoEsamiOpzionaliBean());
            opz2.get(i).setTotCfu(op2.get(i).getTotCfu());
            opz2.get(i).setEsami(new ArrayList<EsameBean>());
          }
        } else {
          opz2 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o2");
        }

        if (session.getAttribute("o3") == null) {
          for (int i = 0; i < op3.size(); i++) {
            opz3.add(new GruppoEsamiOpzionaliBean());
            opz3.get(i).setTotCfu(op3.get(i).getTotCfu());
            opz3.get(i).setEsami(new ArrayList<EsameBean>());
          }
        } else {
          opz3 = (ArrayList<GruppoEsamiOpzionaliBean>) session.getAttribute("o3");
        }

        // aggiunta esami nei gruppi opzionali 1
        for (int i = 0; i < opz1.size(); i++) {
          if (gruppo.equals("opzA1" + i) && !opz1.get(i).getEsami().contains(cercato)) {
            opz1.get(i).getEsami().add(cercato);
            for (int z = 0; z < op1.get(i).getEsami().size(); z++) {
              if (op1.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
                op1.get(i).getEsami().get(z).setCheck(true);
              }
            }
          } else {
            opz1.get(i).getEsami().remove(cercato);
            for (int z = 0; z < op1.get(i).getEsami().size(); z++) {
              if (op1.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
                op1.get(i).getEsami().get(z).setCheck(false);
              }
            }
          }
        }

        // aggiunta esami nei gruppi opzionali 2 e eventuale rimozione
        for (int i = 0; i < opz2.size(); i++) {
          if (gruppo.equals("opzA2" + i) && !opz2.get(i).getEsami().contains(cercato)) {
            opz2.get(i).getEsami().add(cercato);
            for (int z = 0; z < op2.get(i).getEsami().size(); z++) {
              if (op2.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
                op2.get(i).getEsami().get(z).setCheck(true);
              }
            }

          } else {
            opz2.get(i).getEsami().remove(cercato);
            for (int z = 0; z < op2.get(i).getEsami().size(); z++) {
              if (op2.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
                op2.get(i).getEsami().get(z).setCheck(false);
              }
            }
          }
        }

        // aggiunta esami nei gruppi opzionali 3
        for (int i = 0; i < opz3.size(); i++) {
          if (gruppo.equals("opzA3" + i) && !opz3.get(i).getEsami().contains(cercato)) {
            opz3.get(i).getEsami().add(cercato);
            for (int z = 0; z < op3.get(i).getEsami().size(); z++) {
              if (op3.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
                op3.get(i).getEsami().get(z).setCheck(true);
              }
            }
          } else {
              opz3.get(i).getEsami().remove(cercato);
              for (int z = 0; z < op3.get(i).getEsami().size(); z++) {
                  if (op3.get(i).getEsami().get(z).getCodiceEsame() == cercato.getCodiceEsame()) {
                      op3.get(i).getEsami().get(z).setCheck(false);
                  }
            }
          }
        }
        
        //aggiunta della rimozione se la scelta era presente nella scelta libera e annullamento del check
        if(sceltalibera!=null) {
        for (int i = 0; i < sceltalibera.size(); i++) {
            if (sceltalibera.get(i).getCodiceEsame() == cercato.getCodiceEsame() &&  sceltalibera.get(i).isCheck()) {
          	  sceltalibera.get(i).setCheck(false);
          	totaleCFUselezionatisceltalibera-=sceltalibera.get(i).getCfu();
          	  System.out.println("Elemento rimosso dalla scelta, totale CFU scelti:"+totaleCFUselezionatisceltalibera);
            }
        }
        }
        
        
        

        session.removeAttribute("obbligatori1");
        session.setAttribute("obbligatori1", ob1);
        session.removeAttribute("obbligatori2");
        session.setAttribute("obbligatori2", ob2);
        session.removeAttribute("obbligatori3");
        session.setAttribute("obbligatori3", ob3);

        session.removeAttribute("opzionali1");
        session.setAttribute("opzionali1", op1);
        session.removeAttribute("opzionali2");
        session.setAttribute("opzionali2", op2);
        session.removeAttribute("opzionali3");
        session.setAttribute("opzionali3", op3);

        session.removeAttribute("o1");
        session.removeAttribute("o2");
        session.removeAttribute("o3");
        session.setAttribute("o1", opz1);
        session.setAttribute("o2", opz2);
        session.setAttribute("o3", opz3);
        
        session.removeAttribute("libera");
        session.setAttribute("libera", sceltalibera);
        session.removeAttribute("totalecfuSelLib");
        session.setAttribute("totalecfuSelLib", totaleCFUselezionatisceltalibera);
        
        session.removeAttribute("utente");
        session.setAttribute("utente", utente);
        
      }

      RequestDispatcher rd = request.getRequestDispatcher("FormulazionePiano.jsp");
      request.removeAttribute("offertaFormativa");
      request.setAttribute("offertaFormativa", of);

      rd.forward(request, response);
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
