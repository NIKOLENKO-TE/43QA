package remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import remindly.core.TestBase;

public class MainScreenTest extends TestBase {

  @Test
  public void appLaunchTest(){
   Assert.assertTrue(app.getMainScreenHelper().isNoReminderTextPresent());
  }
}
