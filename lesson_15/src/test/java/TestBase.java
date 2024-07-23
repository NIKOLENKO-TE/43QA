import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://telranedu.web.app/home");
    driver.manage().window().setPosition(new Point(2500, 0));
    driver.manage().window().maximize(); // Развернуть браузер на весь экран
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Ожидание локатора
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    driver.quit();
  }

  public boolean isElementPresent(By locator){
    System.out.println("Проверка есть ли элемент ["+locator+"] на странице");
    return !driver.findElements(locator).isEmpty();
  }

  public void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  protected boolean isAlertPresent() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    if(alert == null){
      return false;
    }else{
      driver.switchTo().alert().accept();
      return true;
    }
  }

  protected void loginExistedUserPositive() {
    clickLoginLinkButton();
    type(By.name("email"),"user_admin_new3@gmail.com");
    type(By.name("password"),"Password@1");
    click(By.name("login"));
  }

  private void clickLoginLinkButton() {
    click(By.xpath("//a[.='LOGIN']"));
  }
}
