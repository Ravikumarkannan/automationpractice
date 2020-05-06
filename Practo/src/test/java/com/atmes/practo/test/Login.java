package com.atmes.practo.test;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.practo.constants.FilePath;
import com.atmecs.practo.pages.LoginPage;
import com.atmecs.practo.testbase.TestBase;
import com.atmecs.practo.utils.PropertyReader;

public class Login extends TestBase {

	@Test
	@Parameters({ "userEmail", "password" })
	public void login(String userEmail, String password) throws IOException {
		Properties path = PropertyReader.readProperty(FilePath.LOCATOR_FILE);

		LoginPage.navigateToLogin(driver, path.getProperty("dropdown"), path.getProperty("login"));
		LoginPage.login(driver, path.getProperty("email"), path.getProperty("password"), userEmail, password,path.getProperty("loginbtn"));
		
		LoginPage.getCookies(driver);

	}
}
