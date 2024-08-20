package ilcarro.stepDefinitions;

import ilcarro.pages.HomePage;
import ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static ilcarro.core.BasePage.driver;

public class LoginPageSteps {
  @And("Пользователь нажимает на ссылку Login")
  public void userClicksOnLoginLink() {
    new HomePage(driver).clickOnLoginLink();
  }

  @And("Пользователь вводит валидные данные")
  public void userEntersValidCredentials() {
    new LoginPage(driver).enterCredentials("test_qa@gmail.com", "Password@1");
  }

  @And("Пользователь нажимает на кнопку Yalla")
  public void userClickedOnYallaButton() {
    new LoginPage(driver).clickOnYallaButton();
  }

  @Then("Пользователь проверяет отображение сообщения об успешном логине")
  public void userVerifySuccessfulLoginMessage() {
    new LoginPage(driver).verifyTextMessage("Logged in success");
  }

  @And("Пользователь вводит валидный email и невалидный password")
  public void userEntersValidEmailInvalidPassword(DataTable table) {
    new LoginPage(driver).enterInValidCredentials(table);
  }

  @Then("Пользователь проверяет отображение сообщения об неуспешном логине")
  public void userChecksErrorMessage() {
    new LoginPage(driver).verifyTextMessage("\"Login or Password incorrect\"");
  }
}
