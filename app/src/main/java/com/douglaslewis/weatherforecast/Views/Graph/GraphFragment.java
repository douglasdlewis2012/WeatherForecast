package com.douglaslewis.weatherforecast.Views.Graph;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.R;

import timber.log.Timber;

public class GraphFragment extends Fragment {
	private WeatherLineGraphView mGraphView;
	@SuppressWarnings("FieldCanBeLocal")
	private ApplicationController mApplicationController;

	public GraphFragment () {
	}

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View v = inflater.inflate (R.layout.weather_linegraph_layout, container, false);
		mApplicationController = new ApplicationController ();
		mGraphView = (WeatherLineGraphView) v.findViewById (R.id.linegraph);
		mGraphView.initWithData (mApplicationController.getLoadedGraphData ());
		Timber.e ("OnCreateView Called");
		return v;
	}

	public void updateData (int[] data) {

		mGraphView.changeData (data);
	}

}
