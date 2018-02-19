package com.douglaslewis.weatherforecast.Views;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.DataModels.CardData;
import com.douglaslewis.weatherforecast.R;
import com.douglaslewis.weatherforecast.Views.Graph.GraphFragment;
import com.douglaslewis.weatherforecast.Views.WeekView.WeekViewFragment;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements ApplicationController.DataFinished, SwipeRefreshLayout.OnRefreshListener, NoNetworkDialog.DialogListener {


	@SuppressWarnings("FieldCanBeLocal")
	final private String WEEK_FRAGMENT = "WEEKFRAGMENT";
	@SuppressWarnings("FieldCanBeLocal")
	final private String GRAPH_FRAGMENT = "GRAPHFRAGMENT";
	private WeekViewFragment mWeekViewFragment;
	private GraphFragment mGraphFragment;
	private SwipeRefreshLayout mSwipeRefreshView;
	private NoNetworkDialog mNoNetworkDialog;
	private FragmentManager mFragmentManager;
	private ApplicationController mApplicationController;
	private ImageView mToolbarImage;
	private TextView mToolbarText;


	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate (savedInstanceState);
		mApplicationController = new ApplicationController ();
		setContentView (R.layout.activity_main);
		setupToolbarActionBar ();
		setupSwipeRefreshView ();
		addDayFragment ();
		setupDialog ();

		Timber.e ("Oncreate Called");
	}


	@Override
	protected void onStart () {
		super.onStart ();

		mApplicationController.registerDataFinishedListener (this);

		//setupGPS returns an intent if GPS is not enabled.
		Intent i = mApplicationController.setupGPS ();

		if (i != null)
			startActivity (i);
		else if (!mApplicationController.testNetwork ()) {
			showDialog ();
		}

		Timber.d ("onStart");

	}

	@Override
	protected void onResume () {
		super.onResume ();
		Timber.d ("onResume");
	}

	@Override
	protected void onStop () {
		super.onStop ();
		mApplicationController.unregisterDataFinishedListener ();
	}

	@Override
	protected void onPause () {
		super.onPause ();

		Timber.d ("onPause");
	}


	@Override
	protected void onSaveInstanceState (Bundle outState) {
		super.onSaveInstanceState (outState);
//		outState.putInt (FRAGMENT_ID, mCurrentFragment);
		Timber.d ("onSaveInstanceState");

	}

	private void setupToolbarActionBar () {
		mToolbarImage = (ImageView) findViewById (R.id.toolbar_imageview);
		mToolbarText = (TextView) findViewById (R.id.toolbar_text);
		String type = mApplicationController.getLoadedCurrentWeatherType ();
		String temp = mApplicationController.getLoadedCurrentWeatherTemperature ();

		ApplicationController.loadIconInto (mToolbarImage, type, this);
		mToolbarText.setText (mApplicationController.formatTemperature (temp));

	}


	private void setupSwipeRefreshView () {
		mSwipeRefreshView = (SwipeRefreshLayout) findViewById (R.id.fragment_layout);
		//noinspection ConstantConditions
		mSwipeRefreshView.setColorSchemeResources (R.color.colorPrimary);
		mSwipeRefreshView.setOnRefreshListener (this);

	}

	private void setupDialog () {
		mNoNetworkDialog = new NoNetworkDialog ();
	}

	private void addDayFragment () {
		if (mGraphFragment == null) {
			mGraphFragment = new GraphFragment ();
			mWeekViewFragment = new WeekViewFragment ();
			setupFragmentManager ();
		}

		mFragmentManager.beginTransaction ().add (R.id.day_card_fragment, mGraphFragment, GRAPH_FRAGMENT).commit ();
		mFragmentManager.beginTransaction ().add (R.id.week_cards_fragment, mWeekViewFragment, WEEK_FRAGMENT).commit ();
	}

	private void setupFragmentManager () {
		if (mFragmentManager == null)
			mFragmentManager = getSupportFragmentManager ();
	}

	@Override
	public void onDataLoaded (List<CardData> cardData, int[] data, String currentTemp, String type) {
		this.mGraphFragment.updateData (data);
		this.mWeekViewFragment.updateData (cardData);
		setToolbarData (currentTemp, type);
		mSwipeRefreshView.setRefreshing (false);
		Timber.d ("Data loaded");
	}

	@Override
	public void onNetworkError () {
		mSwipeRefreshView.setRefreshing (false);
		showDialog ();
	}

	@Override
	public void onRefresh () {
		mApplicationController.makeNetworkCall ();
	}

	private void launchNetwork () {
		startActivity (new Intent (Settings.ACTION_WIFI_SETTINGS));
	}

	@Override
	public void onReloadPressed () {
		launchNetwork ();
	}

	private void showDialog () {
		//If dialog is already displayed don't want to show it again.
		if (!mNoNetworkDialog.isAdded ())
			mNoNetworkDialog.show (mFragmentManager, "Dialog");

	}

	private void setToolbarData (String currentTemp, String type) {
		ApplicationController.loadIconInto (mToolbarImage, type, this);
		mToolbarText.setText (mApplicationController.formatTemperature (currentTemp));
	}

}

