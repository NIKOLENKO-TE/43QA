import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
  WebDriver driver;
  JavascriptExecutor js;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    // PageFactory упрощает работу с веб-элементами и делает код более чистым и читаемым
    // PageFactory — это утилита в Selenium WebDriver, которая упрощает инициализацию веб-элементов на странице и поддерживает концепцию Page Object Model (POM)
    // PageFactory инициализирует элементы, помеченные аннотациями в вашем классе страницы
    PageFactory.initElements(driver, this);
    // JavascriptExecutor - позволяет выполнять произвольные JavaScript-код в контексте веб-страницы.
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

  public void clickWithJs(WebElement element, int x, int y) {
    // js.executeScript("window.scrollBy(100,200)");
    // x - сколько пикселей прокрутить по горизонтали
    // y - сколько пикселей прокрутить по вертикали
    //  js.executeScript("window.scrollBy(0,500)");
    js.executeScript("window.scrollBy(" + x + "," + y + ")");
    click(element);
  }

  public void shouldHaveText(WebElement element, String text, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(timeout));
    try {
      wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    } catch (TimeoutException e) {
      throw new AssertionError("The text [" + text + "] was not found in the [" + element + "] within [" + timeout +"] milliseconds");
    }catch (UnhandledAlertException e){
      throw new AssertionError("No alert present wile waiting for text ["+text+"] in the [" +element.getTagName()+"]");
    }
  }
}
