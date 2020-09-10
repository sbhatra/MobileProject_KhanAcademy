package testcases;	

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageobject.HybridCapability;
import pageobject.appSignInPage;

public class appSignIn extends HybridCapability{

	appSignInPage signinPage;
	@Test
	public void openApp() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = DesiredCapability();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		signinPage = new appSignInPage(driver);
		signinPage.clickDismiss1();
		signinPage.clickDismiss2();
	}
	
	@Test(dependsOnMethods = "openApp")
	public void signIn() throws InterruptedException {
		signinPage.signInoperation();
	}

}
