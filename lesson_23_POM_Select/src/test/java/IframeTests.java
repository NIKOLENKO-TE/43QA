import com.beust.ah.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTests extends TestBase{
  @BeforeMethod
  public void precondition(){
    new HomePage(driver).getAlertsFrameWindows();
    new SidePage(driver).selectFrames();
  }

  @Test
  public void iframesCalculateTest(){
    new AlertsPage(driver).getListOfFrames();
  }

  @Test
  public void switchToIframeByIndexTest(){
    new AlertsPage(driver)
        .switchToIframeByIndex(1)
        .verifyIframeText("This is a sample page");
  }

  @Test
  public void switchToIframeByNameTest(){
    new AlertsPage(driver)
        .switchToIframeByName("frame1")
        .verifyIframeText("This is a sample page");
  }

  @Test
  public void switchToIframeByIdTest(){
    new AlertsPage(driver)
        .switchToIframeById()
        .returnToMainContent() // Страница куда встроены все frame
        .verifyMainContentText("There are 2 Iframes in this page");
  }

}
