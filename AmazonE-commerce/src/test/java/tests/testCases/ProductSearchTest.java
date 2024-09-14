package tests.testCases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.NotFoundException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.ProductSearch;


public class ProductSearchTest extends BaseClass {
  private ProductSearch productSearch;

  @BeforeMethod
  public void setUp() {
    productSearch = new ProductSearch(driver);
    test = extent.createTest("Product search Test", "Test the Product is available");

  }

  public void searchItem(String item) {

    productSearch.enterProduct(item);
    productSearch.clickSearch();

  }

  @Test
  public void performItemSearch() {
    try {
      String actual = "data cable c type fast charging";
      searchItem(actual);
      String expected = productSearch.validateProduct();
      Assert.assertTrue(expected.contains(actual));
      test.log(Status.PASS, "Search product availability Passed");
    } catch (NotFoundException e) {
      e.printStackTrace();
      test.log(Status.FAIL, "product search Failed");
    }
  }
}


