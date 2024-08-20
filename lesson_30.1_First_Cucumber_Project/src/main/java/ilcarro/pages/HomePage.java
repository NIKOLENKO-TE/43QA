package ilcarro.pages;

import ilcarro.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  public HomePage openHomePage() {
    driver.get("https://ilcarro.web.app/");
    return new HomePage(driver);
  }

  @FindBy(xpath = "//h1[contains(text(),'Find your car now!')]")
  WebElement homePageTitle;

  public boolean isHomePageTitleIsDisplayed() {
    //System.out.println("Checking if homePageTitle is displayed: " + homePageTitle.isDisplayed());
    return isElementPresent(homePageTitle);
  }

  @FindBy(xpath = "//a[@ng-reflect-router-link='login']")
  WebElement loginLink;

  public LoginPage clickOnLoginLink() {
    click(loginLink);
    return new LoginPage(driver);
  }
}
