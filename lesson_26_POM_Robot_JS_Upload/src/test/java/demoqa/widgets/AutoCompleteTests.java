package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.AutoCompletePage;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getWidgets();
    new SidePage(driver).selectAutoCompleteMenu().hideAds();
  }

  @Test
  public void autoCompleteTest(){
    new AutoCompletePage(driver)
        .autoComplete()
        .verifyAutoComplete("Magenta");
  }
}
