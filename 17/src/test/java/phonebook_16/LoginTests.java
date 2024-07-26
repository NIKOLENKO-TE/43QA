package phonebook_16;

import org.testng.Assert;
import org.testng.annotations.*;
import phonebook.model.User;

public class LoginTests extends TestBase{

  @BeforeClass
  public void beforeClassPrecondition(){
    System.out.println("********BeforeClass********");
  }

  @BeforeMethod
  public void ensurePrecondition(){
    System.out.println("**************BeforeMethod**************");
    // Если кнопки Логин нет - значит юзер залогинен и надо сделать разлогин
    if (!app.getUserHelper().isLoginLinkPresent()){
      app.getUserHelper().clokOnSignOutButton();
    }
  }
  @Test(priority = 1)
  public void loginExistedUserPositiveTest(){
    app.getUserHelper().loginExistedUserPositive();
    Assert.assertTrue(app.getUserHelper().isSignIutButtonPresent());
  }

  @Test(priority = 2)
  public void loginExistedUserPositiveTest2(){
    app.getUserHelper().clickLoginLink();
    //fillInRegisterLoginForm(new User("user_admin_new3@gmail.com", "Password@1"));
    app.getUserHelper().fillInRegisterLoginForm(new User()
        .setMail("user_admin_new3@gmail.com")
        .setPassword("Password@1"));
    app.getUserHelper().clickOnLoginButton();
    Assert.assertTrue(app.getUserHelper().isSignIutButtonPresent());
  }

 @Test(priority = 3)
  public void loginNegativeWithOutEmailTest(){
    app.getUserHelper().clickLoginLink();
    app.getUserHelper().fillInRegisterLoginForm(new User()
        .setMail("user_admin_new3@gmail.com")); //* теперь мы можем передать только email
    app.getUserHelper().clickOnLoginButton();
    //! Assert.assertTrue(isSignIutButtonPresent());
    Assert.assertTrue(app.getUserHelper().isAlertPresent()); // * теперь тест не будет падать
  }


  @AfterMethod
  public void afterMethodPrecondition(){
    System.out.println("**************AfterMethod**************");
  }
  @AfterClass
  public void afterClassPrecondition(){
    System.out.println("********AfterClass********");
  }


}

