package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    LoginPage loginPage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }


//    najpre sam ukucao samo driver.quit pa se prikazala greska. Nakon sto sam izguglao, uneo kod ispod. Nakon toga
//    je u redu

    @AfterMethod
    public void closeMethod() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }








}
