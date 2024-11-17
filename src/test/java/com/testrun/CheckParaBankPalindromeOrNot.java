package com.testrun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class CheckParaBankPalindromeOrNot {
	public void getPalindrome() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		driver.manage().window().maximize();
		//String titleName1 = driver.findElement(By.xpath("//*[@title='ParaBank']")).getText();
	    //System.out.println("My title : "+titleName1);
		String name = driver.findElement(By.xpath("//*[@title='ParaBank']")).getAttribute("title");
	    System.out.println("My title : "+name);
	    String rev_name = "";
		System.out.println("Before Reverse : "+name);
		for(int i=name.length()-1;i>=0;i--){
			//System.out.print(name.charAt(i));
			rev_name=rev_name+name.charAt(i);
		}
		System.out.println("After Reverse : "+rev_name);
		if(name.equals(rev_name))
			System.out.println(name+" is a palindrome.");
		else
			System.out.println(name+" is not a palindrome.");
		SoftAssert sf = new SoftAssert();
		sf.assertFalse(name.equals(rev_name));
		driver.quit();
		sf.assertAll();
	}
	public static void main(String[] args) {
		CheckParaBankPalindromeOrNot obj = new CheckParaBankPalindromeOrNot();
		obj.getPalindrome();
	}
}
