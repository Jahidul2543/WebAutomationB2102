import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SuiteRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SampleTest {
    WebDriver driver;

    @BeforeTest
    public WebDriver setUp(){
        System.out.println("This is sample test");
        System.setProperty("webdriver.chrome.driver","/Users/jahidul/IdeaProjects/WebAutomationB2102/drivers/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    @Test
    public void sampleTest(){

        String url = "http://automationpractice.com/";
        // Open browser and url
        driver.get(url);
        String actualTitleName = driver.getTitle();
        System.out.println("Page Title Name: " + actualTitleName );
        String expectedTitleName = "My Store";
        // Check the name of the page
        Assert.assertEquals(actualTitleName,expectedTitleName);
        // Close the browser

  }

  @Test
  public void searchTest(){
        //No results were found for your search "Something"
      //driver.findElement(By.id("search_query_top")).sendKeys("Something", Keys.ENTER);
      driver.findElement(By.id("search_query_top")).sendKeys("Something");
      // Click Search icon
      driver.findElement(By.name("submit_search")).click();
      String  actualMessage = driver.findElement(By.cssSelector("#center_column > p")).getText();
      String expectedMessage = "No results were found for your search \"Something\"";
      System.out.println(actualMessage);
      Assert.assertEquals(actualMessage, expectedMessage);
  }

  @Test
  public void goToContactUs(){
        driver.findElement(By.id("contact-link")).click();
      String title = driver.getTitle();
      Assert.assertEquals(title, "Contact us - My Store");
      // Fill out Contact Us form

  }

  @AfterTest
    public void cleanUp(){
      driver.close();
  }
}
