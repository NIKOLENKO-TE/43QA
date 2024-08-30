package remindly.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import remindly.fw.BaseHelper;

public class MainScreenHelper extends BaseHelper {

  public MainScreenHelper(AppiumDriver driver) {
    super(driver);
  }

  public boolean isNoReminderTextPresent() {
    return isElementPresent(By.id("no_reminder_text"));
  }

  public void tapOnAddReminderButton() {
    tap(By.id("add_reminder"));
  }

  public String isTextPresent(By text) {
    return driver.findElement(text).getText();
  }

  public void tapOnAddReminder() {
    tap(By.id("add_reminder"));
  }

  public String isReminderTitlePresent() {
    return isTextPresent(By.id("recycle_title"));
  }

  public String isReminderDateTimePresent() {
    return isTextPresent(By.id("recycle_date_time"));
  }
}
