import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getBookStore();
    new SidePage(driver).selectLogin();
  }

  @Test
  public void loginPositiveTest() {
    new LoginPage(driver)
        .enterPersonalData("root", "Qwertyuiop@1")
        .clickOnLoginButton()
        .verifyUserName("root");
  }
}
