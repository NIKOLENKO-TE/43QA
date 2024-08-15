package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
  public TextBoxPage(WebDriver driver) {
    super(driver);
  }

  public TextBoxPage enterDataWithJS(String name, String email) {
    // name
    js.executeScript("document.getElementById('userName').value='"+name+"';");
    // Например, мы хотим изменить цвет рамки поля
    js.executeScript("document.getElementById('userName').style.border='5px solid red';");

    // email
    js.executeScript("document.getElementById('userEmail').value='"+email+"';");
    js.executeScript("document.getElementById('userEmail').style.border='5px solid blue';");
    return this;
  }
}
