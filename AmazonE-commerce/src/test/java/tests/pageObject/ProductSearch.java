package tests.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSearch {
  WebDriver driver;
  WebDriverWait wait;

  public ProductSearch(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    PageFactory.initElements(driver, this);

  }

  @FindBy(id = "twotabsearchtextbox")
  WebElement searchinput;
  @FindBy(id = "nav-search-submit-button")
  WebElement searchButton;
  @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
  WebElement validateMessage;
  @FindBy(xpath = "//span[normalize-space()='No results for']")
  WebElement invalidMessage;

  public void enterProduct(String item) {

    wait.until(ExpectedConditions.visibilityOf(searchinput));
    searchinput.clear();
    searchinput.sendKeys(item);
  }

  public void clickSearch() {

    wait.until(ExpectedConditions.visibilityOf(searchButton));
    searchButton.click();
  }

  public void scrollDown(int pixels) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0," + pixels + ")");
  }

  public void scrollUp(int pixels) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,-" + pixels + ")");
  }

  public String validateProduct() {

    wait.until(ExpectedConditions.visibilityOf(validateMessage));
    return validateMessage.getText();
  }

  public String validateInvalidItem() {
    wait.until(ExpectedConditions.visibilityOf(invalidMessage));
    return invalidMessage.getText();
  }
}
