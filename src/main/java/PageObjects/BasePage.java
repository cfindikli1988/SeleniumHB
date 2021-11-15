package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait =   new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By by) {
        waitVisibility(by).click();
    }

    public void writeText(By by, String text) {
        waitVisibility(by).sendKeys(text);
    }

    public String readText(By by) {
        return waitVisibility(by).getText();
    }

    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public WebElement waitClickability(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public void hover(By by){
        WebElement element = waitVisibility(by);

        Actions action = new Actions(driver);

        action.moveToElement(element).perform();

    }

    public void clickHold(By by)
    {
        WebElement element = waitVisibility(by);
        Actions action = new Actions(driver);
        action.clickAndHold(element).build().perform();

    }


}
