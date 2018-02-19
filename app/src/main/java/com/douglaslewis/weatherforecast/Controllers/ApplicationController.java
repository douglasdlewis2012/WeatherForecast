package com.douglaslewis.weatherforecast.Controllers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;

import com.douglaslewis.weatherforecast.DataModels.CardData;
import com.douglaslewis.weatherforecast.ForecastAPI.Currently;
import com.douglaslewis.weatherforecast.ForecastAPI.Daily;
import com.douglaslewis.weatherforecast.ForecastAPI.Datum_;
import com.douglaslewis.weatherforecast.ForecastAPI.Datum__;
import com.douglaslewis.weatherforecast.ForecastAPI.ForecastResponse;
import com.douglaslewis.weatherforecast.ForecastAPI.Hourly;
import com.douglaslewis.weatherforecast.Networking.APIManager;
import com.douglaslewis.weatherforecast.Singletons.ApplicationSingleton;
import com.douglaslewis.weatherforecast.Utils.DateHelper;
import com.douglaslewis.weatherforecast.Utils.LocationHelper;
import com.douglaslewis.weatherforecast.Utils.SerializationUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import timber.log.Timber;

public final class ApplicationController implements APIManager.NetworkResponseCallback {
	/* All classes must go through ApplicationController, do not use the Singleton.  */
	private static Context mAppContext;
	private static APIManager sAPIManager;
	private static DataFinished mDataFinishedListener;

	public ApplicationController () {
	}


	public ApplicationController (DataFinished listener) {
		mDataFinishedListener = listener;
	}

	public static Resources getResources () {
		return mAppContext.getResources ();
	}

	public static void loadIconInto (ImageView image, String imageStr, Object tag) {

		Integer which = ApplicationSingleton.getINSTANCE ().getImage (imageStr);
		Picasso.with (mAppContext).load (which).resize (75, 75).tag (tag).into (image, new Callback () {
			@Override
			public void onSuccess () {
				Timber.e ("On Success");
			}

			@Override
			public void onError () {
				Timber.e ("Error loading image");
			}
		});
	}

	public Integer getImage(String id){
		return  ApplicationSingleton.getINSTANCE ().getImage (id);
	}

	public static void stopImageLoading (Object tag) {
		Picasso.with (mAppContext).cancelTag (tag);
	}

	public Context getAppContext () {
		if (mAppContext == null)
			throw new IllegalStateException ("need setAppContext(context) first");

		return mAppContext;
	}

	public void setAppContext (Context context) {
		mAppContext = context;
	}


	private void setupJSON (ForecastResponse forecast) {
		ApplicationSingleton.getINSTANCE ().setDeserializedJSON (forecast);
	}

	public void makeNetworkCall () {
		if (sAPIManager == null)
			sAPIManager = new APIManager (this);

		sAPIManager.makeNetworkCall ();
	}

	@Override
	public void onNetworkResponse (ForecastResponse forecast) {
		setupJSON (forecast);
		if (mDataFinishedListener != null)
			mDataFinishedListener.onDataLoaded (cardDataFromResponse (forecast), graphDataFromResponse (forecast), titleDataFromResponse (forecast), currentWeatherTypeFromResponse (forecast));

	}

	private List<CardData> cardDataFromResponse (ForecastResponse response) {
		List<CardData> cardData = new ArrayList<> ();

		if (response != null) {
			Date date = new Date ();

			Daily d = response.getDaily ();
			List<Datum__> data = d.getData ();
			for (int i = 0; i < data.size (); i++) {
				Datum__ dayData = data.get (i);
				Integer high = dayData.getTemperatureMax ().intValue ();
				Integer low = dayData.getTemperatureMin ().intValue ();
				String icon = dayData.getIcon ();

				String tempDate = DateHelper.getShortDayAndMonthPlus (date, i);

				CardData card = new CardData.CardBuilder (tempDate)
						.icon (icon)
						.highTemperature (high)
						.weatherType (ApplicationSingleton.getINSTANCE ().getString (icon))
						.lowTemperature (low)
						.createCardData ();

				cardData.add (card);
			}
		}

		return cardData;
	}

	private int[] graphDataFromResponse (ForecastResponse response) {
		int[] retHours = null;

		if (response != null) {
			Hourly hours = response.getHourly ();
			List<Datum_> hourly = hours.getData ();
			retHours = new int[hourly.size ()];
			for (int i = 0; i < hourly.size (); i++) {
				retHours[i] = hourly.get (i).getApparentTemperature ().intValue ();
			}

		}

		return retHours;
	}

	private String titleDataFromResponse(ForecastResponse response){
		String currentTemperature = null;

		if(response != null){
			Currently current = response.getCurrently ();
			currentTemperature = "" + current.getTemperature ().intValue ();
		}
		return currentTemperature;
	}

	private String currentWeatherTypeFromResponse(ForecastResponse response){
		String type = null;

		if(response != null){
			Currently current = response.getCurrently ();
			type = current.getIcon ();
		}
		return type;
	}

	public String getString (String id) {
		return ApplicationSingleton.getINSTANCE ().getString (id);
	}

	@Override
	public void onNetworkError () {
		if (mDataFinishedListener != null)
			mDataFinishedListener.onNetworkError ();
	}

	public boolean testNetwork () {
		return testNetworkUP ();
	}

	private boolean testNetworkUP () {
		ConnectivityManager cm =
				(ConnectivityManager) mAppContext.getSystemService (Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo ();

		return activeNetwork != null &&
				activeNetwork.isConnectedOrConnecting ();
	}

	public Intent setupGPS () {
		return LocationHelper.setupGPS ();
	}

	public void setLocation (double lat, double lon) {
		ApplicationSingleton.getINSTANCE ().setLatLong (lat, lon);
	}

	public double getLattitude () {
		return ApplicationSingleton.getINSTANCE ().getLattitude ();
	}

	public double getLongitude () {
		return ApplicationSingleton.getINSTANCE ().getLongitude ();
	}

	public void loadSavedData () {
		//Intentionally synchronous, if there is data always want it loaded before user gets to activity
		SerializationUtil util = new SerializationUtil ();
		Object o = util.loadDataModelObject ();
		if (o != null) setupJSON ((ForecastResponse) o);
	}

	public void saveResponse (ForecastResponse response) {
		//This is only ever called from a thread other than main.
		SerializationUtil util = new SerializationUtil ();
		util.saveObject (response);
	}

	public int[] getLoadedGraphData () {
		int[] response = graphDataFromResponse (ApplicationSingleton.getINSTANCE ().getJSON ());
		return response == null ? new int[]{1, 1, 1, 1} : response;
	}

	public List<CardData> getLoadedCardData () {
		return cardDataFromResponse (ApplicationSingleton.getINSTANCE ().getJSON ());
	}

	public String getLoadedCurrentWeatherType(){
		return   currentWeatherTypeFromResponse  (ApplicationSingleton.getINSTANCE ().getJSON ());

	}

	public String getLoadedCurrentWeatherTemperature(){
		String response =  titleDataFromResponse(ApplicationSingleton.getINSTANCE ().getJSON ());


		return response != null? response : " ";
	}

	public String getFahreinheitSymbol () {
		return ApplicationSingleton.getINSTANCE ().getFahreinheitSymbol ();
	}

	public String formatTemperature (String temp) {
		return getString ("temperature") + temp + ApplicationSingleton.getINSTANCE ().getFahreinheitSymbol ();
	}

	public interface DataFinished {
		void onDataLoaded (List<CardData> cardData, int[] graphData, String currentTemperature, String type);

		void onNetworkError ();
	}

	public void unregisterDataFinishedListener(){
		mDataFinishedListener = null;
	}

	public void registerDataFinishedListener(DataFinished dataFinishedListener){
		mDataFinishedListener = dataFinishedListener;
	}

}

