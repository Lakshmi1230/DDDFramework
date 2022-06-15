package com.Vcentry.Lab.TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vcentry.lab.testBase.BaseClass;
import com.vcentry.lab.utils.Filehandlig;

public class AddNewUserTest extends BaseClass{
	
	@Test(priority = 2)
	public void navigatetousersinAdminTab() {
		homepage.navigateToUser();
	users.verifyUersPage();
		
	}
	
	@Test(dataProvider="NewUserData",priority = 3)
	public void addNewUser(String role,String userName,String status,String password,String empName) {
		users.clickAddButton();
		//users.addNewUsers(role, userName, status, password, empName);

}	
	@Test(dataProvider="NewUserData",priority = 4)
	public void addNewUser(String checkbox,String Delete,String Ok) {
		users.clickAddButton();
		//users.addNewUsers(checkbox,Delete,Ok) ;
	}
		

@DataProvider(name="NewUserData")
public Object[][] getLoginData() throws IOException{
return Filehandlig.getExcelData("src//test//resources//DataSheet.xlsx","newuser");

}}