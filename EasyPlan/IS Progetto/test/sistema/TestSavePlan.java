package sistema;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import controller.user.SelectionOffertaServlet;

public class TestSavePlan {
	static SelezionaChromeDriverSO so = new SelezionaChromeDriverSO();
	public static final String PATH= so.selezionaChromeDriver();
	public static final String URL="http://localhost:8080/IS_Progetto/Homepage.jsp";


	
	//TC_4.1_1
	public static void test1() throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",PATH );
		WebDriver driver = new ChromeDriver();
		
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to(URL);
	      
	      //Maximize the browser
	      driver.manage().window().maximize();
	      
	      
	      driver.findElement(By.xpath("./html/body/nav/div/div[2]/ul/li/a")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("francesco");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("aurilio9");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
	        
	        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
	        
	        driver.findElement(By.xpath("//*[@id=\"l2\"]")).click(); //sceglie il piano magistrale
	       
	        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'Sicurezza Informatica')]"));
	        sicurezzaInformaticaButton.click(); //sceglie Sicurezza
	        
	        //Sceglie i vari esami in maniera casuale per completare il piano di studi
	        

	        driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[2]/td[2]/form/label/span")).click();
	        
	        driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[3]/td[2]/form/label/span")).click();
	        
	        driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[4]/td[2]/form/label/span")).click();
	        

	        driver.findElement(By.xpath("/html/body/div/div[4]/table/tbody/tr[1]/td[2]/form/label/span")).click();
	        
	        driver.findElement(By.xpath("/html/body/div/div[4]/table/tbody/tr[2]/td[2]/form/label/span")).click();
	        
	        driver.findElement(By.xpath("/html/body/div/div[4]/table/tbody/tr[3]/td[2]/form/label/span")).click();
	        
	        driver.findElement(By.xpath("/html/body/div/div[4]/table/tbody/tr[4]/td[2]/form/label/span")).click();
	        
	        
	        driver.findElement(By.xpath("/html/body/div/div[5]/table/tbody/tr[5]/td[2]/form/label/span")).click();
	        driver.findElement(By.xpath("/html/body/div/div[5]/table/tbody/tr[6]/td[2]/form/label/span")).click();
	        
	        
	        driver.findElement(By.xpath("//*[@id=\"salva\"]")).click(); //Clicca il tasto di fine per completare
	      
	        
	        
	        
	        int length = 7; // Lunghezza della stringa casuale
	        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	        StringBuilder sb = new StringBuilder(length);
	        Random random = new Random();

	        for (int i = 0; i < length; i++) {
	            int randomIndex = random.nextInt(allowedCharacters.length());
	            char randomChar = allowedCharacters.charAt(randomIndex);
	            sb.append(randomChar);
	        }

	        String nomeRandom = sb.toString();

	        // Inserisce il nome casuale nella finestra modale
	        WebElement nomeInput = new WebDriverWait(driver, 10)
	                .until(ExpectedConditions.presenceOfElementLocated(By.id("nome")));
	        nomeInput.clear();
	        nomeInput.sendKeys(nomeRandom);

	        // Clicca sul pulsante "Salva" nella finestra modale
	        WebElement salvaPopupButton = driver.findElement(By.id("salvaPopup"));
	        salvaPopupButton.click();

	        // Attendi il completamento dell'operazione
	        new WebDriverWait(driver, 10)
	                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("nomePopup")));
	        
	        
	        
	     
	      Thread.sleep(1000);
	      
	      //Close the Browser.
	      driver.quit();
	}
	
	

}
