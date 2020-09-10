package pageobject;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridCapability {

	protected static AndroidDriver<AndroidElement> driver;
	public static AndroidDriver<AndroidElement> DesiredCapability() throws IOException {
		// TODO Auto-generated method stub

		FileReader f = new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
		java.util.Properties prop = new java.util.Properties();
		prop.load(f);
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("deviceName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		//Capabilities for Web
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, prop.getProperty("chromeDriverExecutable"));		
		
		//Capabilities for General Store app
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, prop.getProperty("appPackage"));
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, prop.getProperty("appActivity"));
        
        driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
        return driver;
	}

}
