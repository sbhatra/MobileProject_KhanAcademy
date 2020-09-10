package pageobject;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class appSelectCoursePage {

	AndroidDriver<AndroidElement> driver;
	public appSelectCoursePage(AndroidDriver<AndroidElement> driver) {
		this.driver =  driver;
	}
	
	public void clickEditBtn() throws InterruptedException {
		WebElement getst = driver.findElementByAndroidUIAutomator("text(\"Edit\")");
		getst.click();
		Thread.sleep(10000);
	}
	
	public void selCourse() throws InterruptedException {
/*		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Linear algebra\"));");
		WebElement courseName = driver.findElement(By.xpath("//*[@text='Linear algebra']"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(courseName))).perform();
*/				
		WebElement doneBtn = driver.findElement(By.className("android.widget.Button"));
		doneBtn.click();
		Thread.sleep(2000);
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Graduate studies\"));");
		WebElement gradeName = driver.findElement(By.xpath("//*[@text='Graduate studies']"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(gradeName))).perform();
		Thread.sleep(2000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		
		String actual = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computer programming\"));").getText();
		String expected = "Computer programming";
		
		Assert.assertEquals(actual, expected);

	}
	
	public void launchCourseinChrome() throws InterruptedException {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Computer programming\"));");
		WebElement compProg = driver.findElement(By.xpath("//*[@text='Computer programming']"));
		compProg.click();
		Thread.sleep(3000);
		
		//WebElement clickChrome = driver.findElement(By.xpath("//[@text='Chrome']"));
		int openWithOptionsSize1 = driver.findElements(By.id("android:id/text1")).size();
		
		for(int i=0;i<openWithOptionsSize1;i++)
		{
			WebElement openWithOptions = driver.findElements(By.id("android:id/text1")).get(i);
			String chromeTxt = openWithOptions.getText();
			if(chromeTxt.contains("Chrome")) {
				openWithOptions.click();
				Thread.sleep(1000);
			}
		}
			
		WebElement justOnceBtn = driver.findElement(By.id("android:id/button_once"));
		justOnceBtn.click();
		Thread.sleep(10000);
		
		int openWithOptionsSize2 = driver.findElements(By.id("android:id/text1")).size();
		
		for(int i=0;i<openWithOptionsSize2;i++)
		{
			WebElement openWithOptions = driver.findElements(By.id("android:id/text1")).get(i);
			String chromeTxt = openWithOptions.getText();
			if(chromeTxt.contains("Chrome")) {
				openWithOptions.click();
				Thread.sleep(1000);
			}
		}
		
		justOnceBtn.click();
		Thread.sleep(15000);
		
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName: contextNames) {
			System.out.println(contextName); 
		}
		
		driver.context("WEBVIEW_chrome");
	}
}
