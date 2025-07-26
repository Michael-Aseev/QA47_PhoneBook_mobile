package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    AuthenticationScreen authenticationScreen;

    @BeforeMethod
    public void goToAuthScreen(){
        new SplashScreen(driver);
        authenticationScreen = new AuthenticationScreen(driver);
    }

    @Test
    public void loginPositiveTest(){
        authenticationScreen.typeLoginFrom(User.builder()
                        .username("studiesaseev27@gmail.com")
                        .password("Ecbdn300396$")
                .build());
        Assert.assertTrue(new ContactsScreen(driver).validateContactsScreenOpen("Contact list"));

    }
}
