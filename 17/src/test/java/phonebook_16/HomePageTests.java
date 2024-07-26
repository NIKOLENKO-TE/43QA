package phonebook_16;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    // Если этого компонента нет на странице - то переходим на Домашнюю страницу
    if (!app.getHomePageHelper().isHomeComponentPresent()) {
      app.getHomePageHelper().clickOnHomeLink();
    }
  }
  @Test
  public void homePageTest() {
    Assert.assertTrue(app.getHomePageHelper().isHomeComponentPresent());
  }
}
