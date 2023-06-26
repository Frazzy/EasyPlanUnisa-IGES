package sistema;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFormulazionePianoTriennale {


	public static final String PATH= "chromedriver/" + "chromedriver.exe";
	public static final String URL="http://localhost:8080/IS_Progetto/Homepage.html";
	
	//TC_1.4_1
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
	      
	      driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"l1\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"c\"]")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[2]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[3]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"fine\"]")).click();
	      
	      
	      Thread.sleep(500);//attende il tempo necessario 
	      
	      //Close the Browser.
	      driver.close();
	}
	
	
	
	
	
	
	
	
	//TC_1.4_2
	public static void test2() throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",PATH );
		WebDriver driver = new ChromeDriver();
		
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to(URL);
	      
	      //Maximize the browser
	      driver.manage().window().maximize();
	      
	      driver.findElement(By.xpath("/html/body/div[1]/form/button")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"l1\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"c\"]")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[2]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[3]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[4]/td[2]/form/label/span")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"fine\"]")).click();
	      
	      driver.findElement(By.xpath("/html/body/div/button")).click();//Clicca il tasto per stampare il piano
	        Thread.sleep(500);//attende il tempo necessario per il download del PDF
	      
	      //Close the Browser.
	      driver.close();
	}
	
}
