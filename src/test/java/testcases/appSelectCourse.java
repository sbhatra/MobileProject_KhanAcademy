package testcases;

import org.testng.annotations.Test;

import pageobject.HybridCapability;
import pageobject.appSelectCoursePage;

public class appSelectCourse extends HybridCapability{
	
	appSelectCoursePage selCoursePage;
	
	@Test
	public void courseSel() throws InterruptedException {
		selCoursePage = new appSelectCoursePage(driver);
		selCoursePage.clickEditBtn();
		selCoursePage.selCourse();
		selCoursePage.launchCourseinChrome();
	}
}
