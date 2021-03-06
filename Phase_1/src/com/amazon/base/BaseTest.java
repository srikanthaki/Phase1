package com.amazon.base;

import java.io.File;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.pages.SearchPage;

public class BaseTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/home/srikanthaki182g/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		SearchPage s = PageFactory.initElements(driver, SearchPage.class);
		s.Search("TCL Tv");
		s.scope.click();
		s.TCL.click();
		s.LED.click();
		s.Distance.click();
		ArrayList<WebElement> col = (ArrayList<WebElement>) driver.findElements(By.xpath("//h2"));

		Iterator<WebElement> itr = col.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src,new
		  File("/home/srikanthaki182g/git/Phase1/Phase_1/TV.png"));
	}

}
