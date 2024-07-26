package phonebook_16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import phonebook.model.Contact;

public class AddContactTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    if (!app.getUserHelper().isLoginLinkPresent()){
      app.getUserHelper().clokOnSignOutButton();
    }
    app.getUserHelper().loginExistedUserPositive();
  }

  @AfterMethod(enabled = true)
  public void postCondition() {
    /*
     * так как мы не будем делать тесты на редактирование то удаление контакта можно сделать отдельным методом
    */
    app.getContactHelper().removeContact();
  }

  @Test(invocationCount = 1)
  public void addContactPositiveTest() {
    app.getContactHelper().addNewContactPositiveData("TestName");
    Assert.assertTrue(app.getContactHelper().isContactAdded("TestName")); //! Добавляем проверку, что контакт появился
  }

  @Test
  public void addContactPositiveTest16() {
    app.getContactHelper().click(By.xpath("//a[.='ADD']"));
    app.getContactHelper().type(By.xpath("//input[@placeholder='Name']"), "TestName");
    app.getContactHelper().type(By.xpath("//input[@placeholder='Last Name']"), "TestLastName");
    app.getContactHelper().type(By.xpath("//input[@placeholder='Phone']"), "1234567890");
    app.getContactHelper().type(By.xpath("//input[@placeholder='email']"), "admin@gmail.com");
    app.getContactHelper().type(By.xpath("//input[@placeholder='Address']"), "Germany, Berlin");
    app.getContactHelper().type(By.xpath("//input[@placeholder='description']"), "My contact test");
    app.getContactHelper().click(By.xpath("//b[.='Save']"));
    Assert.assertTrue(app.getContactHelper().isContactAdded("TestName"));
  }

  @Test
  public void addContactPositiveTestRefactor16() {
    app.getContactHelper().clickOnAddLink();
    //fillAddContactForm(new Contact("TestName", "TestLastName", "1234567890", "admin@gmail.com", "Germany, Berlin", "My contact test"));
    app.getContactHelper().fillAddContactForm(new Contact()
        .setName("TestName")
        .setLastName("TestLastName")
        .setPhone("1234567890")
        .setEmail("admin@gmail.com")
        .setAddress("Germany, Berlin")
        .setDescription("My contact test")); // ! проверяем как тест пройдёт без этого поля
    app.getContactHelper().clickOnSaveButton();
    Assert.assertTrue(app.getContactHelper().isContactAdded("TestName"));
  }
}
