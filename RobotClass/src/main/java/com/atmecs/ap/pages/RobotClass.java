package com.atmecs.ap.pages;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import com.atmecs.ap.helpers.CommonHelpers;

public class RobotClass {
	
	static Robot robot;
	
	public static void mouseWheel() throws Exception {
		robot = new Robot();
		Thread.sleep(2000);
		robot.mouseWheel(5);
	}
	
	public static void clickFile() throws Exception {
		robot = new Robot();
		robot.mouseMove(340, 400);
		Thread.sleep(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public static void chooseFile() throws Exception {
		robot = new Robot();
		
		robot.mouseMove(45, 145);
		Thread.sleep(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.mouseMove(200, 282);
		Thread.sleep(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static void uploadFile(WebDriver driver,String send) {
		CommonHelpers.click(driver, send);
	}
}
