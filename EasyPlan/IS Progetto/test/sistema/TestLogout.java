package sistema;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogout {
	static SelezionaChromeDriverSO so = new SelezionaChromeDriverSO();
	public static final String PATH= so.selezionaChromeDriver();
	public static final String URL="http://localhost:8080/IS_Progetto/Homepage.html";


	
	//TC_2.1_1
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admin");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	      
	      // Individua e premi il bottone "Logout" utilizzando il percorso XPath
	      WebElement logoutButton = driver.findElement(By.cssSelector("ul.navbar-nav > li > a[href='Logout']"));
	      logoutButton.click();
	     
	      Thread.sleep(1000);
	      
	      //Close the Browser.
	      driver.quit();
	}
	
	

}
