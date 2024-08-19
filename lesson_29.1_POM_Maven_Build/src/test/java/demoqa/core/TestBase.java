package demoqa.core;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
  protected static WebDriver driver;
  public static ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite
  public void setUpSuite() {
    logger.info("****************** TEST SUITE STARTING ******************");
    app.init();
    driver = app.getDriver();
  }

  @BeforeMethod
  public void setUp(Method method, Object[] parameters) {
    logger.info("****************** TESTING IN PROGRESS ******************");
    if (parameters != null && parameters.length > 0) {
      logger.info("Test is started: [" + method.getName() + "], with data: " + Arrays.asList(parameters));
    } else {
      logger.info("Test is started: [" + method.getName() + "] with no data");
    }
  }

  @AfterMethod
  public void tearDown(Method method, ITestResult result) {
    if (result.isSuccess()) {
      logger.info("Test is PASSED: [" + method.getName() + "]");
    } else {
      logger.error("Test is FAILED: [" + method.getName() + "]");
    }
  }

  @AfterSuite
  public void tearDownSuite() {
    if (app != null) {
      app.stop();
      logger.info("****************** TEST SUITE ENDED ******************");
    }
  }
}

