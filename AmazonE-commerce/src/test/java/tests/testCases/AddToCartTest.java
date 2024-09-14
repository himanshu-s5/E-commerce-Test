package tests.testCases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.AddToCartPage;
import tests.pageObject.LoginPage;
import tests.pageObject.ProductSearch;


public class AddToCartTest extends BaseClass {

  private AddToCartPage addToCartPage;
  private LoginPage loginPage;
  private ProductSearch productSearch;
  private WebDriverWait wait;

  @BeforeMethod
  public void setUp() {

    addToCartPage = new AddToCartPage(driver);
    loginPage = new LoginPage(driver);
    productSearch = new ProductSearch(driver);
    test = extent.createTest("Add to cart Test", "Test product is added to cart successfully");


  }

  @Test
  public void readyForCart() throws InterruptedException {

    try {

      productSearch.scrollDown(800);
      Thread.sleep(5000);
      int initialCartCount = addToCartPage.getCartCount();
      addToCartPage.clickAddToCart();
      Thread.sleep(5000);

      int updatedCartCount = addToCartPage.getCartCount();
      Assert.assertTrue(updatedCartCount > initialCartCount, "Cart count did not increase as expected.");
      test.log(Status.PASS, "Add to cart test passed.");
      driver.navigate().to("https://www.amazon.in/ref=nav_logo");

    } catch (Exception e) {
      test.log(Status.FAIL, "Add to cart test failed: " + e.getMessage());
      throw e;
    }
  }
}