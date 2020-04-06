package com.testng.dataprovider;

import org.testng.annotations.DataProvider;

public class InvokeClass {

	@DataProvider(name = "provideCredentials")
	public static Object[][] provideCredentials() {

		Object[][] searchWords=new Object[2][2];
      	searchWords[0][0]="standard_user";
      	searchWords[0][1]="secret_sauce";
      	searchWords[1][0]="locked_out_user";
      	searchWords[1][1]="secret_sauce";
	  return searchWords;
	}
}
