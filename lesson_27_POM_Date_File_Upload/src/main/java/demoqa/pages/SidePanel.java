package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {
  public SidePanel(WebDriver driver) {
    super(driver);
  }


  //@FindBy(xpath = "//span[contains(text(),'Login')]")
  @FindBy(xpath = "//span[.='Login']")
  WebElement login;

  public LoginPage selectLogin() {
    click(login);
    return new LoginPage(driver);
  }


  @FindBy(xpath = "//span[.='Alerts']")
  WebElement alerts;

  public AlertsPage selectAlerts() {
    click(alerts);
    return new AlertsPage(driver);
  }

  @FindBy(xpath = "//span[.='Frames']")
  WebElement frames;

  public AlertsPage selectFrames() {
    click(frames);
    return new AlertsPage(driver);
  }

  @FindBy(xpath = "//span[.='Browser Windows']")
  WebElement browserWindows;

  public AlertsPage selectBrowserWindows() {
    click(browserWindows);
    return new AlertsPage(driver);
  }


  @FindBy(xpath = "//span[.='Select Menu']")
  WebElement selectMenu;

  public WidgetsPage selectSelectMenu() {
    clickWithJS(selectMenu, 0, 600);
    return new WidgetsPage(driver);
  }

  @FindBy(xpath = "//span[.='Slider']")
  WebElement sliderMenu;

  public SliderPage selectSliderMenu() {
    clickWithJS(sliderMenu, 0, 600);
    return new SliderPage(driver);
  }


  @FindBy(xpath = "//span[.='Droppable']")
  WebElement droppable;

  public InteractionsPage selectDroppable() {
    clickWithJS(droppable, 0, 600);
    return new InteractionsPage(driver);
  }

  @FindBy(xpath = "//span[.='Tool Tips']")
  WebElement toolTipsMenu;

  public SliderPage selectToolTipsMenu() {
    clickWithJS(toolTipsMenu, 0, 600);
    return new SliderPage(driver);
  }

  @FindBy(xpath = "//span[.='Buttons']")
  WebElement buttonsMenu;

  public ButtonsPage selectButtonsMenu() {
    clickWithJS(buttonsMenu, 0, 600);
    return new ButtonsPage(driver);
  }

  @FindBy(xpath = "//span[.='Upload and Download']")
  WebElement uploadMenu;

  public UploadDownloadPage selectUploadMenu() {
    clickWithJS(uploadMenu, 0, 600);
    return new UploadDownloadPage(driver);
  }

  @FindBy(xpath = "//span[.='Auto Complete']")
  WebElement autoCompleteMenu;

  public AutoCompletePage selectAutoCompleteMenu() {
    clickWithJS(autoCompleteMenu, 0, 600);
    return new AutoCompletePage(driver);
  }

  @FindBy(xpath = "//span[.='Text Box']")
  WebElement textBox;

  public TextBoxPage selectTextBoxMenu() {
    clickWithJS(textBox, 0, 600);
    return new TextBoxPage(driver);
  }

  @FindBy(xpath = "//span[.='Links']")
  WebElement links;

  public LinksPage selectLinksMenu() {
    clickWithJS(links, 0, 600);
    return new LinksPage(driver);
  }

  @FindBy(xpath = "//span[.='Broken Links - Images']")
  WebElement brokenLinksImages;

  public BrokenLinksImagesPage selectBrokenLinksImagesMenu() {
    clickWithJS(brokenLinksImages, 0, 600);
    return new BrokenLinksImagesPage(driver);
  }

  @FindBy(xpath = "//span[.='Practice Form']")
  WebElement practiceForm;

  public PracticeFormPage selectPracticeFormMenu() {
    clickWithJS(practiceForm, 0, 600);
    return new PracticeFormPage(driver);
  }
}
