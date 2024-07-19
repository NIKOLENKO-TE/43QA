import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementsTests {
  WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://ilcarro.web.app");
    driver.manage().window().setPosition(new Point(2500, 0)); // Подвинуть окно браузера на 2500 пикселей вправо, чтобы он запускался на втором мониторе
    driver.manage().window().maximize(); // На весь экран развернуть браузер
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Ожидание локатора
  }

  // Ищем локатор элемента по тэгу в DOM-дереве сайта
  @Test
  public void testFindElementsTagName() {
    // Локатор с тегом <h1>
    WebElement h1 = driver.findElement(By.tagName("h1"));
    System.out.println(h1.getText());

    // Локатор с тегом <а> это картинка в этом случае
    WebElement a = driver.findElement(By.tagName("a"));
    System.out.println(a.getSize()); // Узнаём разрешение картинки в состоянии рендера

    // Массив локаторов с тегом <а>
    List<WebElement> elements_a = driver.findElements(By.tagName("a"));
    //System.out.println(elements_a);//  Распечатает нам все элементы массива - что лишнее
    System.out.println(elements_a.size()); // Узнаём размер массива 31 элемента на странице с тегом <а>
    System.out.println(elements_a.get(2).getText());
  }

  @Test
  public void testFindElementsByLocator() {
    // By.id
    // #city
    driver.findElement(By.cssSelector("#city"));

    // Bt.cssSelector
    // [ng-reflect-name="city"]
    driver.findElement(By.cssSelector("[ng-reflect-name='city']"));

    // By.className
    // .telephone
    driver.findElement(By.className("telephone"));

    // By.linkText
    // //a[text()=' Let the car work ']
    // //a[.=' Let the car work ']
    // //a[contains(text(), ' Let the car work ']
    // (//a[contains(text(), 'work')])[2]
    WebElement letTheCarWork = driver.findElement(By.linkText("Let the car work"));
    System.out.println(letTheCarWork.getText()); //Let the car work


    // By.partialLinkText
    driver.findElement(By.partialLinkText("work"));
  }

  @Test
  public void testFindElementsByCssSelector() {
    // input[id='city']
    // input[id^='ci']
    // input[id$='ty']
    driver.findElement(By.cssSelector("input[id='city']"));
    driver.findElement(By.cssSelector("input[id^='ci']"));
    driver.findElement(By.cssSelector("input[id$='ty']"));
    driver.findElement(By.cssSelector("#city"));
    WebElement city = driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
    System.out.println(city.getAttribute("type"));
    System.out.println(city.getAttribute("id"));
    System.out.println(city.getAttribute("formcontrolname"));
    System.out.println(city.getAttribute("ng-reflect-label"));
    System.out.println(city.getAttribute("class"));
    System.out.println(city.getAttribute("autocomplete"));

  }


  @Test
  public void testFindElementsByXpath() {
    // By.xpath
    // //*[@attr='value']
    // //*[contains(@attr, 'value')]
    // //div[@class='someClass']
    // //*[@class='someClass']
    driver.findElement(By.xpath("//h1"));

    // #city
    // //*[@id='city']
    driver.findElement(By.xpath("//*[@id='city']"));
    driver.findElement(By.xpath("//*[@class='telephone']"));


    // //a[text()=' Let the car work ']
    driver.findElement(By.xpath("//a[text()=' Let the car work ']"));
    driver.findElement(By.xpath("//a[.=' Let the car work ']"));
    driver.findElement(By.xpath("//a[contains(text(),'work')]"));
    driver.findElement(By.xpath("(//a[contains(text(),'work')])[1]"));
    driver.findElement(By.xpath("//a[starts-with(text(),'Let the car')]"));

  }








  @AfterMethod(enabled = true) // включение или отключения закрытия браузера после тестов
  public void tearDown() {
    driver.quit();
  }
}
