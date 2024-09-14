package tests.testCases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.LoginPage;

public class InvalidEmailLogin extends BaseClass {
  private LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    loginPage = new LoginPage(driver);
    test = extent.createTest("Invalid password ", "Test with Invalid email");

  }

  private void performLogin(String email, String password) {

    loginPage.clickSignInLink();
    loginPage.enterEmail(email);
    loginPage.clickContinueBtn();
    loginPage.enterPassword(password);
    loginPage.clickSignInBtn();
  }

  @Test
  public void negativeLoginTestInvalidEmail() {

    try {
      performLogin("anshusharma@gmail.com", "Amazon@7073");
      String url = driver.getCurrentUrl();
      Assert.assertTrue(url.contains("https://www.amazon.in/ap"), "Expected failure, but login succeeded");
      test.log(Status.PASS, "Invalid Email Passed with error message");
      driver.navigate().to("https://www.amazon.in/ref=nav_logo");
    } catch (Exception e) {
      e.printStackTrace();
      test.log(Status.FAIL, "Invalid email test failed");
    }
  }
}


