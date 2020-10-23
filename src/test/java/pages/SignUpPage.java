package pages;

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


    @FindBy(xpath = "//*[@id=\"recaptcha-verify-button\"]")
    WebElement captchaBtn;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
