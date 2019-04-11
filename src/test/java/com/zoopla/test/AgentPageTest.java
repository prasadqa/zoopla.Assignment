package com.zoopla.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;
import com.zoopla.base.TestBase;
import com.zoopla.pages.AgentPage;
import com.zoopla.pages.ProperDetailsPage;
import com.zoopla.pages.ResultPage;
import com.zoopla.pages.SearchPage;

public class AgentPageTest extends TestBase{
	
	SearchPage searchPage;
	ProperDetailsPage properDetailsPage;
	AgentPage agentPage;
	ResultPage resultPage;
	
	public AgentPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		searchPage = new SearchPage();
		properDetailsPage = new ProperDetailsPage();
		agentPage = new AgentPage();
		resultPage = new ResultPage();
		searchPage.enterLocationName();
		searchPage.clickSearchButton();
		
	}
	
	@Test
	public void printPriceList()
	{
		List<WebElement> ListOfprice = resultPage.listOfprice();
		System.out.println(ListOfprice.size());
		int pricesList[] = new int[ListOfprice.size()];
		//ArrayList<Integer> pricesList = new ArrayList<Integer>();
		for (int i=0;i<ListOfprice.size();i++) 
		{
			String prices = ListOfprice.get(i).getText();
			@SuppressWarnings("deprecation")
			String rate = CharMatcher.digit().retainFrom(prices);
			try {
				pricesList[i] = Integer.parseInt(rate);
			} catch (Exception e) {
				pricesList[i] = 0;
			}
		}
		int temp;
		for (int i = 0; i < pricesList.length; i++) {
			for (int j = i+1; j < pricesList.length; j++) {
				if (pricesList[i]<pricesList[j]) 
				{
					temp = pricesList[i];
					pricesList[i]=pricesList[j];
					pricesList[j]= temp;
				}
			}
		}
		System.out.println(" Prices in Descending order");
		for (int i = 0; i < pricesList.length; i++) 
		{
			System.out.println(pricesList[i]);
		}
	}
	@Test
	public void varifyAgentName()
	{
		resultPage.clickOnPrice();
		String expAgtName = properDetailsPage.storeAgentName();
		properDetailsPage.clickAgentName();
		String actAgtName = agentPage.storeAgentName();
		Assert.assertEquals(expAgtName, actAgtName);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
