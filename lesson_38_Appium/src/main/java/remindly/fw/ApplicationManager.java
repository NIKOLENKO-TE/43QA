package remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import remindly.helpers.MainScreenHelper;
import remindly.helpers.ReminderHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ApplicationManager {
  public AppiumDriver driver;
  DesiredCapabilities capabilities;

  MainScreenHelper mainScreenHelper;
  ReminderHelper reminderHelper;

  public void init() throws MalformedURLException {
    capabilities = new DesiredCapabilities();

    // Стандартные W3C возможности
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "10");
    capabilities.setCapability("deviceName", "mob");

    // Appium-specific возможности
    capabilities.setCapability("appium:appPackage", "com.blanyal.remindly");
    capabilities.setCapability("appium:appActivity", "com.blanyal.remindme.MainActivity");

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    // Нажать на кнопку ОК
    driver.findElement(By.id("android:id/button1")).click();

    mainScreenHelper = new MainScreenHelper(driver);
    reminderHelper = new ReminderHelper(driver);
  }

  public MainScreenHelper getMainScreenHelper() {
    return mainScreenHelper;
  }

  public ReminderHelper getReminderHelper() {
    return reminderHelper;
  }

  public void stop() {
    driver.quit();
  }
}
