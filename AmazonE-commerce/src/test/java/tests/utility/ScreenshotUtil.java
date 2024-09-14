package tests.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotUtil {

  public static void takeScreenshot(WebDriver driver, String fileName) {
    try {
      Date currentdate = new Date();
      String takesScreenshot = currentdate.toString().replace(" ", "-").replace(":", "-");
      TakesScreenshot ts = (TakesScreenshot) driver;

      File source = ts.getScreenshotAs(OutputType.FILE);

      String dest = System.getProperty("user.dir") + "/screenshots/" + takesScreenshot + ".png";

      File destination = new File(dest);
      FileUtils.copyFile(source, destination);

      System.out.println("Screenshot taken: " + dest);
    } catch (IOException e) {
      System.out.println("Exception while taking screenshot: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Failed to take screenshot: " + e.getMessage());
    }
  }
}
