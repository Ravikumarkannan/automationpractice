package com.selenium.testng.group;

import org.testng.annotations.Test;

public class Vehicle2 {

	@Test(groups = "car")
	public void getFerrari() {
		System.out.println("ferrari");
	}
	
	@Test(groups = "bike")
	public void getTvs() {
		System.out.println("tvs");
	}
	
	@Test(groups = "car")
	public void getToyota() {
		System.out.println("Toyota");
	}

}
