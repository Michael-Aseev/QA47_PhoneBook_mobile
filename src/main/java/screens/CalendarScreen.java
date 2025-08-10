package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;


public class CalendarScreen extends BaseScreen {

    public CalendarScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "android:id/date_picker_header_year")
    WebElement btnYearHeader;
    @FindBy(id = "android:id/prev")
    WebElement btnPrevMonth;
    @FindBy(id = "android:id/next")
    WebElement btnNextMonth;
    @FindBy(id = "android:id/button1")
    WebElement btnOk;

    public DatePickerScreen typeDate(String date) {
        String[] array = date.split(" ");
        btnYearHeader.click();
        driver.findElement(By.xpath("//*[@text='" + array[2] + "']")).click();
        typeMonth(array[1]);
        driver.findElement(By.xpath("//*[@text='" + array[0] + "']")).click();
        btnOk.click();
        return new DatePickerScreen(driver);
    }
    private void typeMonth(String month) {
        int monthNow = LocalDate.now().getMonthValue() + 1;  //9 Sep
        int monthValue = Month.valueOf(month.toUpperCase()).getValue();
        if (monthNow > monthValue) { //click left
            for (int i = 0; i < monthNow - monthValue; i++) {
                btnPrevMonth.click();
            }
        } else if (monthNow < monthValue) {
            for (int i = 0; i < monthValue - monthNow; i++) {
                btnNextMonth.click();
            }
        }
    }
}
