package com.zoopla.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class ResultPage extends TestBase{
	
	@FindBy(xpath ="(//ul[@class='listing-results clearfix js-gtm-list']//a[@class='listing-results-price text-price'])[5]" )
	WebElement fifthPrice;
	
	
	public ResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	public List<WebElement> listOfprice()
	{
		 List<WebElement> listOfRates = driver.findElements(By.xpath("//a[contains(@class,'listing-results-price')]"));
		 System.out.println(listOfRates.size());
		 return listOfRates;
	}
	public ProperDetailsPage clickOnPrice()
	{
		fifthPrice.click();
		return new ProperDetailsPage();
	}

	
	
}
