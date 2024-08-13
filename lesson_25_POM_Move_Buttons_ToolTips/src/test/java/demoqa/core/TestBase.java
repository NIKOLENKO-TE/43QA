package demoqa.core;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
  public WebDriver driver;

  @BeforeMethod
  public void init(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-search-engine-choice-screen");
    driver = new ChromeDriver(options);
    driver.manage().window().setPosition(new Point(2500, 0));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://demoqa.com/");
  }

  @AfterMethod
  public void tearDown(){
    //driver.quit();
  }
}
