package sistema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCorsDiLMain {

	 public static final String PATH= "chromedriver/" + "chromedriver.exe";
	  public static final String URL="http://localhost:8080/IS_Progetto/Homepage.html";
	  public static void main(String[] args) throws InterruptedException {
	
		 
		  
		  TestSelezionaCorsoDiLaurea.test1();
		  TestSelezionaCorsoDiLaurea.test2();
		
		  
}
	  
	  
	  
}