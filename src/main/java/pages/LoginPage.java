package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

public class LoginPage {

    WebDriver driver;
    private LoginPage loginPage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage(String url) {
        driver.get(url);
    }

    public void enterTextInFieldUsername() {
        WebElement usernameFieldName = driver.findElement(By.id("username"));
        usernameFieldName.sendKeys(Constants.WRONG_USERNAME);
    }

    public void enterTextInFieldUsernameAsParameter(String username) {
        WebElement usernameFieldName = driver.findElement(By.id("username"));
        usernameFieldName.sendKeys(username);
    }

    public void enterTextInFieldPassword(String username) {
        WebElement usernameFieldName = driver.findElement(By.id("password"));
        usernameFieldName.sendKeys(username);
    }

    public void clickOnButton() {
        WebElement buttonName = driver.findElement(By.cssSelector(".fa-sign-in"));
        buttonName.click();
    }

    public void assertTextInErrorMessageUsername() {

        String expectedText = "Your username is invalid!";
        WebElement loggedInUserText = driver.findElement(By.id("flash"));
//            String actualText = loggedInUserText.getText().split("\n")[0].trim();  // test sa split
        String actualText = loggedInUserText.getText().trim();  // test sa trim
        actualText = actualText.split("\n")[0].trim();
        Assert.assertEquals(actualText, expectedText, "Actual text is: " + actualText + " and expected text is: " + expectedText);
        System.out.println("Actual text found on page is: " + actualText);
    }


    public void assertTextInErrorMessage(String expectedText) {
        WebElement loggedInUserText = driver.findElement(By.id("flash"));
        String actualText = loggedInUserText.getText().split("\n")[0].trim();
        Assert.assertEquals(actualText, expectedText, "Actual text is: " + actualText + " and expected text is: " + expectedText);
        System.out.println("Actual text found on page is: " + actualText);
    }


    public void assertColorInErrorMessage(){
        WebElement errorMessageFieldSelector = driver.findElement(By.id("flash"));
        String expectedColor = "rgba(198, 15, 19, 1)";
        String actualColor = errorMessageFieldSelector.getCssValue("background-color");
        System.out.println(actualColor);
        Assert.assertEquals(expectedColor,actualColor,"The expected color is: " + expectedColor + "and actual color " +
                "is: " +  actualColor);
    }

}
