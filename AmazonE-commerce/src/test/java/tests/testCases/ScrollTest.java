package tests.testCases;

import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.ProductSearch;


public class ScrollTest extends BaseClass {
  private ProductSearch productSearch;

  @BeforeMethod
  public void setUp() {
    productSearch = new ProductSearch(driver);
    test = extent.createTest("Scroll test", "test scroll is working");

  }

  @Test
  public void testScroll() {
    try {
      productSearch.scrollDown(2000);
      Thread.sleep(1000);
      productSearch.scrollUp(2000);
      test.log(Status.PASS, "Scroll test Passed");
    } catch (Exception e) {
      e.printStackTrace();
      test.log(Status.FAIL, "Scroll test failed");
    }
  }
}


