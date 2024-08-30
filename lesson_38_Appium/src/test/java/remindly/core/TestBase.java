package remindly.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import remindly.fw.ApplicationManager;

import java.net.MalformedURLException;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager();

  @BeforeMethod
  public void setUp() throws MalformedURLException {
    app.init();
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    app.stop();
  }
}
