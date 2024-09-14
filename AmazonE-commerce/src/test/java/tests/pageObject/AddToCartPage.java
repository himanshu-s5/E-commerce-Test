package tests.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.base.BaseClass;

import java.time.Duration;

public class AddToCartPage extends BaseClass {
  WebDriver driver;
  WebDriverWait wait;


  public AddToCartPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  @FindBy(id = "a-autoid-3-announce")
  WebElement addToCartButton;

  @FindBy(id = "nav-cart-count")
  WebElement cartCount;

  public void clickAddToCart() {
    wait.until(ExpectedConditions.visibilityOf(addToCartButton));
    addToCartButton.click();
  }

  public int getCartCount() {

    wait.until(ExpectedConditions.visibilityOf(cartCount));
    return Integer.parseInt(cartCount.getText());
  }
}
