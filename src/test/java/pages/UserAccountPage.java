package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[3]/a/div/span")
    WebElement dropDownMenu;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[3]/div/div/ul[2]/li[4]/a")
    WebElement logOutBtn;

    @FindBy(xpath ="//*[@id=\"pageMountNode\"]/div/div[2]/div/div/div[2]/div[3]/div[2]/a/div/div")
    WebElement username;


    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickMenuBtn (){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        dropDownMenu.click();
    }

    public void clickLogoutBtn (){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
        logOutBtn.click();
    }

    public void checkUserLoggedOut () {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }

        String strUrl = driver.getCurrentUrl();
        assertEquals( strUrl, "https://www.komoot.com/");

    }

}
