package phonebook_16;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import phonebook.fw.ApplicationManager;

public class TestBase {

  // static чтобы он инициализировался больше чем 1 раз
  protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));

  //@BeforeMethod
  @BeforeSuite
  public void setUp() {
    System.out.println("****BeforeSuite****");
    app.init();
  }

  //@AfterMethod
  @AfterSuite
  public void tearDown() {
    System.out.println("****AfterSuite****");
    app.stop();
  }
}
