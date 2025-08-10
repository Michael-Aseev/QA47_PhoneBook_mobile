package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Month;
import java.util.Arrays;


public class DatePickerScreen extends BaseScreen {

    public DatePickerScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/dateBtn")
    WebElement btnChangeDate;
    @FindBy(id ="com.sheygam.contactapp:id/dateTxt" )
    WebElement textDate;

    public CalendarScreen clickBtnChangeDate(){
        btnChangeDate.click();
        return new CalendarScreen(driver);
    }
    public boolean validateDate(String date){  //10 December 2026
        String text = textDate.getText();      //10/11/2026
        String[] arrayDate = text.split("/");
        String[] arrayInput = date.split(" ");
        arrayInput[1] = Integer.toString(Month.valueOf(arrayInput[1].toUpperCase()).getValue());
        System.out.println(Arrays.toString(arrayInput));
        return Arrays.equals(arrayDate, arrayInput);
    }
}
