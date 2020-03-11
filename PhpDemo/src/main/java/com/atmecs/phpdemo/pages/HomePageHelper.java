package com.atmecs.phpdemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.phpdemo.constants.Locators;
import com.atmecs.phpdemo.dataallocator.LocatorDataAllocator;
import com.atmecs.phpdemo.dataallocator.ValidationDataAllocator;
import com.atmecs.phpdemo.helpers.CommonHelper;
import com.atmecs.phpdemo.helpers.PageActions;
import com.atmecs.phpdemo.helpers.ValidationHelper;

public class HomePageHelper {

	static LocatorDataAllocator loc = new LocatorDataAllocator();
	static ValidationDataAllocator val = new ValidationDataAllocator();

	public static void homePageValidation(WebDriver driver) throws Exception {
		loc.getHomePageProperty();
		val.geValidationProperty();
		List<WebElement> elements = CommonHelper.findElements(driver, loc.main_menu);

		// logo validation
		ValidationHelper.validateImage(CommonHelper.findElement(driver, Locators.XPATH, loc.php_logo));

		// Mainmenu validation
		ValidationHelper.validateText(elements.get(0), val.demo);
		ValidationHelper.validateText(elements.get(1), val.pricing);
		ValidationHelper.validateText(elements.get(2), val.features);
		ValidationHelper.validateText(elements.get(3), val.products);
		ValidationHelper.validateText(elements.get(4), val.documents);
		ValidationHelper.validateText(elements.get(5), val.hosting);
		ValidationHelper.validateText(elements.get(6), val.company);
		ValidationHelper.validateText(elements.get(7), val.login);

		// Image validation
		ValidationHelper.validateImage(CommonHelper.findElement(driver, Locators.XPATH, loc.img_home));
		ValidationHelper.validateImage(CommonHelper.findElement(driver, Locators.XPATH, loc.img_admin1));
		ValidationHelper.validateImage(CommonHelper.findElement(driver, Locators.XPATH, loc.img_admin2));

		// iframe validation
		driver.findElement(By.xpath("//img[@alt='Livechat Support']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='chat-widget']")));	
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("ravi");
		CommonHelper.clickElement(driver, CommonHelper.findElement(driver, Locators.XPATH, loc.openMenu));
		ValidationHelper.validateButton(CommonHelper.findElement(driver, Locators.XPATH, loc.openMenu_mute));
		CommonHelper.clickElement(driver, CommonHelper.findElement(driver, Locators.XPATH, loc.openMenu_mute));
		ValidationHelper.validateButton(CommonHelper.findElement(driver, Locators.XPATH, loc.openMenu_mute));
		PageActions.dropDown(driver, loc.dropdown_choose, loc.dropdown_yes, "select");
		CommonHelper.clickElement(driver, CommonHelper.findElement(driver, Locators.XPATH, loc.openMenu_minimize));
		
		
	}
}
