package com.Vcentry.Lab.TestCases;

import java.io.IOException;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.lab.testBase.BaseClass;
import com.vcentry.lab.utils.Filehandlig;

public class LoginTest extends BaseClass{
	
	
	@Test(dataProvider = "loginData",priority=1)
	public void login(String uName,String pwd){
		try{
		loginPage.enterUsername(uName);
		loginPage.enterPassword(pwd);
		loginPage.clickLogin();
		if(uName.equals("Admin")&&pwd.equals("admin123")){
    	 validateTest(driver.getCurrentUrl().contains("dashboard"));
    	 }
         }catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	@DataProvider(name="loginData")
	public Object[][] getLoginData() throws IOException{
	return Filehandlig.getExcelData("src//test//resources//DataSheet.xlsx","login");

}}
