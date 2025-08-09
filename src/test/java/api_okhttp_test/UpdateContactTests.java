package api_okhttp_test;

import dto.*;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static api_okhttp.GetAllUserContacts.getAllUserContacts;
import static api_okhttp.LoginPost.login;
import static utils.BaseAPI.GSON;
import static utils.ContactFactory.*;
import static api_okhttp.UpdateContactPut.*;

public class UpdateContactTests {

    User qa_user = User.builder()
            .username("studiesaseev27@gmail.com")
            .password("Ecbdn300396$")
            .build();
    ContactsDto contactsDtoBeforeTes;
    TokenDto tokenDto;

    @BeforeMethod
    public void loginGetAllContact() throws IOException {
        Response response = login(qa_user);
        tokenDto = GSON.fromJson(response.body().string(), TokenDto.class);
        Response response1 = getAllUserContacts(tokenDto);
        contactsDtoBeforeTes = GSON.fromJson(response1.body().string(), ContactsDto.class);
    }

    @Test
    public void updateContactPositiveTest() throws IOException {
        Contact newContact = createPositiveContact();
        Contact contact = contactsDtoBeforeTes.getContacts()[0];
        newContact.setId(contact.getId());
        Response response = updateContactPut(tokenDto, newContact);
        if (response.code() == 200){
            ResponseMessageDto responseMessageDto = GSON.fromJson(response.body().string(), ResponseMessageDto.class);
            System.out.println(responseMessageDto.toString());
            Assert.assertTrue(responseMessageDto.getMessage().contains("Contact was updated"));
        }else
            Assert.fail("status code --> " + response.code());
    }

    @Test
    public void updateContactNegativeTest_WrongId_404() throws IOException {
        Contact newContact = createPositiveContact();
        newContact.setId("1111111111111111");
        Response response = updateContactPut(tokenDto, newContact);
        if (response.code() == 404){
            ErrorMessageDto errorMessageDto = GSON.fromJson(response.body().string(), ErrorMessageDto.class);
            System.out.println(errorMessageDto.toString());
            //Assert.assertTrue(errorMessageDto.getMessage().contains("Contact was updated"));
        }else
            Assert.fail("status code --> " + response.code());
    }

    @Test
    public void updateContactNegativeTest_WrongContact_400() throws IOException {
        Contact newContact = createNegativeContact_WrongName("         ");
        Contact contact = contactsDtoBeforeTes.getContacts()[0];
        newContact.setId(contact.getId());
        Response response = updateContactPut(tokenDto, newContact);
        if (response.code() == 400){
            ErrorMessageDto errorMessageDto = GSON.fromJson(response.body().string(), ErrorMessageDto.class);
            System.out.println(errorMessageDto.toString());
            Assert.assertTrue(errorMessageDto.getMessage().toString().contains("must not be blank"));
        }else
            Assert.fail("status code --> " + response.code());
    }

    @Test
    public void updateContactNegativeTest_tokenAnotherUser_404() throws IOException {
        Contact newContact = createPositiveContact();
        Contact contact = contactsDtoBeforeTes.getContacts()[0];
        newContact.setId(contact.getId());
        TokenDto wrongToken = TokenDto.builder()
                .token("eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoic3R1ZGllc2FzZWV2MjdAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3NTUwMTM0ODEsImlhdCI6MTc1NDQxMzQ4MX0.mTPsriICnDy8AR1GDIASFJ7vUR2Lo7GEAPaWAVOsynI")
                .build();
        Response response = updateContactPut(wrongToken, newContact);
        if (response.code() == 404){
            ErrorMessageDto errorMessageDto = GSON.fromJson(response.body().string(), ErrorMessageDto.class);
            System.out.println(errorMessageDto.toString());
            Assert.assertTrue(errorMessageDto.getMessage().toString().contains("must not be blank"));
        }else
            Assert.fail("status code --> " + response.code());
    }
}
