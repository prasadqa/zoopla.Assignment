package com.zoopla.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;

public class ProperDetailsPage extends TestBase{
	
	@FindBy(xpath ="(//h4[@class='ui-agent__name'])[1]")
	WebElement agentName;
	
	public ProperDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String storeAgentName()
	{
		return agentName.getText();
	}
	public AgentPage clickAgentName()
	{
		
		agentName.click();
		return new AgentPage();
	}

}
