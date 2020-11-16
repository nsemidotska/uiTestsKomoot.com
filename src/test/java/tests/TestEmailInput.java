package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class TestEmailInput {

    WebDriver driver;
    HomePage objHomePage;
    SignInPage objSignInPage;

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver 11.30.16");
            driver = new ChromeDriver();
        }
        driver.get("https://www.komoot.com/");
        //Maximize current window
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    //Verify SignInSignUp email input with empty
    public void homepageClickSignInWithEmptyEmail() {
        objHomePage = new HomePage(driver);
        objHomePage.clickOnSignUpOrSignIn();
        objSignInPage = new SignInPage(driver);
        objSignInPage.verifySignUpSignInPageTitle();
        objSignInPage.clickOnContinueWithEmailBtn();
        //Verify if Error is displayed.
        objSignInPage.checkErrorEmptyEmailDisplayed();
    }


    @Test(priority = 2)
    //Verify SignInSignUp email input with incorrect email
    public void clickSignInWithWrongEmailFormat() {
        objSignInPage.enterEmail("test@@test.test");
        objSignInPage.clickOnContinueWithEmailBtn();
        //Verify if Error is displayed.
        objSignInPage.checkSamePage();
    }

    @AfterTest
    public void shutDownSelenium() {
        driver.quit();
    }

}
