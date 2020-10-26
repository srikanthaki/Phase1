package com.amazon.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.*;
import com.amazon.base.BaseTest;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SearchPage  {
	
	@FindBy(css="input#twotabsearchtextbox")
	public WebElement Search;
	
	@FindBy(css="input[value='Go']")
    public WebElement scope;
	
	@FindBy(xpath="//li[@id='p_89/TCL' and @aria-label='TCL']/span")
    public WebElement TCL;
	
	@FindBy(xpath="//li[@aria-label='LED']/span")
    public WebElement LED;
	
	@FindBy(xpath="//span[text()='8.1 to 10ft']")
	public WebElement Distance;
	
	
	
	public void Search(String text) {
		Search.sendKeys(text);
 
     } 	
	
    
}
