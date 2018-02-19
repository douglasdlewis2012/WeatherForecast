package com.douglaslewis.weatherforecast.Networking;


import com.douglaslewis.weatherforecast.ForecastAPI.ForecastResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


interface ForecastService {
	//
	@GET("forecast/{api_key}/{lattitude},{longitude}")
	Observable<ForecastResponse> getForecast (
			@Path("api_key") String key,
			@Path("lattitude") String lat,
			@Path("longitude") String lon
	);

	@GET("forecast/{api_key}/{lattitude},{longitude}?&exclude=[minutely,hourly,daily,alerts,flags]")
	Observable<ForecastResponse> getCurrentForecast (
			@Path("api_key") String key,
			@Path("lattitude") String lat,
			@Path("longitude") String lon
	);
}
