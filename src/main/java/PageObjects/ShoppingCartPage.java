package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ShoppingCartPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(SignInPage.class);
    protected WebDriver driver;

    private final By basketItemCount = By.id("basket-item-count");

    private final By removeBasketItem = By.className("product_delete_1zR-0");
    private final By confirmRemoveBasketItem = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li/div/div/div[2]/div[4]/div[2]/div[2]/div/div/div/button[2]");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public Integer getBasketItemCount() {

        return Integer.valueOf(readText(basketItemCount));


    }

    public void removeBasketItem() {

        logger.info("Item removed");

        click (removeBasketItem);
        click(confirmRemoveBasketItem);


    }




}
