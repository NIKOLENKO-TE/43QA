package remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class BaseHelper {
  protected AppiumDriver driver;

  public BaseHelper(AppiumDriver driver) {
    this.driver = driver;
  }

  public boolean isElementPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public void type(By locator, String text) {
    if (text != null) {
      tap(locator);
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  public void tap(By locator) {
    driver.findElement(locator).click();
  }
  public static void pause(long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
  public String isTextPresent(By text) {
    return driver.findElement(text).getText();
  }
}
