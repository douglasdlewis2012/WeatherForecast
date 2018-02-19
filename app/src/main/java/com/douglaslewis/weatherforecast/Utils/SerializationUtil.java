package com.douglaslewis.weatherforecast.Utils;

import android.content.Context;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.ForecastAPI.ForecastResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import timber.log.Timber;


public final class SerializationUtil {
	private static final String SAVE_FILE = "datamodel.ser";
	private final ApplicationController mApplicationController = new ApplicationController ();

	public void saveObject (ForecastResponse d) {

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream (mApplicationController.getAppContext ().openFileOutput (SAVE_FILE, Context.MODE_PRIVATE));
			objectOutputStream.writeObject (d);
			objectOutputStream.flush ();
			objectOutputStream.close ();
		} catch (IOException e) {
			e.printStackTrace ();
			Timber.e ("Exception saving file");

		}

	}


	public Object loadDataModelObject () {
		// The JDK7+ mechanism of try-with-resources is so much cleaner.
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream (mApplicationController.getAppContext ().openFileInput (SAVE_FILE));

			return objectInputStream.readObject ();

		} catch (IOException e) {
			Timber.e ("Exception from trying to load file that doesn't exist");
		} catch (ClassNotFoundException e) {
			e.printStackTrace ();
			Timber.e ("CallsNotFound");
		} finally {
			try {
				if (objectInputStream != null)
					objectInputStream.close ();
			} catch (IOException e) {
				e.printStackTrace ();
				Timber.e ("IOException closing file");
			}
		}
		return null;
	}
}