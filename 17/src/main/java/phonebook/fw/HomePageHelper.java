package phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends BaseHelper {

  public HomePageHelper(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public boolean isHomeComponentPresent() {
    return isElementPresent(By.xpath("//h1[text()='Home Component']"));
  }

  public void clickOnHomeLink() {
    click(By.xpath("//a[contains(text(),'HOME')]"));
  }
}
