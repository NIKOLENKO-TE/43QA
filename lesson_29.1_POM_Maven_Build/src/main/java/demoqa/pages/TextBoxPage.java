package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {
  public TextBoxPage(WebDriver driver) {
    super(driver);
  }

  public TextBoxPage enterDataWithJS(String name, String email) {
    // name
    js.executeScript("document.getElementById('userName').value='" + name + "';");
    // Например, мы хотим изменить цвет рамки поля
    js.executeScript("document.getElementById('userName').style.border='5px solid red';");

    // email
    js.executeScript("document.getElementById('userEmail').value='" + email + "';");
    js.executeScript("document.getElementById('userEmail').style.border='5px solid blue';");
    return this;
  }


  @FindBy(id = "userName")
  WebElement userName;
  @FindBy(id = "userEmail")
  WebElement userEmail;

  public TextBoxPage enterPersonalData(String name, String email) {
    // moveTo(0, 200);
    moveToView(userName);
    type(userName, name);
    type(userEmail, email);
    return this;
  }

  @FindBy(id = "currentAddress")
  WebElement currentAddress;

  public TextBoxPage keyBoardEventAddress(String address) {
    type(currentAddress, address);
    scrollPageDown();
    Actions actions = new Actions(driver);
    actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
    actions.sendKeys(Keys.TAB).perform();
    actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    return this;
  }

  @FindBy(id = "submit")
  WebElement submitButton;

  public TextBoxPage clickOnSubmitButton() {
    scrollPageDown();
    click(submitButton);
    return this;
  }

  @FindBy(xpath = "//p[@id='currentAddress']")
  WebElement currentAddressElement;

  @FindBy(xpath = "//p[@id='permanentAddress']")
  WebElement permanentAddressElement;

  public TextBoxPage verifyCopyPasteText() {
    scrollPageDown();
    String currentAddressText = currentAddressElement.getText();
    String permanentAddressText = permanentAddressElement.getText();

    String currentAddress = currentAddressText.replace("Current Address :", "").trim();
    String permanentAddress = permanentAddressText.replace("Permananet Address :", "").trim();

    boolean isAddressMatch = currentAddress.equals(permanentAddress);

    assert isAddressMatch : "Адреса не совпадают: текущий адрес = '"+ currentAddress + "', постоянный адрес: '"+permanentAddress+"'";

    return this;
  }
}
