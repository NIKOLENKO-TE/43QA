package phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import phonebook.model.Contact;

import java.util.List;

public class ContactHelper extends BaseHelper {
  public static final String CONTACT_LOCATOR = "contact-item_card__2SOIM";

  public ContactHelper(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public boolean isContactAdded(String textToFind) {
    List<WebElement> contacts = driver.findElements(By.cssSelector("h2")); // сколько h2 - столько и контактов
    for(WebElement element : contacts){
      if(element.getText().contains(textToFind))
        return true;
    }
    return false;
  }

  public void addNewContactPositiveData(String name) {
    //click on Add link
    click(By.xpath("//a[.='ADD']"));
    //enter name
    type(By.xpath("//input[@placeholder='Name']"), name);
    //enter lastname
    type(By.xpath("//input[@placeholder='Last Name']"), "TestLastName");
    //enter phone
    type(By.xpath("//input[@placeholder='Phone']"), "1234567890");
    //enter email
    type(By.xpath("//input[@placeholder='email']"), "admin@gmail.com");
    //enter address
    type(By.xpath("//input[@placeholder='Address']"), "Germany, Berlin");
    //enter description
    type(By.xpath("//input[@placeholder='description']"), "My contact test");
    //click on Save button
    click(By.xpath("//b[.='Save']"));
  }

  public int actualSizeOfContacts() {
    if(isElementPresent(By.className(CONTACT_LOCATOR))){
      return driver.findElements(By.xpath("//div[@class='contact-page_leftdiv__yhyke']//div")).size();
    }
    return 0;
  }

  //protected void fillAddContactForm(String name, String lastName, String phone, String email, String address, String description) {
  public void fillAddContactForm(Contact contact) {
    type(By.xpath("//input[@placeholder='Name']"), contact.getName());
    type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
    type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
    type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
    type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
    type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
  }

  public void removeContact() {

    click(By.xpath("//div[@class='contact-item_card__2SOIM']"));
    click(By.xpath("//button[.='Remove']"));
  }

  public void clickOnSaveButton() {
    click(By.xpath("//b[.='Save']"));
  }

  public void clickOnAddLink() {
    click(By.xpath("//a[.='ADD']"));
  }
}
