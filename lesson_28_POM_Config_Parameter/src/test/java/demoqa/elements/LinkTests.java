package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LinksPage;
import demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkTests extends TestBase {
  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getElements();
    new SidePanel(driver).selectLinksMenu();
  }

  @Test
  public void clickSimpleLinkTest() {
    new LinksPage(driver)
        .checkAllURL()
        .checkBrokenLinks();
  }

}
