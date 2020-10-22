package pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"pageMountNode\"]/div/div[2]/div/main/div[1]/div[1]/div/div[1]/div/div/div[3]/div/div/div[1]/button/span")
    WebElement signUpBtn;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTitle() {
        String gettitletext = driver.getTitle();
        assertEquals(gettitletext,"Komoot | Everything You Need To Explore More of the Great Outdoors");
    }

    public void clickOnSignUpOrSignIn() {
// UPDATE TO BEAUTIFUL STYLE
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
        }
        signUpBtn.click();
    }




}
