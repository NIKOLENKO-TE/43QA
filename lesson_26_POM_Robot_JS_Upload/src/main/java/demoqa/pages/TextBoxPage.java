package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
  public TextBoxPage(WebDriver driver) {
    super(driver);
  }

  public TextBoxPage enterDataWithJS(String name, String email, String address) {
    // name
    // Например, мы хотим изменить цвет рамки поля
    js.executeScript("document.getElementById('userName').value='" + name + "';");
    js.executeScript("document.getElementById('userName').style.border='5px solid red';");

    // email
    js.executeScript("document.getElementById('userEmail').value='" + email + "';");
    js.executeScript("document.getElementById('userEmail').style.border='10px solid blue';");

    // address
    js.executeScript("document.getElementById('currentAddress').value='" + address + "';");
    js.executeScript("document.getElementById('currentAddress').style.border='15px solid green';");
    return this;
  }

  @FindBy(id = "submit")
  WebElement submitButton;

  public TextBoxPage clickOnSubmitButton() {
    clickWithScroll(submitButton, 200);
    return this;
  }

  public TextBoxPage getInnerTextWithJs() {
    String innerText = (String) js.executeScript("return document.getElementById('output').innerText;");
    System.out.println("Inner text is:\n" + innerText);

    String string = js.executeScript("return document.documentElement.innerText;").toString();
    System.out.println("All data: \n" + string);
    return this;
  }

  /**
   * Обновляет текущую страницу с помощью JavaScript.
   *
   * <p>Метод выполняет следующие шаги:
   * <ol>
   *   <li>Использует JavaScript для обновления страницы с помощью команды {@code history.go(0);}.</li>
   * </ol>
   *
   * @return Возвращает текущий объект {@code TextBoxPage} для возможности цепочки вызовов методов.
   */
  public TextBoxPage refreshPageWithJS() {
    js.executeScript("history.go(0);");
    return this;
  }

  public TextBoxPage checkPageTitle(String text) {
    String title = js.executeScript("return document.querySelector('h1.text-center').innerText").toString();
    assert title.equals(text);
    System.out.println("Title of page is: [" + title + "]");
    return this;
  }

  public TextBoxPage checkURLWithJS() {
    System.out.println("Current URL with JS: " + js.executeScript("return document.URL;").toString());
    System.out.println("Current URL with WebDriver: " + driver.getCurrentUrl());
    return this;
  }

  public TextBoxPage navigateToNewPageWithJS(String url) {
    //js.executeScript("window.open('" + url + "');");
    driver.get(url);
    return this;
  }

  public TextBoxPage generateAlertWithJS(String alertText) {
    js.executeScript("alert('" + alertText + "');");
    //js.executeScript("window. confirm= function(){return true;};");
    pause(1000);
    driver.switchTo().alert().accept();
    return this;
  }
}
