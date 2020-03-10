package com.atmecs.webtable.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.atmecs.webtable.dataallocator.LocatorDataAllocator;
import com.atmecs.webtable.helper.CommonHelpers;

public class IframeHelper {
	static LocatorDataAllocator loc = new LocatorDataAllocator();

	public static void switchToIframe(WebDriver driver) throws Exception {
		loc.getIframeLocatorData();
		CommonHelpers.clickElement(driver, loc.home);
		WebElement iframe = driver.findElement(By.xpath(loc.iframe));
		System.out.println("before"+iframe.getAttribute("src"));
		driver.switchTo().frame(iframe);
		System.out.println("after"+iframe.getAttribute("src"));
	}
}
