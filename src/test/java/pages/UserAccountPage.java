package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccountPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[3]/a/div/span")
    WebElement dropDownMenu;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[3]/div/div/ul[2]/li[3]/a")
    WebElement settingsMenuBtn;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[3]/div/div/ul[2]/li[4]/a")
    WebElement logOutBtn;

    @FindBy(xpath ="//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[2]/a/div/div")
    WebElement username;


    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickMenuBtn (){
        ////////Waiter
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dropDownMenu));
        ////////Waiter
        dropDownMenu.click();
    }

    public void clickSettingsBtn () {

        settingsMenuBtn.click();

    }

    public void clickLogoutBtn (){
        ////////Waiter
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(logOutBtn));
        ////////Waiter

        logOutBtn.click();
    }

    public void  goToAccountSettingsURL (){

        driver.get( "https://www.komoot.com/account");
    }


}
