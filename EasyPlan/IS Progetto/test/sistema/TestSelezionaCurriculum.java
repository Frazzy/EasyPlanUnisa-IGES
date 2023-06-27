package sistema;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelezionaCurriculum {

	  static SelezionaChromeDriverSO so = new SelezionaChromeDriverSO();
	  public static final String PATH= so.selezionaChromeDriver();
	  public static final String URL="http://localhost:8080/IS_Progetto/Homepage.html";
	  
	  //TC_1.3_1
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
	        
	        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
	        
	        driver.findElement(By.xpath("//*[@id=\"l1\"]")).click(); //sceglie il piano triennale
	       
	        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'Curriculum Standard')]"));
	        sicurezzaInformaticaButton.click(); //sceglie il curriculum standard della triennale
	        Thread.sleep(1000);
	      
	        
	        //Close the Browser.
	        driver.close();
	  }
	  
      //TC_1.3_2
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
		        
		        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
		        
		        driver.findElement(By.xpath("//*[@id=\"l2\"]")).click(); //sceglie il piano magistrale
		       
		        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'SITS')]"));
		        sicurezzaInformaticaButton.click(); //sceglie SITS
		        
		      
		        Thread.sleep(1000);
		        //Close the Browser.
		        driver.close();
		  }
	  
	  
	//TC_1.3_3
	  public static void test3() throws InterruptedException {
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
		        
		        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
		        
		        driver.findElement(By.xpath("//*[@id=\"l2\"]")).click(); //sceglie il piano magistrale
		       
		        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'Internet of Things (IoT)')]"));
		        sicurezzaInformaticaButton.click(); //sceglie IOT
		        
		      
		        Thread.sleep(1000);
		        //Close the Browser.
		        driver.close();
		  }
	  
	//TC_1.3_4
	  public static void test4() throws InterruptedException {
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
		        
		        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
		        
		        driver.findElement(By.xpath("//*[@id=\"l2\"]")).click(); //sceglie il piano magistrale
		       
		        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'Sicurezza Informatica')]"));
		        sicurezzaInformaticaButton.click(); //sceglie Sicurezza
		        
		      
		        Thread.sleep(1000);
		        //Close the Browser.
		        driver.close();
		  }
	  
	//TC_1.3_5
	  public static void test5() throws InterruptedException {
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
		        
		        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
		        
		        driver.findElement(By.xpath("//*[@id=\"l2\"]")).click(); //sceglie il piano magistrale
		       
		        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'Cloud Computing')]"));
		        sicurezzaInformaticaButton.click(); //sceglie Cloud
		        
		      
		        Thread.sleep(1000);
		        //Close the Browser.
		        driver.close();
		  }
	  
	//TC_1.3_6
	  public static void test6() throws InterruptedException {
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
		        
		        driver.findElement(By.xpath("//*[@id=\"offertaformativa0\"]")).click(); //sceglie la prima offerta formativa
		        
		        driver.findElement(By.xpath("//*[@id=\"l2\"]")).click(); //sceglie il piano magistrale
		       
		        WebElement sicurezzaInformaticaButton = driver.findElement(By.xpath("//button[contains(text(), 'Data Science')]"));
		        sicurezzaInformaticaButton.click(); //sceglie Sicurezza
		        
		      
		        Thread.sleep(1000);
		        //Close the Browser.
		        driver.close();
		  }
}
