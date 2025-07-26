package utils;

import dto.Contact;

import static utils.RandomUtils.*;

public class ContactFactory {

    public static Contact createPositiveContact(){
        return Contact.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .email(generateEmail(12))
                .phone(generatePhone(10))
                .address("address " + generateString(10))
                .description("description")
                .build();
    }

    public static Contact createNegativeContact_WrongEmail(String email){
        return Contact.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .email(email)
                .phone(generatePhone(10))
                .address("address " + generateString(10))
                .description("description")
                .build();
    }

    public static Contact createNegativeContact_WrongPhone(String Phone){
        return Contact.builder()
                .name(generateString(5))
                .lastName(generateString(10))
                .email(generateEmail(12))
                .phone(Phone)
                .address("address " + generateString(10))
                .description("description")
                .build();
    }

    public static Contact createNegativeContact_WrongName(String Name){
        return Contact.builder()
                .name(Name)
                .lastName(generateString(10))
                .email(generateEmail(12))
                .phone(generatePhone(10))
                .address("address " + generateString(10))
                .description("description")
                .build();
    }

    public static Contact createNegativeContact_WrongLastName(String LastName){
        return Contact.builder()
                .name(generateString(10))
                .lastName("")
                .email(generateEmail(12))
                .phone(generatePhone(10))
                .address("address " + generateString(10))
                .description("description")
                .build();
    }

    public static Contact createNegativeContact_WrongAddress(String address){
        return Contact.builder()
                .name(generateString(10))
                .lastName(generateString(10))
                .email(generateEmail(12))
                .phone(generatePhone(10))
                .address("")
                .description("description")
                .build();
    }
}
