package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import static config.DeviceFactory.*;

public abstract class AppiumConfig {
    protected static AppiumDriver driver;
    private static final String device = System.getProperty("device", "mod1");


    @BeforeMethod(alwaysRun = true)
    public void setup(){
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "mod1");
//        desiredCapabilities.setCapability("platformVersion", "10.0");
//        //desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
//        desiredCapabilities.setCapability("appPackage", "com.sheygam.contactapp");
//        desiredCapabilities.setCapability("appActivity", ".SplashActivity");
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        DesiredCapabilities desiredCapabilities = createDC(device);
        String url = "http://localhost:4723/wd/hub";
        try {
            driver = new AndroidDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

//
//    "platformName": "Android",
//            "deviceName": "mod1",
//            "platformVersion": "10.0",
//            "appPackage": "com.sheygam.contactapp",
//            "appActivity": ".SplashActivity"