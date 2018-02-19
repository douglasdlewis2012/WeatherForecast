package com.douglaslewis.weatherforecast;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.test.mock.MockContext;
import android.test.mock.MockResources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


class WeatherMockContext extends MockContext {

	@Override
	public Resources getResources () {
		return new WeatherMockResources ();
	}

	@SuppressWarnings("EmptyMethod")
	@Override
	public FileInputStream openFileInput (String name) throws FileNotFoundException {
		return super.openFileInput (name);

	}


	private class WeatherMockResources extends MockResources {


		@NonNull
		@Override
		public String getString (int id) throws NotFoundException {

			switch (id) {
				case R.string.clear_day:
					return "Sunny";
				case R.string.clear_night:
					return "Clear";
				case R.string.rain:
					return "Rain";
				case R.string.snow:
					return "Snow";
				case R.string.sleet:
					return "Sleet";
				case R.string.wind:
					return "Windy";
				case R.string.cloudy:
					return "Cloudy";
				case R.string.partly_cloudy_night:
					return "Cloudy Night";
				case R.string.high:
					return "High:";
				case R.string.low:
					return "Low:";
				case R.string.def:
					return "unknown";
				case R.string.partly_cloud_day:
					return "Cloudy Day";
				case R.string.network_error:
					return "Network Error";
				case R.string.no_network:
					return "We're sorry, no network connection.";
				case R.string.temperature:
					return "Current:";
				case R.string.location:
					return "Location: ";
				case R.string.unknown:
					return "?";
				case R.string.retry:
					return "Retry";
				case R.string.cancel:
					return "Cancel";
				case R.string.weather_forecast:
					return "weather type";
				case R.string.quick_card_seperator:
					return "|";
				case R.string.title_activity_main:
					return "WeatherForecast";
				case R.string.app_name:
					return "WeatherForecast";
				default:
					return "huh";

			}
		}
	}

}
