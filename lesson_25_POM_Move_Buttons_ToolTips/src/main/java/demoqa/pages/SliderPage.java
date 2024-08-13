package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;

public class SliderPage extends BasePage {
  public SliderPage(WebDriver driver) {
    super(driver);
  }


  @FindBy(css = ".range-slider")
  WebElement sliderContainer;

  @FindBy(id = "sliderValue")
  WebElement sliderValue;

  public SliderPage moveSlider(int value) {
    try {
      Robot robot = new Robot();
      click(sliderContainer);
      int currentValue = Integer.parseInt(sliderValue.getAttribute("value"));
      int difference = value - currentValue;

      System.out.println(difference);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return this;
  }
}
