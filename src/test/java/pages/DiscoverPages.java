package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DiscoverPages {

    WebDriver driver;

    @FindBy(css = "a[href='/discover']")
    WebElement discoverBtn;

    @FindBy(css = "#sports .o-grid:first-child a")
    WebElement hikingAndRoutesBtn;

    @FindBy(css = ".c-location-search__input")
    WebElement searchInput;

    @FindBy(css = ".c-location-search__results li:first-child span")
    WebElement searchResults;

    @FindBy(css = ".c-discoverview__body")
    WebElement discoverView;

    public DiscoverPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnDiscoverBtn() {

        // ????????????? Waiter doesnt work here ????
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(discoverBtn));
        // ????????????? Waiter doesnt work here ????
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }

        discoverBtn.click();
    }

    public void clickOnhikingAndRoutesBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(hikingAndRoutesBtn));
        hikingAndRoutesBtn.click();
    }

    public void enterCity(String arg1) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(searchInput));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        searchInput.sendKeys(arg1);
    }


    public void doSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchResults));

        searchInput.sendKeys(Keys.ENTER);
    }


    public void checkUrl(String arg1) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(discoverView));
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains(arg1));
    }
}
