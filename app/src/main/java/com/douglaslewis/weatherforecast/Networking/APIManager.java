package com.douglaslewis.weatherforecast.Networking;


import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.ForecastAPI.ForecastResponse;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class APIManager {
	private final String LATITUDE;
	private final String LONGITUDE;
	private final ApplicationController mController = new ApplicationController ();

	private final NetworkResponseCallback mResponseCallback;

	public APIManager (NetworkResponseCallback callback) {
		mResponseCallback = callback;
		LATITUDE = String.valueOf (mController.getLattitude ());
		LONGITUDE = String.valueOf (mController.getLongitude ());

	}

	public final void makeNetworkCall () {

		String BACKEND_URL = "https://api.forecast.io/";
		Retrofit restAdapter = new Retrofit.Builder ()
				.baseUrl (BACKEND_URL)
				.addConverterFactory (GsonConverterFactory.create ())

				.addCallAdapterFactory (RxJavaCallAdapterFactory.create ())
				.build ();

		ForecastService forecastService = restAdapter.create (ForecastService.class);

		//Should be saving the subscription and canceling if no longer valid, but
		// you always want the network call to finish.  So always allow the call to finish and save its data.

		String APIKEY = "203bf0976335ed98863b556ed9f61f79";
		Observable<ForecastResponse> call = forecastService.getForecast (APIKEY, LATITUDE, LONGITUDE);
		@SuppressWarnings("UnusedAssignment") Subscription subscription = call.subscribeOn (Schedulers.io ())
				.observeOn (AndroidSchedulers.mainThread ())
				.doOnNext (new Action1<ForecastResponse> () {
					@Override
					public void call (ForecastResponse response) {
						if (response != null) {
							Observable.just (response)
									.subscribeOn (Schedulers.io ())
									.doOnNext (new Action1<ForecastResponse> () {
										@Override
										public void call (ForecastResponse response) {
											Date d = new Date();
											response.setJsonDownloadDate (d);
											mController.saveResponse (response);
											Timber.d ("finished saving data");
										}
									}).subscribe ();
						}
					}
				})
				.subscribe (new Subscriber<ForecastResponse> () {
					@Override
					public void onCompleted () {
						Timber.d ("OnCompleted");
					}

					@Override
					public void onError (Throwable e) {
						Timber.e ("Error on network call");

						mResponseCallback.onNetworkError ();
						if (e instanceof HttpException) {
							HttpException response = (HttpException) e;
							int code = response.code ();
							Timber.e (e.toString ());
							Timber.e ("Oncreate", Integer.toString (code));
						}

					}

					@Override
					public void onNext (ForecastResponse forecast) {
						mResponseCallback.onNetworkResponse (forecast);
						Timber.d ("got the data");
					}
				});

	}

	public interface NetworkResponseCallback {
		void onNetworkResponse (ForecastResponse forecast);

		void onNetworkError ();
	}

}
