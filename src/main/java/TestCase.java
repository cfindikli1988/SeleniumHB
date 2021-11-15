


import Logs.Log;
import PageObjects.HomePage;
import PageObjects.ShoppingCartPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestCase  {


    private static WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;


    @BeforeSuite
    void PreSetup() {
        htmlReporter = new ExtentHtmlReporter("SeleniumHepsiburadaAssignmentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    @BeforeTest
    void Setup() {

        test = extent.createTest("HBUserJourney", "ValidUserLoggedInSearchForSamsungMobilePhoneAndAddtoBasket");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Log.info("Hepsiburada Is Opening");
        driver.get("https://www.hepsiburada.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.hepsiburada.com/");
        test.pass("Hepsiburada Home Page Opened Successfully");


    }

    @Test
    void UserJourney() {

        test.info("User Journey Started");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignIn().loginValidUser();
        Assert.assertEquals("Caglar FINDIKLI", homePage.getLoggedInUseFullName());
        test.pass("Valid User Logged In Successfully");
        homePage.typeSearchKeyword().clickLeftMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertNotEquals(homePage.getSearchResultCount(), 0);
        test.pass(homePage.getSearchResultCount() + " results found for samsung");
        homePage.addToBasket();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertNotEquals(shoppingCartPage.getBasketItemCount(), 0);
        shoppingCartPage.removeBasketItem();

    }

    @AfterTest
    void tearDown() {
        Log.info("Test finished");
        extent.flush();
        Log.info("Chrome Browser Is Closing");
        driver.close();
        driver.quit();

    }


}











