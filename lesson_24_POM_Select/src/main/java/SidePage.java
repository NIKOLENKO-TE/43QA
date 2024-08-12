import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
  public SidePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//span[.='Login']")
  WebElement login;

  public LoginPage selectLogin() {
    click(login);
    return new LoginPage(driver);
  }


  //@FindBy(xpath = "//span[contains(text(),'Alerts')]")
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
    clickWithScroll(selectMenu, 500);
    return new WidgetsPage(driver);
  }
}
