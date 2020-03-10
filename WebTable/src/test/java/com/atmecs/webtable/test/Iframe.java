package com.atmecs.webtable.test;

import org.testng.annotations.Test;

import com.atmecs.webtable.pages.IframeHelper;
import com.atmecs.webtable.testsuite.BaseClass;

public class Iframe extends BaseClass {
	
	@Test
	public void switchToIframe() throws Exception {
		IframeHelper.switchToIframe(driver);
	}
}
