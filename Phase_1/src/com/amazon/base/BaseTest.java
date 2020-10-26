package com.amazon.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pages.SearchPage;

public class BaseTest extends SearchPage {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","/home/srikanthaki182g/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(80,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		SearchPage s = PageFactory.initElements(driver, SearchPage.class);
		s.Search("TCL Tv");
		s.scope.click();
		s.TCL.click();
		s.LED.click();
		s.Distance.click();
		/*File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("/home/srikanthaki182g/git/Phase1/Phase_1/TV.png"));*/
		
		List <WebElement>  col = driver.findElements(By.xpath("//h2"));
        for(WebElement items: col ) {
        	System.out.println(items.getText());  
        }
	}

}
