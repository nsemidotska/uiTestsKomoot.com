package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import pages.SignUpPage;

public class TestSignUp {

    WebDriver driver;
    HomePage objHomePage;
    SignUpPage objSignUpPage;
    SignInPage objSignInPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver 11.30.16");
        driver = new ChromeDriver();
        driver.get("https://www.komoot.com/");
        //Maximize current window
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void open_homepage_click_on_signUp() {
        objHomePage = new HomePage(driver);
        objHomePage.verifyTitle();
        objHomePage.clickOnSignUpOrSignIn();
        objSignInPage = new SignInPage(driver);
        objSignInPage.verifySignUpSignInPageTitle();
        objSignInPage.checkHeader();
    }

    @Test(priority = 2)
    public void enter_Email() {
        //objSignInPage = new SignInPage(driver);
        objSignUpPage = new SignUpPage(driver);

        objSignUpPage.enterEmailAddress("sdertwes123123d120.10.2020@mailinator.com");
        objSignUpPage.clickOnContinueWithEmailBtn();
        objSignUpPage.verifySignUpSecondPageHeader();
    }

    @Test(priority = 3)
    public void enter_UserDetails() {
        objSignUpPage = new SignUpPage(driver);
        objSignUpPage.enterUserName("sdsfUser");
        objSignUpPage.enterPassword("sdfsdfUserPassword");
        objSignUpPage.clickOnSignUpBtn ();

        //CAPTHCA ??? RANDOMLY ????
        //objSignUpPage.checkSignUpSuccesfully();
    }

    @AfterTest
    public void shutDownSelenium() {
        driver.quit();
    }

}
