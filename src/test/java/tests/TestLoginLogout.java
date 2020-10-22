package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.UserAccountPage;

public class TestLoginLogout {

    WebDriver driver;
    HomePage objHomePage;
    SignInPage objSignInPage;
    UserAccountPage objUserAccountPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver 11.30.16");
        driver = new ChromeDriver();
        driver.get("https://www.komoot.com/");
        //Maximize current window
        driver.manage().window().maximize();
    }
//===========================================================
     @Test(priority = 1)
    //Login with valid creds
    public void loginWithValidCredentials() {
        objHomePage = new HomePage(driver);
        objHomePage.clickOnSignUpOrSignIn();
        objSignInPage = new SignInPage(driver);
        objSignInPage.enterEmail("test1@mailinator.com");
        objSignInPage.clickOnContinueWithEmailBtn();
        objSignInPage.enterPassword("123123");
        objSignInPage.clickLogInButton();
        objSignInPage.checkUsernameDisplayed();
    }

    @Test(priority = 2)
    public void logout() {
        objUserAccountPage = new UserAccountPage(driver);
        objUserAccountPage.clickMenuBtn();
        objUserAccountPage.clickSettingsBtn();
        objUserAccountPage.clickMenuBtn();
        objUserAccountPage.clickLogoutBtn();
        objUserAccountPage.goToAccountSettingsURL();
        objUserAccountPage.checkUserRedirectedToSignIn();

    }
//===========================================================
    @AfterTest
    public void shutDownSelenium() {
        driver.quit();
    }
}
