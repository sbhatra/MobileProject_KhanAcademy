package testcases;

import org.testng.annotations.Test;

import pageobject.HybridCapability;
import pageobject.appSignOutPage;

public class appSignOut extends HybridCapability{

	appSignOutPage signoutpage;
	
	@Test
	public void signOut() throws InterruptedException {
		signoutpage = new appSignOutPage(driver);
		signoutpage.clickSignOut();
	}
}
