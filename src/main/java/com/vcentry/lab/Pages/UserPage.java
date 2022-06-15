package com.vcentry.lab.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.vcentry.lab.testBase.BaseClass;

public class UserPage extends BaseClass{
	WebDriver driver;
	
	@FindBy(id="btnAdd")
	private WebElement addButton;
	
	@FindBy(id="systemUser_userType")
	private WebElement userType;
	
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement emp_Name;
	
	@FindBy(id="systemUser_userName")
	private WebElement empUserName;
	
	@FindBy(id="systemUser_status")
	private WebElement empStatus ;
	
	@FindBy(id="systemUser_password")
	private WebElement  empPassword;
	
	@FindBy(id="systemUser_confirmPassword")
	private WebElement  ConfirmPassword;
	
	@FindBy(id="btnSave")
	private WebElement  saveUser;
	
	@FindBy(id="ohrmList_chkSelectRecord_52")  
	private WebElement  checkbox ;
	
	@FindBy(id="btnDelete")
	private WebElement Delete ;
	
	@FindBy(id="dialogDeleteBtn")
	private WebElement  Ok;
  
	
	public UserPage(WebDriver driver)  {
		this.driver=driver;
		PageFactory.initElements(driver,this);	
			}
	public void clickAddButton() {
		addButton.click();
	}
	public void verifyUersPage (){
		validateTest(addButton.isDisplayed());
		}
	public void addNewUsers(String role,String userName,String status,String checkbox,String Delete,String Ok){
       try{
		selectVisibleText(role, userType);
       //emp_Name.sendKeys(empName);
       empUserName.sendKeys(userName);
       selectVisibleText(status, empStatus);
       //empPassword.sendKeys(password);
       //ConfirmPassword.sendKeys(password);
        saveUser.click();
        
    
        
       
       }catch (Exception e) {
		// TODO: handle exception
    	   System.out.println(e.getMessage());
	}
       
       
	
	}
 
  }



