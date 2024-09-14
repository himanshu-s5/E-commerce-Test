package tests.testCases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.NotFoundException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.ProductSearch;


public class SearchInvalidItemTest extends BaseClass {
  private ProductSearch productSearch;

  @BeforeMethod
  public void setUp() {
    productSearch = new ProductSearch(driver);
    test = extent.createTest("Search product", "invalid input Product availability");

  }

  public void searchItem(String item) {

    productSearch.enterProduct(item);
    productSearch.clickSearch();

  }

  @Test
  public void invalidItemSearch() {
    try {
      String invalidItem = "xyz123invalidproduct";
      searchItem(invalidItem);
      String actual = productSearch.validateInvalidItem();
      Assert.assertTrue(actual.contains("No results"));
      test.log(Status.PASS, "Search invalid item Test Passed");
      driver.navigate().to("https://www.amazon.in/ref=nav_logo");
    } catch (NotFoundException e) {
      e.printStackTrace();
      test.log(Status.FAIL, "Search invalid item test failed");
    }
  }
}


