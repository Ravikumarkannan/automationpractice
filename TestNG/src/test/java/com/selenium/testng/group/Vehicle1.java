package com.selenium.testng.group;

import org.testng.annotations.Test;

public class Vehicle1 {

	@Test(groups = "car")
	public void getFord() {
		System.out.println("ford");
	}

	@Test(groups = "bike")
	public void getBajaj() {
		System.out.println("bajaj");
	}

	@Test(groups = { "car", "bike" })
	public void getBMW() {
		System.out.println("BMW");
	}
	
	@Test
	public void getAuto() {
		System.out.println("auto");
	}
	
	@Test(groups = {"car", "bike"})
	public void getHonda(){
		System.out.println("honda");
	}
	
	@Test(groups = "car")
	public void getAudi() {
		System.out.println("audi");
	}
}
