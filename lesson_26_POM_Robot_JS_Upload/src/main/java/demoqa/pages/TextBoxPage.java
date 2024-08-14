package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
  public TextBoxPage(WebDriver driver) {
    super(driver);
  }

  public TextBoxPage enterDataWithJS(String name) {
    js.executeScript("document.getElementById('userName').value='" + name + "';");
    js.executeScript("document.getElementById('userName').style.border='5px solid red';");
    return this;
  }
}
