package demoqa.widgets;

import demoqa.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.SliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends TestBase {

  @BeforeMethod
  public void precondition() {
    new HomePage(driver).getWidgets();
    new SidePage(driver).selectSliderMenu();
  }
//
//  @Test
//  public void moveSliderTest() {
//    new SliderPage(driver)
//        .moveSlider(60)
//        .verifySliderValue(60);
//  }
}
