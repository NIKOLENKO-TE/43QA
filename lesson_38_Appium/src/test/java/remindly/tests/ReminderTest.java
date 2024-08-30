package remindly.tests;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Test;
import remindly.core.TestBase;

import java.time.Duration;
import java.util.Arrays;

public class ReminderTest extends TestBase {

  @Test
  public void addReminderTitlePositiveTest() {
    app.getMainScreenHelper().tapOnAddReminderButton();
    app.getReminderHelper().enterReminderTitle("PORTISHEAD");
    app.getReminderHelper().tapOnSaveReminder();
    Assert.assertTrue(app.getMainScreenHelper().isReminderTitlePresent().contains("PORTISHEAD"));
  }

  @Test
  public void testInspector(){
    app.getMainScreenHelper().tapOnAddReminderButton();
    app.getReminderHelper().enterReminderTitle("PORTISHEAD");
    clickOnDateField();  // Клик на поле выбора даты
    swipeDate1();        // Свайп первой части даты
    swipeDate2();        // Свайп второй части даты
    chooseDate();        // Выбор конкретной даты
    chooseYear();        // Выбор года
    swipeYearDown();     // Свайп вниз для смены года
    choose2025year();    // Выбор года 2025
    clickOnOkButton();   // Подтверждение выбора даты и года
    clickOnConfirmDateButton();  // Подтверждение выбранной даты
    clickOnSaveButton(); // Сохранение напоминания
    Assert.assertTrue(app.getMainScreenHelper().isReminderTitlePresent().contains("PORTISHEAD"));
  }

  // Подтверждение выбранной даты (ранее назывался step10)
  private static void clickOnConfirmDateButton() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(797, 1661);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }

  // Сохранение напоминания
  private static void clickOnSaveButton() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(1007, 164);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }

  // Подтверждение выбора (нажатие на "OK")
  private static void clickOnOkButton() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(538, 1175);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }

  // Выбор года 2025
  private static void choose2025year() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Point start = new Point(538, 1385);
    Point end = new Point(534, 1175);
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
    app.driver.perform(Arrays.asList(swipe));
  }

  // Свайп вниз для смены года
  private static void swipeYearDown() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(497, 674);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }

  // Выбор года
  private static void chooseYear() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(536, 1434);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }

  // Свайп для выбора даты
  private static void chooseDate() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Point start = new Point(579, 1346);
    Point end = new Point(570, 877);
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
    app.driver.perform(Arrays.asList(swipe));
  }

  // Свайп второй части даты
  private static void swipeDate2() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Point start = new Point(564, 1430);
    Point end = new Point(538, 793);
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
    app.driver.perform(Arrays.asList(swipe));
  }

  // Свайп первой части даты
  private static void swipeDate1() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(285, 1037);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }

  // Клик на поле выбора даты
  private static void clickOnDateField() {
    final PointerInput FINGER = new PointerInput(PointerInput.Kind.TOUCH, "FINGER");
    Point tapPoint = new Point(594, 365);
    Sequence tap = new Sequence(FINGER, 1);
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(0),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(FINGER.createPointerMove(Duration.ofMillis(50),
        PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
    tap.addAction(FINGER.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    app.driver.perform(Arrays.asList(tap));
  }
}
