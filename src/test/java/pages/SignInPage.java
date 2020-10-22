package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement Header;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailAddress;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/form/div[4]/button/div/div[2]")
    WebElement continueWithEmailBtn;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div/div[1]/div/div/div[2]/div/div[1]/form/div[3]/div/div/p")
    WebElement emptyEmailError;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div/div[1]/div/div/div[2]/form/div/div[4]/button")
    WebElement LogInButton;

    @FindBy(xpath ="//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[2]/a/div/div")
    WebElement username;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifySignUpSignInPageTitle() {
        String signUpPageTitleText = driver.getTitle();
        assertEquals(signUpPageTitleText, "Komoot Sign-Up | Login To The Great Outdoors");
    }


    public void checkHeader() {
        String getheadertext = driver.getTitle().trim();
        assertEquals( getheadertext, "Komoot Sign-Up | Login To The Great Outdoors");
    }

    public void clickOnContinueWithEmailBtn() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        continueWithEmailBtn.click();
    }

    public void checkErrorEmptyEmailDisplayed() {

        String emptyError = emptyEmailError.getText().trim();
        assertEquals( emptyError, "Please enter your email address.");
    };

    public void checkSamePage() {
        String URL = driver.getCurrentUrl();
        assertEquals(URL, "https://account.komoot.com/signin" );
    };

    public void enterEmail(String arg1) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }

        emailAddress.sendKeys(arg1);
    }

    public void enterPassword(String arg1) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        password.sendKeys(arg1);
    }

    public void clickLogInButton (){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        LogInButton.click();
    }

    public void checkUsernameDisplayed () {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }

        String usernameText = username.getText().trim();
        assertEquals( usernameText, "John Doe");

    }
}
