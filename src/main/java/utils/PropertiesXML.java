package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesXML {

    static Properties properties = new Properties();

    public static void main(String[] args){
//            "platformName": "Android",
//            "deviceName": "mod1",
//            "platformVersion": "10.0",
//            "appPackage": "com.sheygam.contactapp",
//            "appActivity": ".SplashActivity"
        setProperty("platformName","Android",false, "mod1");
        setProperty("deviceName", "mod1",false, "mod1");
        setProperty("platformVersion", "10.0",false, "mod1");
        setProperty("appPackage","com.sheygam.contactapp",false, "mod1");
        setProperty("appActivity", ".SplashActivity",false, "mod1");
        System.out.println(getProperties("deviceName","mod1"));
    }

    public static void setProperty(String key,String value, boolean clearFile, String device){
        if (!clearFile) {
            try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/devices"
                    + File.separator+device.toLowerCase()+".xml")){
                properties.loadFromXML(fileInputStream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        properties.setProperty(key, value);
        try(FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/devices"
                + File.separator+device.toLowerCase()+".xml")){
            properties.storeToXML(fileOutputStream,null);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String key, String device){
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/devices"
                + File.separator+device.toLowerCase()+".xml")){
            properties.loadFromXML(fileInputStream);
            return properties.getProperty(key);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
