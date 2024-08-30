package remindly.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import remindly.fw.BaseHelper;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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
  public void performTap(Point tapPoint) {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
  }

  public void performSwipe(Point startPoint, Point endPoint) {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Sequence swipe = new Sequence(FINGER, 1)
        .addAction(FINGER.createPointerMove(Duration.ofMillis(0),
            PointerInput.Origin.viewport(), startPoint.getX(), startPoint.getY()))
        .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(FINGER.createPointerMove(Duration.ofMillis(1000),
            PointerInput.Origin.viewport(), endPoint.getX(), endPoint.getY()))
        .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(swipe));
  }
  public void chooseDateField() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(354, 1065);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
  }

  public void swipeMonth() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Point start = new Point(536, 1447);
    Point end = new Point(546, 851);
    Sequence swipe = new Sequence(FINGER, 1)
        .addAction(
            FINGER.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                start.getX(),
                start.getY()))
        .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(
            FINGER.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                end.getX(),
                end.getY()))
        .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(swipe));
  }

  public void chooseDayOfMonth() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(536, 1432);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
  }

  public void clickOnChooseYear() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(544, 683);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
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
  public void swipeYearDown() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Point start = new Point(527, 1410);
    Point end = new Point(534, 1166);
    Sequence swipe = new Sequence(FINGER, 1)
        .addAction(
            FINGER.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                start.getX(),
                start.getY()))
        .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(
            FINGER.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                end.getX(),
                end.getY()))
        .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(swipe));
  }

  public void chooseYear() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(534, 1164);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
  }

  public void confirmChooseDateOfReminder() {
    pause(500);
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(795, 1665);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
  }
  public void tapOnDateField() {
    tap(By.id("set_date"));
  }

  public void swipeToMonth(String period, String month, int number) {
    if (!getSelectedMonth().equals(month)) {
      for (int i = 0; i < number; i++) {
        if (period.equals("future")) {
          swipe(0.8, 0.5);
        } else if (period.equals("past")) {
          swipe(0.5, 0.8);
        }
      }
    }
  }

  public void swipe(double start, double stop) {
    Dimension size = driver.manage().window().getSize();
    int x = size.width / 2;
    int startY = (int) (size.height * start);
    int stopY = (int) (size.height * stop);

    new TouchAction((PerformsTouchActions) driver).longPress(PointOption.point(x, startY))
        .moveTo(PointOption.point(x, stopY))
        .release().perform();
  }

  private String getSelectedMonth() {
    return isTextPresent(By.id("date_picker_month"));
  }

  public void selectDate(int index) {
    List<WebElement> days = driver.findElements(By.className("android.view.View"));
    days.get(index).click();
  }

  public void tapOnYear() {
    tap(By.id("date_picker_year"));
  }

  public void swipeToYear(String period, String year) {
    swipeTo2025();
    tapOn2025();
  }

  private void swipeTo2025() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Point start = new Point(536, 1203);
    Point end = new Point (536, 996);
    Sequence swipe = new Sequence(FINGER, 1)
        .addAction(
            FINGER.createPointerMove(
                Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                start.getX(),
                start.getY()))
        .addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        .addAction(
            FINGER.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                end.getX(),
                end.getY()))
        .addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(swipe));
    pause(500);
  }

  private void tapOn2025() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(534, 1192);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(Arrays.asList(tap));
    pause(500);
  }

  public void tapOnOk() {
    tap(By.id("ok"));
  }
}
