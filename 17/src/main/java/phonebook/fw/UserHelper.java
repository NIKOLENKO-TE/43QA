package phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import phonebook.model.User;

public class UserHelper extends BaseHelper {
  public UserHelper(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void loginExistedUserPositive() {
    clickLoginLink();
    //fillInRegisterLoginForm(new User("user_admin_new3@gmail.com", "Password@1"));
    fillInRegisterLoginForm(new User()
        .setMail("user_admin_new3@gmail.com")
        .setPassword("Password@1"));
    clickOnLoginButton();
  }

  public void clickOnLoginButton() {
    click(By.name("login"));
  }

  public void fillInRegisterLoginForm(User user) {
    type(By.name("email"), user.getMail());
    type(By.name("password"), user.getPassword());
  }

  public void clickLoginLink() {
    click(By.xpath("//a[.='LOGIN']"));
  }

  public boolean isSignIutButtonPresent() {
    return isElementPresent(By.xpath("//*[.='Sign Out']"));
  }

  public boolean isError409Present() {
    return isElementPresent(By.xpath("//div[.='Registration failed with code 409']"));
  }

  public void clickRegistrationButton() {
    click(By.name("registration"));
  }

  public void assertAlertAnd409Error() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(isAlertPresent());
    softAssert.assertTrue(isError409Present());
    softAssert.assertAll();
  }

  public void registerUserWithCredentials(String email, String password) {
    clickLoginLink();
    //fillInRegisterLoginForm(new User(email, password));
    fillInRegisterLoginForm(new User()
        .setMail("user_admin_new3@gmail.com")
        .setPassword("Password@1"));
    clickRegistrationButton();
  }

  public boolean isLoginLinkPresent() {
    return isElementPresent(By.xpath("//a[.='LOGIN']"));
  }

  public void clokOnSignOutButton() {
    click(By.xpath("//*[.='Sign Out']"));
  }
}
