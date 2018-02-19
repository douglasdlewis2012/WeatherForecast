package com.douglaslewis.weatherforecast.Application;

import android.app.Application;

import com.douglaslewis.weatherforecast.BuildConfig;
import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.squareup.leakcanary.LeakCanary;

import timber.log.Timber;

import static timber.log.Timber.DebugTree;


@SuppressWarnings("WeakerAccess")
public class ForecastApp extends Application {

	@Override
	public void onCreate () {
		super.onCreate ();

		if (BuildConfig.DEBUG) {
			Timber.plant (new DebugTree ());
			LeakCanary.install (this);
		}

		ApplicationController applicationController = new ApplicationController ();
		applicationController.setAppContext (getApplicationContext ());
		applicationController.loadSavedData ();

		Timber.e ("End Application onCreate");
	}
}
