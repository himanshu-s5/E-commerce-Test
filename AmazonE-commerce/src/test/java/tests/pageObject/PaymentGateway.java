package tests.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.BaseClass;

import java.time.Duration;

public class PaymentGateway extends BaseClass {
  WebDriver driver;
  WebDriverWait wait;


  public PaymentGateway(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
  WebElement addToCartLink;

  @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
  WebElement proceedToCheckout;

  @FindBy(xpath = "//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']")
  WebElement address;

  @FindBy(xpath = "//input[@aria-labelledby='orderSummaryPrimaryActionBtn-announce']")
  WebElement payment;

  @FindBy(xpath = "//input[@aria-labelledby='submitOrderButtonId-announce']")
  WebElement placeOrderText;

  public void clickAddToCartLink() {
    wait.until(ExpectedConditions.visibilityOf(addToCartLink));
    addToCartLink.click();
  }

  public void clickProceedToCheckout() {
    wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
    proceedToCheckout.click();
  }

  public void clickAddress() {
    wait.until(ExpectedConditions.visibilityOf(address));
    address.click();
  }

  public WebElement clickPayment() {
    wait.until(ExpectedConditions.visibilityOf(payment));
    payment.click();
    return payment;
  }

  public WebElement placeOrder() {
    wait.until(ExpectedConditions.visibilityOf(placeOrderText));
    return placeOrderText;
  }

}