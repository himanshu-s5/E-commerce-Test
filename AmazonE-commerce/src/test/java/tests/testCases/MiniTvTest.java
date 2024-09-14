package tests.testCases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.MiniTvPage;

public class MiniTvTest extends BaseClass {
  private MiniTvPage miniTvPage;

  @BeforeMethod
  public void setUp() {
    miniTvPage = new MiniTvPage(driver);
    test = extent.createTest("Mini Tv page test", "test the page has contents or empty");

  }

  @Test
  public void miniTvPageDetails() {
    try {
      miniTvPage.clickMiniTvLink();
      String url = driver.getCurrentUrl();
      Assert.assertTrue(url.contains("topnav"), "URL does not contain 'minitv'");
      test.log(Status.PASS, "mini tv home page test passed");

      miniTvPage.clickMovies();
      url = driver.getCurrentUrl();
      Assert.assertTrue(url.contains("movies"), "URL does not contain 'movies'");
      test.log(Status.PASS, "Movies content passes");

      miniTvPage.clickWebSeries();
      url = driver.getCurrentUrl();
      Assert.assertTrue(url.contains("minitv"), "URL does not contain 'minitv'");
      test.log(Status.PASS, "MiniTV test  navigate page Passed");
      driver.navigate().to("https://www.amazon.in/ref=nav_logo");
    } catch (Exception e) {
      e.printStackTrace();
      test.log(Status.FAIL, "Mini TV test failed");
    }
  }
}
