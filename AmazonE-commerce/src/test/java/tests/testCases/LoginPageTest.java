package tests.testCases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseClass;
import tests.pageObject.LoginPage;

public class LoginPageTest extends BaseClass {
  private LoginPage loginPage;

  @BeforeMethod
  public void setUp() {
    loginPage = new LoginPage(driver);
    test = extent.createTest("LoginPageTest", "Test the login functionality on Amazon");
  }

  @Test
  public void validatePage() {
    test.log(Status.INFO, "Starting validatePage test");
    String url = loginPage.getURL();
    Assert.assertTrue(url.contains("amazon"), "URL does not contain 'amazon'");
    test.log(Status.PASS, "Amazon URL validated successfully");
  }

  private void performLogin(String email, String password) {
    test.log(Status.INFO, "Performing login with email: " + email);
    loginPage.clickSignInLink();
    loginPage.enterEmail(email);
    loginPage.clickContinueBtn();
    loginPage.enterPassword(password);
    loginPage.clickSignInBtn();
  }

  @Test
  public void positiveLoginTest() {
    try {
      performLogin("Email@gmail.com", "p@7073");
      String validationMessage = loginPage.getValidationMessage();
      Assert.assertTrue(validationMessage.contains("Himanshu"), "Login failed");
      test.log(Status.PASS, "Positive login test passed");
    } catch (Exception e) {
      test.log(Status.FAIL, "Failed in perform login");
      e.printStackTrace();
      Assert.fail("Error in perform login");
    }
  }
}
