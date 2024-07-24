package phonebook;

import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @Test
  public void loginExistedUserPositiveTest(){
    loginExistedUserPositive();
    isSignOutButtonPresent();
  }
}

