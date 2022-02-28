import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SuiteRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SampleTest {
    WebDriver driver;

    @BeforeTest
    public WebDriver setUp(){
        System.out.println("This is sample test");
        // Declare desired options of the Chrome Driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        String path = System.getProperty("user.dir") + "/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver(options);

        String url = "http://automationpractice.com/";
        // Open browser and url
        driver.get(url);
//        String actualTitleName = driver.getTitle();
//        System.out.println("Page Title Name: " + actualTitleName );
//        String expectedTitleName = "My Store";
        // Check the name of the page
        //Assert.assertEquals(actualTitleName,expectedTitleName);
        return driver;
    }

  //@Test
  @Ignore
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
        //driver.findElement(By.id("contact-link")).click();
        driver.findElement(By.linkText("Contact us")).click();
//        String title = driver.getTitle();
//        Assert.assertEquals(title, "Contact us - My Store");
        // Fill out Contact Us form
      Select select = new Select(driver.findElement(By.id("id_contact")));
      select.selectByValue("1");
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john@gmail.com");
       driver.findElement(By.id("id_order")).sendKeys("Order102");
       // If the file upload button in input tag and it has an attribute named type=file
       driver.findElement(By.id("fileUpload")).sendKeys("/Users/jahidul/Downloads/LetsConnect.png");
       driver.findElement(By.name("message")).sendKeys("Let's connect and work together");
       driver.findElement(By.id("submitMessage")).click();
       String message = driver.findElement(By.xpath("//*[@id='center_column']/p")).getText();
       Assert.assertEquals(message, "Your message has been successfully sent to our team.");
  }

public void selectDropdownByValue(String value){
        Select select = new Select(driver.findElement(By.id("id_contact")));
        select.selectByValue(value);
}

@Test
public void loginTest(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.id("email")).sendKeys("Jack@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Janckdh");
        driver.findElement(By.id("SubmitLogin")).click();
        String message = driver.findElement(By.xpath("//div[@id='center_column']/div[1]/p")).getText();
        Assert.assertEquals(message, "There is 1 error");

}

  @AfterTest
    public void cleanUp(){
      driver.close();
  }
}
