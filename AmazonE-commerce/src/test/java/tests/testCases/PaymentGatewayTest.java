package tests.testCases;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.LoginPage;
import tests.pageObject.PaymentGateway;

import java.time.Duration;


public class PaymentGatewayTest extends BaseClass {

  private LoginPage loginPage;
  private PaymentGateway paymentGateway;
  WebDriverWait wait;

  @BeforeMethod
  public void setUp() {
    loginPage = new LoginPage(driver);
    paymentGateway = new PaymentGateway(driver);
    wait = new WebDriverWait(driver, Duration.ofSeconds(20000));
    test = extent.createTest("Payment test", "Check item in the cart proceed to checkout with COD payment ");

  }

  @Test
  public void paymentTest() {

    try {

      paymentGateway.clickAddToCartLink();
      paymentGateway.clickProceedToCheckout();
      test.log(Status.PASS, "checkout page passed");
      paymentGateway.clickAddress();
      test.log(Status.PASS, "address select passed");
      Thread.sleep(10000);
      paymentGateway.clickPayment();
      Thread.sleep(10000);
      test.log(Status.PASS, "order will be placed successfully ");

    } catch (Exception e) {
      e.printStackTrace();
      test.log(Status.FAIL, "Failed payment gateway test ");
    }
  }
}