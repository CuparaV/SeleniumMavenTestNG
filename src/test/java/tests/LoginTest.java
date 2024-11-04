package tests;

import org.testng.annotations.Test;
import utils.Constants;

public class LoginTest extends BaseTest {

/*
1. Scenario: Incorrect Username
Steps:

Open the login page: https://the-internet.herokuapp.com/login.
Enter an incorrect username (e.g., "wrongUser").
Enter the correct password ("SuperSecretPassword!").
Click the login button.
Expected Result: An error message is displayed, such as "Your username is invalid!"
 */



    @Test
    public void LoginWithIncorrectUsername() {
        loginPage.openLoginPage("https://the-internet.herokuapp.com/login");
        loginPage.enterTextInFieldUsername();  // pogresan username unet
        loginPage.enterTextInFieldPassword("SuperSecretPassword!");
        loginPage.clickOnButton();
        loginPage.assertTextInErrorMessageUsername();
        loginPage.assertColorInErrorMessage();
    }
/*
2. Scenario: Incorrect Password
Steps:

Open the login page: https://the-internet.herokuapp.com/login.
Enter the correct username ("tomsmith").
Enter an incorrect password (e.g., "wrongPassword").
Click the login button.
Expected Result: An error message is displayed, such as "Your password is invalid!".
 */

    /*NAPOMENA: S obizirom da sam imao problem sa prethodnim primerom, jer mi je trebao primer gde je ocekivani tekst
    trebalo da bude parametar, probao sam da napravim metodu koja ima taj ocekivani deo kao parametar kako bi mogla da
    se koristi  na vise primera.  Isto sam uradio i sa unosom teksta u polje username, gde je sada tekst parametar, i
    poziva se iz  clase Constants, mada je moglo i direktno

    Takodje, bilo bi lakse da u metodi enterTextInFieldUsernameAsParameter imamo i drugi parametar za unos css
    selectora, tako bismo pokrili sva polja koja imaju pattern da se unosi tekst i neki selektor. Nisam uspeo da ga
    napravim.
    */

    @Test
    public void loginWithIncorrectPassword() {
        loginPage.openLoginPage("https://the-internet.herokuapp.com/login");
        loginPage.enterTextInFieldUsernameAsParameter(Constants.USERNAME);
        loginPage.enterTextInFieldPassword("loremTest");  // pogresan password unet
        loginPage.clickOnButton();
        loginPage.assertTextInErrorMessage("Your password is invalid!");
        loginPage.assertColorInErrorMessage();

    }

    /*
    3. Scenario: Empty Login Fields
Steps:

Open the login page: https://the-internet.herokuapp.com/login.
Leave both the username and password fields empty.
Click the login button.
Expected Result: An error message   "Your username is invalid!" is displayed.
     */

//    NAPOMENA: Bilo bi bolje da postoji i validacija za opciju kada se ne ostave prazna polja, odnosno da se
//    koriguje tekst kao na primer "Polja username i password su obavezna", ili za svako pojedinacno

    @Test
    public void loginWithEmptyFields() {
        loginPage.openLoginPage("https://the-internet.herokuapp.com/login");
        loginPage.clickOnButton();
        loginPage.assertTextInErrorMessage("Your username is invalid!");
        loginPage.assertColorInErrorMessage();
    }


    /*
    4. Scenario: Inputting Special Characters
Steps:

Open the login page: https://the-internet.herokuapp.com/login.
Enter special characters in the username field (e.g., "@!#$%").
Enter special characters in the password field (e.g., ")*&^%").
Click the login button.
Expected Result: An error message is displayed indicating that the inputted data is invalid.
     */

    @Test
    public void loginWithSpecialCharacters() {
        loginPage.openLoginPage("https://the-internet.herokuapp.com/login");
        loginPage.enterTextInFieldUsernameAsParameter("@!#$%");
        loginPage.enterTextInFieldPassword(")*&^%");
        loginPage.clickOnButton();
        loginPage.assertTextInErrorMessage("Your username is invalid!");
        loginPage.assertColorInErrorMessage();
    }
}
