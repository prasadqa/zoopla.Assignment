package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class AgentPage extends TestBase{
	
	@FindBy(css ="div#content>div>h1>b")
	WebElement agentName;
	
	public AgentPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String storeAgentName()
	{
		return agentName.getText();
	}
	

}
