package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class DatePickerTests extends AppiumConfig {

    ContactsScreen contactsScreen;

    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver).typeLoginFrom(User.builder()
                .username("studiesaseev27@gmail.com")
                .password("Ecbdn300396$")
                .build());
        contactsScreen = new ContactsScreen(driver);
    }

    @Test
    public void datePickerPositiveTest(){
        contactsScreen.clickBtnMoreOptions();
        contactsScreen.clickBtnDatePicker()
                .clickBtnChangeDate();
        ;
    }
}
