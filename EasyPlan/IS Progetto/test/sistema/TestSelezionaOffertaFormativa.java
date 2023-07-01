package sistema;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelezionaOffertaFormativa {

	  static SelezionaChromeDriverSO so = new SelezionaChromeDriverSO();
	  public static final String PATH= so.selezionaChromeDriver();
	  public static final String URL="http://localhost:8080/IS_Progetto/Homepage.jsp";
	  
	  //TC_1.1_1
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
	    
	        Thread.sleep(700);
	        
	        //Close the Browser.
	        driver.close();
	  }
}
