package sistema;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




	public class TestLogin {
		
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qualsiasipassword");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      Thread.sleep(1000);
	      
	      //Close the Browser.
	      driver.quit();
	}
	
	
	
	//TC_2.1_2
	public static void test2() {
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("ad�min");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qualsiasipassword");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      //Close the Browser.
	      driver.quit();
	}
	
	
	//TC_2.1_3
	public static void test3() {
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("usernonesisteneldb");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("qualsiasipassword");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      //Close the Browser.
		      driver.quit();
	}
	
	//TC_2.1_4
	public static void test4() {
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("qualsiasiid");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("x");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      //Close the Browser.
		      driver.quit();
	}
	
	//TC_2.1_5
	public static void test5() {
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("qualsiasiid");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("passwordlunghissima");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      //Close the Browser.
		      driver.quit();
	}
	
	
	//TC_2.1_6
	public static void test6() {
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("qualsiasiid");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admi�n");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      //Close the Browser.
		      driver.quit();
	}
	
	
	//TC_2.1_7
	public static void test7() {
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
	      
	      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("qualsiasiid");
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).click();
	      
	      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("noncorrisponde");
	      
	      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
	     
	      
	      try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      //Close the Browser.
		      driver.quit();
	}
	
	
	//TC_2.1_8
		public static void test8() {
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
		      
		      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("x");
		      
		      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
		     
		      
		      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			      //Close the Browser.
			      driver.quit();
		}
		
		//TC_2.1_9
		public static void test9() {
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
		      
		      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("passwordlunghissima");
		      
		      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
		     
		      
		      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			      //Close the Browser.
			      driver.quit();
		}
		
		
		//TC_2.1_10
		public static void test10() {
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
		      
		      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("admi�n");
		      
		      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
		     
		      
		      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			      //Close the Browser.
			      driver.quit();
		}
		
		
		//TC_2.1_11
		public static void test11() {
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
		      
		      driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("noncorrisponde");
		      
		      driver.findElement(By.xpath(" /html/body/div[1]/div/form/div[3]/button")).click();
		     
		      
		      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			      //Close the Browser.
			      driver.quit();
		}
	
	
	
	//TC_2.1_12
		public static void test12() {
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
		      
		      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     
		      
		      //Close the Browser.
		      driver.close();
		}

}
