package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class webPlayVideoPage{

	AndroidDriver<AndroidElement> driver;
	public webPlayVideoPage(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	
	public void startVideo() throws InterruptedException {
	WebElement course1 = driver.findElement(By.xpath("//h3[text()='Intro to JS: Drawing & Animation']"));
	course1.click();
	Thread.sleep(10000);
	
	WebElement course2 = driver.findElement(By.xpath("//span[text()='What is Programming?']"));
	course2.click();
	Thread.sleep(40000);

/*	public void stopVideo() throws InterruptedException {
	WebElement stopVid = driver.findElement(By.xpath("//button[@title='Pause (k)']"));
	stopVid.click();
	Thread.sleep(2000);
	}
*/	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	Thread.sleep(5000);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	Thread.sleep(5000);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	Thread.sleep(5000);
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	Thread.sleep(5000);
	
	driver.context("NATIVE_APP");
	}
}
