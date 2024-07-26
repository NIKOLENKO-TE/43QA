package phonebook.fw;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

// ! extends BaseHelper убрать
// ! extends UserHelper убрать
public class ApplicationManager {


  // ! Добавляем драйверы потому что они вообще не будут связаны. ApplicationManager будет связан с другими хелперами. С BaseHelper - нет
  public WebDriver driver;
  public WebDriverWait wait;

  //! Связываем app с хелперами
  UserHelper userHelper;
  HomePageHelper homePageHelper;
  ContactHelper contactHelper;

  private final String browser;
  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {
    //driver = new ChromeDriver();
    if (browser.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    } else {
      throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
    wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    driver.get("https://telranedu.web.app/home");
    driver.manage().window().setPosition(new Point(2500, 0));
    //driver.manage().window().maximize(); // Развернуть браузер на весь экран
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); // Ожидание локатора
    //! Связываем app с хелперами
    userHelper = new UserHelper(driver, wait);
    homePageHelper = new HomePageHelper(driver, wait);
    contactHelper = new ContactHelper(driver, wait);
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }

  public HomePageHelper getHomePageHelper() {
    return homePageHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public void stop() {
    if (driver != null) {
      try {
        System.out.println("\033[32m" + "Closing WebDriver: " + driver + "\033[0m");
        driver.quit();
        System.out.println("\033[31m" + "Driver has been successfully closed."+ "\033[0m");
      } catch (Exception e) {
        System.err.println("\033[31m" + "Exception while quitting the WebDriver: " + e.getMessage() + "\033[0m");
      } finally {
        driver = null;
      }
    }
    // Закрытие chromedriver.exe
    try {
      new ProcessBuilder("taskkill", "/F", "/IM", "chromedriver.exe", "/T").start();
    } catch (IOException e) {
      System.err.println("IOException while trying to kill chromedriver.exe: " + e.getMessage());
    }
  }

}
