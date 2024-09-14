package tests.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MiniTvPage {

  WebDriver driver;
  WebDriverWait wait;

  public MiniTvPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "//a[normalize-space()='Amazon miniTV']")
  WebElement miniTvLink;

  @FindBy(xpath = "//h1[contains(@class,'AppNavbar_active__UhsSt AppNavbar_navItem___QI5L Heading_desktop__F7r0J')]")
  WebElement webSeries;

  @FindBy(xpath = "//span[normalize-space()='Movies']")
  WebElement movies;


  public void clickMiniTvLink() {

    wait.until(ExpectedConditions.visibilityOf(miniTvLink));
    miniTvLink.click();
  }

  public void clickWebSeries() {

    wait.until(ExpectedConditions.visibilityOf(webSeries));
    webSeries.click();
  }

  public void clickMovies() {

    wait.until(ExpectedConditions.visibilityOf(movies));
    movies.click();
  }


}
