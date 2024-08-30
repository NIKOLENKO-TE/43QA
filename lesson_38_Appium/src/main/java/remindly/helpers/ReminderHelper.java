package remindly.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import remindly.fw.BaseHelper;

public class ReminderHelper extends BaseHelper {
  public ReminderHelper(AppiumDriver driver) {
    super(driver);
  }

  public void enterReminderTitle(String text) {
    type(By.id("reminder_title"),text);
  }

  public void tapOnSaveReminder() {
    tap(By.id("save_reminder"));
  }
}
