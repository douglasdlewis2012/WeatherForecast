package com.douglaslewis.weatherforecast.Views.WeekView;


import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.DataModels.CardData;
import com.douglaslewis.weatherforecast.R;
import com.douglaslewis.weatherforecast.Views.WeekView.Adapters.WeekRecyclerAdapter;

import java.util.List;

public class WeekViewFragment extends Fragment {

	@SuppressWarnings("FieldCanBeLocal")
	private RecyclerView mWeekRecylcerView;
	private WeekRecyclerAdapter mWeekRecyclerAdapter;
	private final ApplicationController mApplicationController = new ApplicationController ();

	public WeekViewFragment () {
		// Required empty public constructor
	}


	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
							  Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View v = inflater.inflate (R.layout.fragment_week_view, container, false);
		mWeekRecylcerView = (RecyclerView) v.findViewById (R.id.week_cardview_recycler);
		mWeekRecylcerView.setHasFixedSize (true);
		setupLayoutManager (mWeekRecylcerView);

		mWeekRecyclerAdapter = new WeekRecyclerAdapter (mApplicationController.getLoadedCardData ());
		mWeekRecylcerView.setAdapter (mWeekRecyclerAdapter);


		return v;
	}

	private void setupLayoutManager (RecyclerView view) {
		LinearLayoutManager manager = new LinearLayoutManager (getContext ());

		if (getResources ().getConfiguration ().orientation == Configuration.ORIENTATION_PORTRAIT) {
			manager.setOrientation (LinearLayout.HORIZONTAL);
			view.addItemDecoration (new CardSpacingDecoration (LinearLayout.HORIZONTAL));

		} else {
			manager.setOrientation (LinearLayout.VERTICAL);
			view.addItemDecoration (new CardSpacingDecoration (LinearLayout.VERTICAL));

			//RecyclerView inside scroll view causes issues, where the height is set to the recyclerviews.

			final TypedArray styledAttributes = getContext ().getTheme ().obtainStyledAttributes (
					new int[]{android.R.attr.actionBarSize});

			int actionBarHeight = (int) styledAttributes.getDimension (0, 0);
			DisplayMetrics metrics = new DisplayMetrics ();
			WindowManager windowManager = (WindowManager) mApplicationController.getAppContext ().getSystemService (Context.WINDOW_SERVICE);
			windowManager.getDefaultDisplay ().getMetrics (metrics);
			view.getLayoutParams ().height = metrics.heightPixels - actionBarHeight * 2;

		}

		view.setLayoutManager (manager);
	}

	public void updateData (List<CardData> data) {
		mWeekRecyclerAdapter.onDataChanged (data);
	}

}
