package com.douglaslewis.weatherforecast.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;

import timber.log.Timber;

public final class LocationHelper {
	private final static ApplicationController mApplicationController = new ApplicationController ();
	private static LocationManager manager;

	public LocationHelper () {
		throw new IllegalStateException ("No Instances, use the class");
	}


	private static void getGPSCoordinates () {

		if (Build.VERSION.SDK_INT >= 23 &&
				ContextCompat.checkSelfPermission (mApplicationController.getAppContext (), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			return;
		}

		manager.requestLocationUpdates (LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		manager.requestLocationUpdates (LocationManager.GPS_PROVIDER, 0, 0, locationListener);

		Location location = manager.getLastKnownLocation (LocationManager.PASSIVE_PROVIDER);

		if (location != null) {
			mApplicationController.setLocation (location.getLatitude (), location.getLongitude ());
		}
	}


	public static Intent setupGPS () {
		manager = (LocationManager) mApplicationController.getAppContext ().getSystemService (Context.LOCATION_SERVICE);
		boolean isGPSEnabled = manager.isProviderEnabled (LocationManager.GPS_PROVIDER);

		if (!isGPSEnabled) {
			return new Intent (Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		} else {

			getGPSCoordinates ();
		}
		return null;
	}

	private static final LocationListener locationListener = new LocationListener () {
		public void onLocationChanged (Location location) {
			// Called when a new location is found by the network location provider.

			mApplicationController.setLocation (location.getLatitude (), location.getLongitude ());
			Timber.d ("New Location" + location.getLongitude () + location.getLatitude ());

			try {
				manager.removeUpdates (locationListener);
			}catch(SecurityException e){
				Timber.wtf ("Should never happen, explicitly check for permission prior to calling method");
			}
		}

		public void onStatusChanged (String provider, int status, Bundle extras) {
		}

		public void onProviderEnabled (String provider) {
		}

		public void onProviderDisabled (String provider) {
		}
	};


}
