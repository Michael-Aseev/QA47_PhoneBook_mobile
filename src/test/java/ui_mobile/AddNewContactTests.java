package ui_mobile;

import config.AppiumConfig;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import static utils.ContactFactory.*;

public class AddNewContactTests extends AppiumConfig {

    ContactsScreen contactsScreen;
    AddNewContactScreen addNewContactScreen;

    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver).typeLoginFrom(User.builder()
                .username("studiesaseev27@gmail.com")
                .password("Ecbdn300396$")
                .build());
        contactsScreen = new ContactsScreen(driver);
        contactsScreen.clickBtnPlus();
        addNewContactScreen = new AddNewContactScreen(driver);


    }
    @Test
    public void addNewContactPositiveTest(){
        addNewContactScreen.typeContactForm(createPositiveContact());
        Assert.assertTrue(addNewContactScreen
                .validateMessageSuccess("Contact was added!"));

    }

    @Test
    public void addNewContactNegativeTest_WrongEmail(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongEmail(""));
        Assert.assertTrue(addNewContactScreen
                .validateMessageSuccess("Contact was added!"));

    }

    @Test
    public void addNewContactNegativeTest_WrongPhone(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongPhone(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{phone=Phone number must contain only digits! And length min 10, max 15!}"));

    }

    @Test
    public void addNewContactNegativeTest_WrongName(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongName(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{name=must not be blank}"));

    }

    @Test
    public void addNewContactNegativeTest_WrongLastName(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongLastName(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{lastName=must not be blank}"));

    }

    @Test
    public void addNewContactNegativeTest_WrongAddress(){
        addNewContactScreen.typeContactForm(createNegativeContact_WrongAddress(""));
        Assert.assertTrue(new ErrorScreen(driver)
                .validateErrorMessage("{address=must not be blank}"));

    }
}
