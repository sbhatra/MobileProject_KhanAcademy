package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class appSignInPage {

	AndroidDriver<AndroidElement> driver;
	public appSignInPage(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	
	public void clickDismiss1() throws InterruptedException {
		Thread.sleep(10000);
		WebElement dismiss1 = driver.findElement(By.className("android.widget.Button"));
		dismiss1.click();
	}
	
	public void clickDismiss2() {
		WebElement dismiss2 = driver.findElementByAndroidUIAutomator("text(\"Dismiss\")");
		dismiss2.click();
	}
	
	public void signInoperation() throws InterruptedException {
		WebElement signInBtn = driver.findElement(By.className("android.widget.Button"));
		signInBtn.click();
		
		WebElement signInLink = driver.findElementByAndroidUIAutomator("text(\"Sign in\")");
		signInLink.click();
		
		WebElement cwgoogleLink = driver.findElementByAndroidUIAutomator("text(\"Continue with Google\")");
		cwgoogleLink.click();
		
		Thread.sleep(10000);
		
		WebElement chooseAcc = driver.findElement(By.id("com.google.android.gms:id/account_name"));
		String actual = chooseAcc.getText();
		actual=actual.replaceAll("@gmail.com", "");
		chooseAcc.click();
		
		Thread.sleep(10000);
		
		WebElement settingsBtn = driver.findElement(MobileBy.AccessibilityId("Settings"));
		settingsBtn.click();
		Thread.sleep(3000);
		
		WebElement accName = driver.findElements(By.className("android.widget.TextView")).get(1);
		String expected = accName.getText();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Assert.assertEquals(actual, expected);
		
	}
}
