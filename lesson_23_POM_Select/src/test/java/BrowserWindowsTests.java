import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTests extends TestBase{
  @BeforeMethod
  public void precondition(){
    new HomePage(driver).getAlertsFrameWindows();
    new SidePage(driver).selectBrowserWindows().hideAds();
  }

  @Test
  public void newTabTest(){
    new BrowserWindowsPage(driver)
        .switchToNextTab(1)
        .verifyTabTitle("sample page");
  }
}
