package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage extends BasePage {


    private final By searchBox = By.className("desktopOldAutosuggestTheme-input");
    private final By SearchResultCount = By.className("searchResultSummaryBar-bold");
    private final By LeftMenuFirstLevelCategory = By.xpath("//*[@id=\'AllCategories.CategoryId\']/div/div/div/div/div[2]/div/div/div[1]/div/div[1]");
    private final By LeftMenuFirstLevelChildCategory = By.xpath("//*[@id=\"AllCategories.Child.CategoryId\"]/div/div/div/div/div[2]/div/div/div[2]/div/div[1]");
    private final By LeftMenuFirstLevelChildChildCategory = By.xpath("//*[@id=\"AllCategories.Child.Child.CategoryId\"]/div/div/div/div/div[2]/div/div/div[3]/div/div[1]");
    private final By myAccountFullName = By.className("sf-OldMyAccount-1k66b");
    private final By myAccount = By.id("myAccount");
    private final By myAccountChild = By.id("login");
    private final By productListContent = By.xpath("//*[@id=\'i2\']/div/a/div[3]/div[2]");
    private final By addToBasket = By.xpath("/html/body/div[8]/div/div/div/div[2]/div[2]/div[2]/button/div");
    private final By shoppingCart = By.id("shoppingCart");


    public HomePage(WebDriver driver) {
        super(driver);

    }


    public SignInPage clickSignIn() {

        click(myAccount);
        click(myAccountChild);

        return new SignInPage(driver);
    }


    public HomePage clickLeftMenu() {

        click(LeftMenuFirstLevelCategory);
        click(LeftMenuFirstLevelChildCategory);
        return new HomePage(driver);
    }

    public Integer getSearchResultCount() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(LeftMenuFirstLevelChildChildCategory));
        Integer searchResultCount = Integer.valueOf(driver.findElements(SearchResultCount).get(1).getText());
        return searchResultCount;

    }

    public HomePage typeSearchKeyword() {
        writeText(searchBox,"samsung"+Keys.ENTER);
        return this;
    }

    public String getLoggedInUseFullName() {
        return readText(myAccountFullName);
    }

    public ShoppingCartPage addToBasket(){
        click(productListContent);
        click(addToBasket);
        click(shoppingCart);
        return new ShoppingCartPage(driver);
    }


}