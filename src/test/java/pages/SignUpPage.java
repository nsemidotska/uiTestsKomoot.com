package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement Header;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailAddress;

    @FindBy(xpath = "    //*[@id=\"pageMountNode\"]/div/div/div[1]/div/div/div[2]/form/div/div[1]/div/div[1]/h4\n")
    WebElement secondPageSignUpFormName;

    @FindBy(xpath = "//*[@id=\"display_name\"]")
    WebElement userName;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div/div[1]/div/div/div[2]/form/div/div[7]/button")
    WebElement signUpBtn;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[2]/div/div[1]/form/div[4]/button/div/div[2]")
    WebElement continueWithEmailBtn;

    @FindBy(xpath = "/html/head/title")
    WebElement signUpTitleText;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[3]/div/a")
    WebElement LetsGetStartedBtn;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifySignUpSecondPageHeader() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

       // String signUpPageHeaderText = getPageHeaderText();
        String secondPageSignUpForm = secondPageSignUpFormName.getText();
        assertEquals(secondPageSignUpForm, "Create a new account");
    }


    public void enterEmailAddress(String arg1) {
        emailAddress.sendKeys(arg1);
    }

    public void checkSignUpSuccesfully() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        assertEquals(LetsGetStartedBtn.isDisplayed(),true);
    }

    public void enterUserName(String arg1) {
        userName.sendKeys(arg1);
    }

    public void enterPassword(String arg1) {
        password.sendKeys(arg1);
    }

    public void clickOnContinueWithEmailBtn() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        continueWithEmailBtn.click();
    }

    public void clickOnSignUpBtn() {
        signUpBtn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

}
