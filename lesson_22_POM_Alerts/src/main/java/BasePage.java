import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
  WebDriver driver;
  JavascriptExecutor js;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    // PageFactory упрощает работу с веб-элементами и делает код более чистым и читаемым
    // PageFactory — это утилита в Selenium WebDriver, которая упрощает инициализацию веб-элементов на странице и поддерживает концепцию Page Object Model (POM)
    // PageFactory инициализирует элементы, помеченные аннотациями в вашем классе страницы
    PageFactory.initElements(driver, this);

    js = (JavascriptExecutor) driver;
  }

  // Реализуем методы клик и тайп чуть иначе потому что там мы принимали локаторы элементов, а теперь мы будем передавать в метод сразу элементы
  public void click(WebElement element) {
    element.click();
  }

  public void type(WebElement element, String text) {
    if (text != null) {
      click(element);
      element.clear();
      element.sendKeys(text);
    }
  }

  protected void clickWithJs(WebElement element, int x, int y) {
//  js.executeScript("window.scrollBy(0,500)");
    js.executeScript("window.scrollBy(" + x + "," + y + ")");
    click(element);
  }
}
