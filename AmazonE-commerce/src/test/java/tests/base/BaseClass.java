package tests.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.utility.ScreenshotUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

  public static Properties properties;
  public static WebDriver driver;
  public static ExtentReports extent;
  public static ExtentTest test;

  @BeforeSuite
  public void loadConfig() {
    properties = new Properties();
    try (FileInputStream file = new FileInputStream("configuration/config.properties")) {
      properties.load(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
    ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-reports/test-report.html");
    htmlReporter.config().setDocumentTitle("Automation Report");
    htmlReporter.config().setReportName("Amazon E-commerce Testing");
    htmlReporter.config().setTheme(Theme.STANDARD);

    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Host Name", "Localhost");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("User Name", "Himanshu");

    setupBrowser(properties.getProperty("browser"));
    driver.get(properties.getProperty("url"));
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
  }

  private void setupBrowser(String browserName) {
    switch (browserName.toLowerCase()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        break;
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        break;
      case "edge":
        WebDriverManager.edgedriver().setup();
        driver = new ChromeDriver();
        break;
    }
  }

  @AfterMethod
  public void tearDown(ITestResult result) {
    if (ITestResult.FAILURE == result.getStatus()) {
      ScreenshotUtil.takeScreenshot(driver, result.getName());
      test.log(Status.FAIL, "Test failed, screenshot taken: " + result.getName());
    } else if (ITestResult.SUCCESS == result.getStatus()) {
      test.log(Status.PASS, "Test passed successfully: " + result.getName());
    }
  }

  @AfterSuite
  public void cleanUp() {
    if (driver != null) {
      driver.quit();
    }
    if (extent != null) {
      extent.flush();
    }
  }
}
