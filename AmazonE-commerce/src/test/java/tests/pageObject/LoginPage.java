package tests.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
  WebDriver driver;
  WebDriverWait wait;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//span[normalize-space()='Account & Lists']")
  WebElement signLink;

  @FindBy(id = "ap_email")
  WebElement email;

  @FindBy(id = "continue")
  WebElement continueBtn;

  @FindBy(id = "ap_password")
  WebElement password;

  @FindBy(id = "signInSubmit")
  WebElement signInBtn;

  @FindBy(id = "nav-link-accountList-nav-line-1")
  WebElement helloText;

  public String getURL() {
    return driver.getCurrentUrl();
  }

  public void clickSignInLink() {
    wait.until(ExpectedConditions.visibilityOf(signLink));
    signLink.click();
  }

  public void enterEmail(String key) {
    wait.until(ExpectedConditions.visibilityOf(email));
    email.clear();
    email.sendKeys(key);
  }

  public void clickContinueBtn() {
    wait.until(ExpectedConditions.visibilityOf(continueBtn));
    continueBtn.click();
  }

  public void enterPassword(String key) {
    wait.until(ExpectedConditions.visibilityOf(password));
    password.clear();
    password.sendKeys(key);
  }

  public void clickSignInBtn() {
    wait.until(ExpectedConditions.visibilityOf(signInBtn));
    signInBtn.click();
  }

  public String getValidationMessage() {
    wait.until(ExpectedConditions.visibilityOf(helloText));
    return helloText.getText();
  }

  public WebElement getEmail() {
    wait.until(ExpectedConditions.visibilityOf(email));
    return email;
  }

  public WebElement getPassword() {
    wait.until(ExpectedConditions.visibilityOf(password));
    return password;
  }
}
