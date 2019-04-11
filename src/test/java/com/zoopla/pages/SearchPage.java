package com.zoopla.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.base.TestBase;
import com.zoopla.util.Excel;

public class SearchPage extends TestBase{
	Excel exl;
	@FindBy(xpath ="//input[@id='search-input-location']")
	WebElement searchBox;
	
	@FindBy(id ="search-submit" )
	WebElement clickButton;
	
	public SearchPage()
	{	
		try 
		{
			exl = new Excel();
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		PageFactory.initElements(driver,this);;
	}
	
	public void enterLocationName()
	{
		
		searchBox.sendKeys(exl.getData("Sheet1", 0, 0));
	}
	public ResultPage clickSearchButton()
	{
		clickButton.click();
		return new ResultPage();
	}

}
