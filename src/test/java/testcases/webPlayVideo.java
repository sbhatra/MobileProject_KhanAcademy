package testcases;

import org.testng.annotations.Test;

import pageobject.HybridCapability;
import pageobject.webPlayVideoPage;

public class webPlayVideo extends HybridCapability {

	webPlayVideoPage playVid;
	
	@Test
	public void playVideo() throws InterruptedException {
		playVid=new webPlayVideoPage(driver);
		playVid.startVideo();
		//playVid.stopVideo();
	}
	
}
