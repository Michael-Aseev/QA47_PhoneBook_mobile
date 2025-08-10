package config;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import static utils.PropertiesXML.*;
import static utils.PropertiesXML.getProperties;

public class DeviceFactory {

    static DesiredCapabilities createDC_old(String device) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (device.toLowerCase()) {
            case "mod1": {
                desiredCapabilities.setCapability("platformName", getProperties("platformName", device));
                desiredCapabilities.setCapability("deviceName", getProperties("deviceName", device));
                desiredCapabilities.setCapability("platformVersion", getProperties("platformVersion", device));
                desiredCapabilities.setCapability("appPackage", getProperties("appPackage", device));
                desiredCapabilities.setCapability("appActivity", getProperties("appActivity", device));
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
                return desiredCapabilities;
            }
            case "Ssamsung_Mate_20": {
                desiredCapabilities.setCapability("platformName", getProperties("platformName", device));
                desiredCapabilities.setCapability("deviceName", getProperties("deviceName", device));
                desiredCapabilities.setCapability("platformVersion", getProperties("platformVersion", device));
                desiredCapabilities.setCapability("appPackage", getProperties("appPackage", device));
                desiredCapabilities.setCapability("appActivity", getProperties("appActivity", device));
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
                return desiredCapabilities;
            }
            default:
                throw new IllegalArgumentException("Unsupported device " + device);
        }
    }

    static DesiredCapabilities createDC(String device) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", getProperties("platformName", device));
        desiredCapabilities.setCapability("deviceName", getProperties("deviceName", device));
        desiredCapabilities.setCapability("platformVersion", getProperties("platformVersion", device));
        desiredCapabilities.setCapability("appPackage", getProperties("appPackage", device));
        desiredCapabilities.setCapability("appActivity", getProperties("appActivity", device));
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        return desiredCapabilities;

    }
}
