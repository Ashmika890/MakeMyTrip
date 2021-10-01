package com.makemytrip.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.base.BaseClass;

public class BookFlight extends BaseClass{
	@FindBy(xpath="//div[@class='fsw_inner']/div/label/span/following-sibling::input[1][@id='fromCity']")
	WebElement FromCity;
	@FindBy(xpath="//div[@class='fsw_inner']/div/label/span/following-sibling::input[1][@id='toCity']")
	WebElement ToCity;
	@FindBy(xpath="//span[@class='lbl_input latoBold appendBottom10' and text()='DEPARTURE']")
	WebElement DepartureDate;
	@FindBy(xpath="//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and text()='Search']")
	WebElement Search;
	@FindBy(xpath="//div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[3]/div[1]/span[1]/span[1]")
	WebElement IndigoSelect;
	@FindBy(xpath="//span[@class='appendRight8' and text()='View Prices']")
	WebElement ViewPrice;
	
	
	public BookFlight()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void CitySelection(String FromCityName, String ToCityName) throws InterruptedException
	{
		
				
		Thread.sleep(1000);
		FromCity.click();
		
		Select select1=new Select(FromCity);
		select1.selectByVisibleText(FromCityName);
		ToCity.click();
		Select select2=new Select(ToCity);
		select2.selectByVisibleText(ToCityName);
		
	}
	
	public void DateSelection(String date1) {
		DepartureDate.click();
		DepartureDate.sendKeys(date1);
	}
	
	public void Search()
	{
		Search.click();
		driver.switchTo().alert().dismiss();
	}
	
	public void SelectIndigo()
	{
		IndigoSelect.click();
	}
	
	public void PriceCheckBook() throws InterruptedException
	{
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='priceSection']"));
		
		ArrayList<Integer> prices=new ArrayList<Integer>();
		for(int i=0;i<price.size();i++){
		Integer priceInt = Integer.valueOf(price.get(i).getText().replace(",", ""));
		prices.add(priceInt);
		
		Integer minPrice=2000;
		List<WebElement> allBook = driver.findElements(By.xpath("//div[@class='priceSection']"));
		Thread.sleep(3000);
		for(int j=0;j<allBook.size();j++){
		Integer priceInt1 = Integer.valueOf(price.get(i).getText().replace(",", ""));
		if(priceInt1>=minPrice){
		allBook.get(i).click();
		break;
		}
		}
	}
	}
}
