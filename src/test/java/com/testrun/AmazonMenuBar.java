package com.testrun;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class AmazonMenuBar {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aliexpress.us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> menuBar = driver.findElements(By.xpath("//*[@class='pc2023-header-tab--tabs-main--2EOR-kL']//a"));
		System.out.println("menu bar total name = "+menuBar.size());
		SoftAssert sf = new SoftAssert();
		List<String> menuBar1 = new ArrayList<String>();
		for(int i=0;i<menuBar.size();i++) {
			System.out.println(menuBar.get(i).getText());
			menuBar1.add(menuBar.get(i).getText());
		}
		System.out.println("All value in my list = "+menuBar1);
		sf.assertTrue(menuBar1.contains("SuperDeals"));
		sf.assertTrue(!menuBar1.contains("City"));
		driver.quit();
		sf.assertAll();
	}
}
