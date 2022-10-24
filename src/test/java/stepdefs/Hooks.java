package stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Hooks {
   private static WebDriver driver;

   @Before
   public void initialize(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
   }

   @After
   public void quitDriver(){
      driver.quit();
   }

   public static WebDriver getDriver(){
      return driver;
   }
}
