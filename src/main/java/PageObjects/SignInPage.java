package PageObjects;

import PageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class SignInPage extends BasePage{



    private By username = By.id("txtUserName");
    private By password= By.id("txtPassword");


    public SignInPage(WebDriver driver){
        super(driver);
    }


    public HomePage loginValidUser() {

        writeText(username,"cfindikli06@gmail.com"+Keys.ENTER);
        writeText(password,"1234Qwer"+Keys.ENTER);

        return new HomePage(driver);
    }





}
