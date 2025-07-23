package ui_mobile;

import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.ErrorScreen;
import screens.SplashScreen;

import static utils.UserFabric.*;

public class RegistrationTests extends AppiumConfig {

    AuthenticationScreen authenticationScreen;

    @BeforeMethod
    public void goToAuthScreen(){
        new SplashScreen(driver);
    }

    @Test
    public void registrationPositiveTest(){
        authenticationScreen = new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationFrom(createUser());
        Assert.assertTrue(new ContactsScreen(driver)
                .validateContactsScreenOpen("Contact list"));
    }

    @Test
    public void registrationNegativeTest_WrongPassworg(){
        authenticationScreen = new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationFrom(createUserWrongPassword("qertetyr1243"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{password= At least 8 characters; Must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}"));

    }

    @Test
    public void registrationNegativeTest_WrongEmail(){
        authenticationScreen = new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationFrom(createUserWrongEmail("qertetyr1243.com"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{username=must be a well-formed email address}"));

    }

    @Test
    public void registrationNegativeTest_duplicateEmail(){
        authenticationScreen = new AuthenticationScreen(driver);
        authenticationScreen.typeRegistrationFrom(createUserWrongEmail("studiesaseev@gmail.com"));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("User already exists"));

    }

}
