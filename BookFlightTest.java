package com.makemytrip.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.base.BaseClass;
import com.makemytrip.pages.BookFlight;

public class BookFlightTest extends BaseClass {
	BookFlight BookFlight;
	@BeforeMethod
	public void setup()
	{
		initialization();
		 BookFlight = new BookFlight();
	}
	
	@Test
	public void flightbooking() throws InterruptedException
	{
		BookFlight.CitySelection("Mumbai", "Delhi");
		BookFlight.DateSelection("25-Aug-2021");
		BookFlight.Search();
		BookFlight.SelectIndigo();
		BookFlight.PriceCheckBook();
	}

}
