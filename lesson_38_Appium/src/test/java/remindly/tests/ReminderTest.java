package remindly.tests;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import remindly.core.TestBase;

public class ReminderTest extends TestBase {

  @Test
  public void addReminderTitlePositiveTest() {
    app.getMainScreenHelper().tapOnAddReminderButton(); // Шаг 1: Нажатие на кнопку добавления напоминания
    app.getReminderHelper().enterReminderTitle("PORTISHEAD"); // Шаг 2: Ввод названия напоминания
    app.getReminderHelper().tapOnSaveReminder(); // Шаг 3: Сохранение напоминания
    Assert.assertTrue(app.getMainScreenHelper().isReminderTitlePresent().contains("PORTISHEAD")); // Проверка наличия созданного напоминания
  }
  @Test
  public void addReminderWithDatePositiveTest() {
    app.getMainScreenHelper().tapOnAddReminder();
    app.getReminderHelper().enterReminderTitle("Holiday");
    app.getReminderHelper().tapOnDateField();
    app.getReminderHelper().swipeToMonth("future", "SEP", 1);
    app.getReminderHelper().selectDate(5);
    app.getReminderHelper().tapOnYear();
    app.getReminderHelper().swipeToYear("future", "2025");
    app.getReminderHelper().tapOnOk();
    app.getReminderHelper().tapOnSaveReminder();
    Assert.assertTrue(app.getMainScreenHelper().isReminderDateTimePresent().contains("6/9/2025"));
  }
  @Test
  public void testInspector() {
    app.getMainScreenHelper().tapOnAddReminderButton(); // Шаг 1: Нажатие на кнопку добавления напоминания
    app.getReminderHelper().enterReminderTitle("PORTISHEAD"); // Шаг 2: Ввод названия напоминания
    app.getReminderHelper().chooseDateField(); // Шаг 3: Открытие поля выбора даты
    app.getReminderHelper().swipeMonth(); // Шаг 4: Прокрутка месяца в календаре (первый свайп)
    app.getReminderHelper().swipeMonth(); // Шаг 5: Прокрутка месяца в календаре (второй свайп)
    app.getReminderHelper().chooseDayOfMonth(); // Шаг 6: Выбор дня месяца
    app.getReminderHelper().clickOnChooseYear(); // Шаг 7: Нажатие на поле выбора года
    app.getReminderHelper().swipeYearDown(); // Шаг 8: Прокрутка списка лет вниз
    app.getReminderHelper().chooseYear(); // Шаг 9: Выбор конкретного года
    app.getReminderHelper().confirmChooseDateOfReminder(); // Шаг 10: Подтверждение выбора даты напоминания
    app.getReminderHelper().tapOnSaveReminder(); // Шаг 11: Сохранение напоминания
    Assert.assertTrue(app.getMainScreenHelper().isReminderTitlePresent().contains("PORTISHEAD")); // Шаг 12: Проверка наличия созданного напоминания
  }

  @Test
  public void testInspector2() {
    app.getMainScreenHelper().tapOnAddReminderButton(); // Шаг 1: Нажатие на кнопку добавления напоминания
    app.getReminderHelper().enterReminderTitle("PORTISHEAD"); // Шаг 2: Ввод названия напоминания
    app.getReminderHelper().performTap(new Point(354, 1065)); // Шаг 3: Открытие поля выбора даты
    app.getReminderHelper().performSwipe(new Point(536, 1447), new Point(546, 851)); // Шаг 4: Прокрутка месяца (первый свайп)
    app.getReminderHelper().performSwipe(new Point(536, 1447), new Point(546, 851)); // Шаг 5: Прокрутка месяца (второй свайп)
    app.getReminderHelper().performTap(new Point(536, 1432)); // Шаг 6: Выбор дня месяца
    app.getReminderHelper().performTap(new Point(544, 683)); // Шаг 7: Нажатие на поле выбора года
    app.getReminderHelper().performSwipe(new Point(527, 1410), new Point(534, 1166)); // Шаг 8: Прокрутка списка лет вниз
    app.getReminderHelper().performTap(new Point(534, 1164)); // Шаг 9: Выбор конкретного года
    app.getReminderHelper().performTap(new Point(795, 1665)); // Шаг 10: Подтверждение выбора даты напоминания
    app.getReminderHelper().tapOnSaveReminder(); // Шаг 11: Сохранение напоминания
    Assert.assertTrue(app.getMainScreenHelper().isReminderTitlePresent().contains("PORTISHEAD")); // Шаг 12: Проверка наличия созданного напоминания
  }
}