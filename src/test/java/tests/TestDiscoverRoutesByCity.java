package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DiscoverPages;

public class TestDiscoverRoutesByCity {

    WebDriver driver;
    DiscoverPages objDiscoverPages;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver 11.30.16");
            driver = new ChromeDriver();
        }

        driver.get("https://www.komoot.com/");
        //Maximize current window
        driver.manage().window().maximize();
    }


    @Test(priority = 1)
    //Verify SignInSignUp email input with empty
    public void checkSpecifiedRoutesOpened() {
        String cityName = "Kyiv";
        objDiscoverPages = new DiscoverPages(driver);
        objDiscoverPages.clickOnDiscoverBtn();
        objDiscoverPages.clickOnhikingAndRoutesBtn();
        objDiscoverPages.enterCity(cityName);
        objDiscoverPages.doSearch();
        objDiscoverPages.checkUrl(cityName);

    }

    @AfterTest
    public void shutDownSelenium() {
        driver.quit();
    }
}
