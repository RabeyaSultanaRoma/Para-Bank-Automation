package com.testrun;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class CoscoMenuBar {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.costco.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> menuBar = driver.findElements(By.xpath("//*[@class='MuiBox-root mui-1nzpdry']//a"));
		System.out.println("menu bar total name = "+menuBar.size());
		SoftAssert sf = new SoftAssert();
		/*for(int i=0;i<menuBar.size();i++) {
			System.out.println(menuBar.get(i).getText());
			if(menuBar.get(i).getText().contains("Pharmacy")) {
				System.out.println("Test passed: found pharmacy");
				sf.assertTrue(menuBar.get(i).getText().contains("Pharmacy"));
			}
			if(!menuBar.get(i).getText().contains("City")) {
				System.out.println("Test passed: not found city");
				sf.assertTrue(!menuBar.get(i).getText().contains("City"));
			}
		}*/
		//another way
		List<String> menuBar1 = new ArrayList<String>();
		for(int i=0;i<menuBar.size();i++) {
			System.out.println(menuBar.get(i).getText());
			menuBar1.add(menuBar.get(i).getText());
		}
		System.out.println("All value in my list = "+menuBar1);
		sf.assertTrue(menuBar1.contains("Pharmacy"));
		sf.assertTrue(!menuBar1.contains("City"));
		driver.quit();
		sf.assertAll();
	}
}
