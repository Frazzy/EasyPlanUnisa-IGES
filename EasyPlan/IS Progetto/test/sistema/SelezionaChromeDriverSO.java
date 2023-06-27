package sistema;

public class SelezionaChromeDriverSO {
	public static String selezionaChromeDriver() {

		String path=" ";

        // Ottieni il nome del sistema operativo corrente
        String os = System.getProperty("os.name").toLowerCase();

        // Verifica se il sistema operativo è Mac
        if (os.contains("mac")) {
            // Includi il percorso per Mac
            path = "chromedriver/chromedrivermac/chromedriver";
        } else if (os.contains("win")) {
            // Includi il percorso per Windows
            path = "chromedriver/chromedriverwindows/chromedriver.exe";
        } else {
            // Sistema operativo non supportato
            System.out.println("Sistema operativo non supportato");
        }

        return path;
}
}
