# EasyPlanUnisa
Modifiche al progetto EasyPlan per l'esame di Ingegneria Gestione ed Evoluzione del Software. Nella repository è presente la cartella Documentazione che contiene tutta la documentazione prodotta durante le operazioni di manutenzione e la cartella IS che contiene la documentazione di EasyPlan prodotta per l’esame di Ingegneria Del Software. Nella cartella lib sono presenti tutte le librerie necessarie al funzionamento del sistema. Nella cartella DB è presente il database da importare per far funzionare correttamente il sistema. <br />
Lo svolgimento del progetto è stato effettuato secondo i seguenti passi: <br />
-Produzione del documento Project_Proposal_Aurilio_Granese.pdf contenente la project proposal accettata dal Professore Andrea De Lucia<br />
-Produzione documentazione del test del sistema così com’era(solo lato utente) prima delle modifiche, tale documentazione si trova in Documentazione/Test_Pre_CRs. <br />
-Implementazione test di unità, integrazione e sistema del sistema pre modifiche. <br />
-Esecuzione dei test prodotti al passo precedente e produzione del Test_Execution_Report_Pre_CRs_EasyPlan.pdf presente in Documentazione/Test_Pre_CRs e contenente il test report.<br />
-Produzione del documento Master_EasyPlan.pdf presente in Documentazione/ e contenente tutti gli artefatti che sono stati aggiunti o modificati durante le modifiche effettuate al sistema(schema e-r del db, casi d’uso, sequence diagram ecc). <br />
-Produzione della matrice di tracciabilità dei requisiti lato utente presente in Documentazione/ <br />
-Produzione dell’Impact Analysis pre modifiche contenente quindi solo i vari SIS e CIS per ogni modifica, tale documento è stato man mano aggiornato dopo l’implementazione di ogni CR e, per evidenziare meglio il ciclo di vita di questo documento, si è scelto di caricare tutte le varie versioni a partire da Impact_Analyis_EasyPlan.pdf fino a Impact_Analyis_Post_CR_03_EasyPlan.pdf(che è anche la versione dell’impact analysis definitiva). Tutte le versioni di tale documento sono presenti in Documentazione/ <br />
-Implementazione iterativa(una per volta) delle change requests effettuando, dopo ogni change request, i test delle componenti modificate o aggiunte e il test di regressione sul resto del sistema, è possibile trovare la documentazione di test per ogni CR nelle cartella Documentazione/Test_Post_CR_01, Documentazione/Test_Post_CR_02 e Documentazione/Test_Post_CR_03. Dopo ogni CR è stato aggiornata l’Impact Analysis e caricato di volta in volta il documento aggiornato nella cartella Documentazione/.  <br />
Per ogni CR le operazione gli step effettuati sono quindi: <br />
-Implementazione della CR_X <br />
-Produzione Test_Plan_Post_CR_X_EasyPlan.pdf contenente il test plan e Test_Case_Specification_Post_CR_X_EasyPlan.pdf che contiene la specifica dei test case introdotti nel suddetto test plan. <br />
-Implementazione dei test di unità, integrazione (ove necessario) e test di sistema sulla base dei due suddetti documenti per le componenti che hanno subito modifiche o che sono state aggiunte durante la CR_X. <br />
-Esecuzione dei test modificati o aggiornati e successiva esecuzione di tutti gli altri test che non avevano subito modifiche come test di regressione. <br />
-Produzione Test_Execution_Report_Post_CR_X_EasyPlan.pdf contenente il test report sia del test che del test di regressione effettuati al passo precedente. <br />
-Aggiornamento dell’Impact Analysis aggiungendo Discovered Impact Set, False Positive Impact Set, Actual Impact Set e calcolando le metriche di Precision, Recall e F-score(il tutto è presente nelle versioni dell’impact analysis successive alla CR_X) <br />

# Come avviare il software?
-Clonare il git su Eclipse <br />
-Importare il database presente nella cartella DB nella Local Instance (in root) e modificare la classe DriverManagerConnectionPool.java presente nel package model dove nelle righe 24-27 vanno inseriti i propri dati. <br />
-Importare tutte le librerie presenti nella cartella lib all’interno del progetto. La libreria gson-2.8.6.jar oltre che nel progetto va inserita anche all’interno della cartella lib del server tomcat che verrà poi utilizzato da Eclipse per lanciare il sistema. All’interno della cartella lib del server tomcat deve essere presente anche il mysql-connector-java che varia in base alla versione di MySql installata. <br />
-Avviare il progetto premendo con il tasto destro del mouse su IS Progetto, selezionando Run As—>Run on a server e scegliendo il server tomcat in cui sono state inserite le due librerie al passo precedente. <br />

# Come eseguire i test?
-I test di unità e di integrazione sono stati realizzati utilizzando JUnit pertanto basta premere con il tasto destro su un test (o anche sull’intero package(controller, integration o model)) e selezionare Run As——> JUnit Test <br />
-I test di sistema sono stati realizzati con Selenium, per eseguirli basta avviare il server e per ogni test(sono divisi per funzionalità) premere con il tasto destro sulla relativa classe main(le classi main hanno lo stesso nome del test che eseguono seguito da Main) e selezionare Run As—>Java Application. <br />

