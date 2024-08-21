package sconto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;

public class HomePage {

  // @FindBy(xpath = "//div[@data-accept-action='all']")
  // WebElement acceptCookiesButton;

  private final SelenideElement acceptCookiesButton = $(byXpath("//div[@data-accept-action='all']"));

  public HomePage acceptCookies() {
    if (acceptCookiesButton.exists()) {
      acceptCookiesButton.click();
    }
    return Selenide.page(this);
  }

  public LoginPage clickOnLoginIcon() {
    $(byClassName("headerElement__icon--login")).click();
    return Selenide.page(LoginPage.class);
  }

  public HomePage userNameStatus() {
    pause(500);
    $(className("headerElement__status--login")).shouldHave(text("Tyomii Nikolenko"));
    return Selenide.page(this);
  }
  public void pause(long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
