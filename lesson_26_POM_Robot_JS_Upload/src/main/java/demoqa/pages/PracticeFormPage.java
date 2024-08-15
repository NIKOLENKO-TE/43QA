package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {
  public PracticeFormPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(id = "firstName")
  WebElement firstName;
  @FindBy(id = "lastName")
  WebElement lastName;
  @FindBy(id = "userEmail")
  WebElement userEmail;
  @FindBy(id = "userNumber")
  WebElement userNumber;

  public PracticeFormPage enterPersonalData(String name, String surName, String email, String phone) {
    type(firstName, name);
    type(lastName, surName);
    type(userEmail, email);
    type(userNumber, phone);
    return this;
  }
}
