package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class DeleteContactTest extends AppiumConfig {
    ContactsScreen contactsScreen;

    User qa_user = User.builder()
            .username("studiesaseev27@gmail.com")
            .password("Ecbdn300396$")
            .build();

    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver).typeLoginFrom(qa_user);
        contactsScreen = new  ContactsScreen(driver);
    }

    @Test
    public void deleteContactTest(){

        contactsScreen.swipeRightToLeft();
        contactsScreen.clickBtnYes();
    }
}
