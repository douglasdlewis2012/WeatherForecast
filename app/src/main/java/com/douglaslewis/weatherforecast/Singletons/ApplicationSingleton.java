package com.douglaslewis.weatherforecast.Singletons;

import android.os.Build;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.ForecastAPI.ForecastResponse;
import com.douglaslewis.weatherforecast.R;

import java.util.HashMap;
import java.util.Map;

public final class ApplicationSingleton {
	/*
	Do not use Singleton, go through Controller
	 */

	private final static ApplicationSingleton INSTANCE = new ApplicationSingleton ();
	private final String CELSIUS_DEGREE_SYMBOL = "°C";
	@SuppressWarnings("FieldCanBeLocal")
	private final String FAHREINHEIT_DEGREE_SYMBOL = "°F";
	private final String DEGREE_SYMBOL = "°";
	private Map<String, Integer> mImagesMap;
	private Map<String, String> mTitlesMap;


	private int OS_VERSION = Build.VERSION.SDK_INT;
	private ForecastResponse mDeserializedJSON;
	private double lattitude;
	private double longitude;


	private ApplicationSingleton () {
		setupImagesMap ();
		setupTitlesMap ();
	}

	public static ApplicationSingleton getINSTANCE () {
		return INSTANCE;
	}

	private void setupImagesMap () {
		mImagesMap = new HashMap<> ();

		mImagesMap.put ("clear-day", R.drawable.sunnycardicon);
		mImagesMap.put ("clear-night", R.drawable.nightcardicon);
		mImagesMap.put ("rain", R.drawable.cloudyraincardicon);
		mImagesMap.put ("snow", R.drawable.cloudysnowcardicon);
		mImagesMap.put ("sleet", R.drawable.cloudysnowraincardicon);
		mImagesMap.put ("wind", R.drawable.windcardicon);
		mImagesMap.put ("cloudy", R.drawable.cloudcardicon);
		mImagesMap.put ("partly-cloudy-night", R.drawable.partlycloudynighticon);
		mImagesMap.put ("partly-cloudy-day", R.drawable.partlycloudycardicon);
		mImagesMap.put ("network_error", R.drawable.error);
		mImagesMap.put ("default", R.drawable.questionmarkicon);
	}

	private void setupTitlesMap () {
		mTitlesMap = new HashMap<> ();

		mTitlesMap.put ("clear-day", ApplicationController.getResources ().getString (R.string.clear_day));
		mTitlesMap.put ("clear-night", ApplicationController.getResources ().getString (R.string.clear_night));
		mTitlesMap.put ("rain", ApplicationController.getResources ().getString (R.string.rain));
		mTitlesMap.put ("snow", ApplicationController.getResources ().getString (R.string.snow));
		mTitlesMap.put ("sleet", ApplicationController.getResources ().getString (R.string.sleet));
		mTitlesMap.put ("wind", ApplicationController.getResources ().getString (R.string.wind));
		mTitlesMap.put ("cloudy", ApplicationController.getResources ().getString (R.string.cloudy));
		mTitlesMap.put ("partly-cloudy-night", ApplicationController.getResources ().getString (R.string.partly_cloudy_night));
		mTitlesMap.put ("partly-cloudy-day", ApplicationController.getResources ().getString (R.string.partly_cloud_day));
		mTitlesMap.put ("high", ApplicationController.getResources ().getString (R.string.high));
		mTitlesMap.put ("low", ApplicationController.getResources ().getString (R.string.low));
		mTitlesMap.put ("default", ApplicationController.getResources ().getString (R.string.def));
		mTitlesMap.put ("network_error", ApplicationController.getResources ().getString (R.string.network_error));
		mTitlesMap.put ("no_network", ApplicationController.getResources ().getString (R.string.no_network));
		mTitlesMap.put ("temperature", ApplicationController.getResources ().getString (R.string.temperature));
		mTitlesMap.put ("location", ApplicationController.getResources ().getString (R.string.location));

	}

	public String getString (String name) {
		String weatherType = mTitlesMap.get (name);
		if (weatherType != null)
			return weatherType;

		return mTitlesMap.get ("default");
	}

	public Integer getImage (String imageName) {
		Integer location = mImagesMap.get (imageName);
		if (location != null)
			return location;

		return mImagesMap.get ("default");
	}

	public void setLatLong (double lat, double lon) {
		this.lattitude = lat;
		this.longitude = lon;
	}

	public double getLattitude () {
		return this.lattitude;
	}

	public double getLongitude () {
		return this.longitude;
	}

	public void setDeserializedJSON (ForecastResponse forecast) {
		mDeserializedJSON = forecast;
	}

	public ForecastResponse getJSON () {
		return mDeserializedJSON;
	}

	public String getFahreinheitSymbol () {
		return FAHREINHEIT_DEGREE_SYMBOL;
	}

}
