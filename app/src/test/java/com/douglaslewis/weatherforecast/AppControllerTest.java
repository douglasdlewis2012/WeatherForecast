package com.douglaslewis.weatherforecast;

import android.test.suitebuilder.annotation.SmallTest;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.Singletons.ApplicationSingleton;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SmallTest
public class AppControllerTest {
	private WeatherMockContext wmc;

	@Before
	public void setup(){
		wmc = new WeatherMockContext ();
	}

	@Test (expected = IllegalStateException.class)
	public void checkNoContext(){
		ApplicationController applicationController = new ApplicationController ();
		applicationController.loadSavedData ();

	}

	@Test
	public void checkTitleExist(){
		ApplicationController applicationController = new ApplicationController ();
		applicationController.setAppContext (wmc);
		String d = ApplicationSingleton.getINSTANCE ().getString ("location");
		assertEquals (d, "Location: ");
	}

	@Test
	public void checkTitleNotExist(){
		String d = ApplicationSingleton.getINSTANCE ().getString ("-u-hj");
		assertEquals (d, "unknown");
	}

	@Test
	public void testLocation(){
		double lattitude = 12345;
		double longitude = 54321;

		ApplicationController applicationController = new ApplicationController ();
		applicationController.setLocation (lattitude,longitude);
		assertEquals (Double.valueOf (applicationController.getLattitude ()).intValue (), Double.valueOf (lattitude).intValue ());
		assertEquals (Double.valueOf (applicationController.getLongitude ()).intValue (), Double.valueOf (longitude).intValue ());
	}







}
