package stepdefs;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Hooks {
   private static WebDriver driver;
   //private LoginPage loginPage;

   @Before
   public void initialize(){
      System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
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
