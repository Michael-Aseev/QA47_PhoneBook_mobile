package ui_mobile;

import config.AppiumConfig;
import dto.Contact;
import dto.ContactsDto;
import dto.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactsScreen;
import screens.ErrorScreen;
import screens.SplashScreen;

import java.util.Arrays;

import static utils.ContactFactory.*;
import static utils.GetAllUserContactsApi.*;

import utils.GetAllUserContactsApi.*;

public class EditContactTests extends AppiumConfig {
    ContactsScreen contactsScreen;

    User qa_user = User.builder()
            .username("qa_user_qwerty@mail.com")
            .password("Password123!")
            .build();
    @BeforeMethod
    public void login(){
        new SplashScreen(driver);
        new AuthenticationScreen(driver)
                .typeLoginFrom(qa_user);
        contactsScreen = new ContactsScreen(driver);
    }

    @Test
    public void editContactPositiveTest(){
        Contact contact = createPositiveContact();
        contactsScreen.swipeLeftToRight()
                .editContact(contact)
        ;
        ContactsDto contactsDto = getAllUserContactsApi(qa_user);
        boolean flag = false;
        for (Contact contact1 : contactsDto.getContacts()){
            if(contact1.equals(contact)){
                flag=true;
            }
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void editContactPositiveTest_validateMessage(){
        Contact contact = createPositiveContact();
        contactsScreen.swipeLeftToRight()
                .editContact(contact)
        ;
        Assert.assertTrue(contactsScreen.validateMessageSuccess("Contact was updated"));
    }

    @Test
    public void editContactNegativeTest_wrongPhone(){
        Contact contact = createNegativeContact_WrongPhone("qqqqqqqqqqqqqqqqq");
        contactsScreen.swipeLeftToRight()
                .editContact(contact)
        ;
        Assert.assertTrue(new ErrorScreen(driver).validateErrorMessage("Phone number must contain"));
    }
}
