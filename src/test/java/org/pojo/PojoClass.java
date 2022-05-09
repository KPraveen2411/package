package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass{
	
	public PojoClass() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindAll({
		
		@FindBy(id="search_bar_id"),
		@FindBy(xpath="(//input[@type='search'])"),
		@FindBy(xpath="(//input[@class='search-input'])")
		
	})
	private WebElement searchpath;
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="(//span[@role='button'])[3]"),
		@FindBy(xpath="(//button[@type='submit'])")
	})
	private WebElement click;
	
	@CacheLookup
	@FindBy(id="btnSign")
		
	private WebElement singin;
	
	@CacheLookup
	@FindBys({
		@FindBy(xpath="//a[text()='Register']"),
		@FindBy(xpath="//a[@class='register-nav-link primary full']")
	})
	private WebElement register;
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="//input[@type='email']"),
		@FindBy(xpath="(//input[@tabindex='0'])[1]")
	})
	private WebElement username;	
	
	@CacheLookup
	@FindAll({
		@FindBy(xpath="(//input[@tabindex='0'])[2]"),
		@FindBy(xpath="//input[@type='password']")
	})
	
	private WebElement password;
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="(//input[@type='text'])[1]"),
		@FindBy(xpath="(//input[@autocomplete='on'])[1]")
		
	})
	private WebElement loginusername;
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="//input[@type='password']"),
		@FindBy(xpath="(//input[@autocomplete='on'])[2]")
	})
	private WebElement loginpassword;
	
	@CacheLookup
	@FindAll({
		
		@FindBy(xpath="//button[@type='submit']"),
		@FindBy(xpath="//button[@class='primary full']")
	})
	private WebElement login;
	
	@CacheLookup
	@FindBy(xpath="//a[text()='ASDA Strawberry and Raspberry Shower Gel']")
	
	private WebElement produceclick;

	public WebElement getProduceclick() {
		return produceclick;
	}
	

	public WebElement getSingin() {
		return singin;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginusername() {
		return loginusername;
	}

	public WebElement getLoginpassword() {
		return loginpassword;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getSearchpath() {
		return searchpath;
	}

	public WebElement getClick() {
		return click;
	}

}
