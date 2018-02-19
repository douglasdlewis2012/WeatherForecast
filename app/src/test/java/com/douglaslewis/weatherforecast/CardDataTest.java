package com.douglaslewis.weatherforecast;


import android.test.suitebuilder.annotation.SmallTest;

import com.douglaslewis.weatherforecast.DataModels.CardData;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@SmallTest
public class CardDataTest {


	@Test
	public void cardNotNull () {
		Date d = new Date ();
		CardData cardData = new CardData.CardBuilder (d.toString ()).createCardData ();

		assertEquals (cardData.getDate (), d.toString ());
		assertEquals (cardData.getIcon (), " ");
		assertEquals (cardData.getHighTemp (), Integer.valueOf (0));
		assertEquals (cardData.getWeatherType (), " ");
		assertEquals (cardData.getLowTemp (), Integer.valueOf (0));
		assertEquals (cardData.getTemperature (), Integer.valueOf (0));
	}


	@Test
	public void cardValuesCorrect () {
		Integer highTemp = 2;
		Integer lowTemp = 5;
		String icon = "bird";
		String weather = "cloudy";
		Integer temp = 45;

		Date d = new Date ();

		CardData cardData = new CardData.CardBuilder (d.toString ())
				.highTemperature (highTemp).lowTemperature (lowTemp)
				.temperature (temp).weatherType (weather)
				.icon (icon)
				.createCardData ();

		assertEquals (cardData.getDate (), d.toString ());
		assertEquals (cardData.getIcon (), icon);
		assertEquals (cardData.getHighTemp (), highTemp);
		assertEquals (cardData.getWeatherType (), weather);
		assertEquals (cardData.getLowTemp (), lowTemp);
		assertEquals (cardData.getTemperature (), temp);

	}

}
