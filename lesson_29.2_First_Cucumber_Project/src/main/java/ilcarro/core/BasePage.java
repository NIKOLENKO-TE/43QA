package ilcarro.core;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
  public static WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public void launchBrowser(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-search-engine-choice-screen");
    driver = new ChromeDriver(options);
    driver.manage().window().setPosition(new Point(2500, 0));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
  }


  public void click(WebElement element) {
    element.click();
  }

  public void type(WebElement element, String text) {
    if (text != null) {
      click(element);
      element.clear();
      element.sendKeys(text);
    }
  }

  public boolean isElementPresent(WebElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
      wait.until(ExpectedConditions.visibilityOf(element));
      System.out.println("Element is present: " + element.isDisplayed());
      return element.isDisplayed();
    } catch (Exception e) {
      System.out.println("Element is not present: " + e.getMessage());
      return false;
    }
  }
}
