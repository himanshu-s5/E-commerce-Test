package tests.testCases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.LoginPage;

public class InvalidPasswordLogin extends BaseClass {
  private LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    loginPage = new LoginPage(driver);
    test = extent.createTest("Invalid Password Test", "Test the Invalid password message");

  }

  private void performLogin(String email, String password) {

    loginPage.clickSignInLink();
    loginPage.enterEmail(email);
    loginPage.clickContinueBtn();
    loginPage.enterPassword(password);
    loginPage.clickSignInBtn();
  }

  @Test
  public void negativeLoginTestInvalidPassword() {

    try {
      performLogin("anshu23hhh@gmail.com", "12345");
      String url = driver.getCurrentUrl();
      Assert.assertTrue(url.contains("https://www.amazon.in/ap"), "Expected failure, but login succeeded");
      test.log(Status.PASS, "Invalid password Passed with error message");
      driver.navigate().to("https://www.amazon.in/ref=nav_logo");
    } catch (Exception e) {
      e.printStackTrace();
      test.log(Status.FAIL, "Invalid password test failed");
    }
  }
}


