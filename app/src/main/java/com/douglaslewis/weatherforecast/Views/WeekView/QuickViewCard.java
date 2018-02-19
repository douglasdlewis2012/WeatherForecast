package com.douglaslewis.weatherforecast.Views.WeekView;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.DataModels.CardData;
import com.douglaslewis.weatherforecast.R;
import com.douglaslewis.weatherforecast.Singletons.ApplicationSingleton;


import timber.log.Timber;

public final class QuickViewCard extends CardView {


	private TextView mDateTextView;
	private TextView mHighTextView;
	private TextView mLowTextView;
	private TextView mDescriptionTextView;
	private ImageView mIcon;
	//	private Context mContext;
	@SuppressWarnings("FieldCanBeLocal")
	private CardData mCardData;
	private final ApplicationController mApplicationController = new ApplicationController ();


	public QuickViewCard (Context context, AttributeSet attrs) {
		super (context, attrs);
	}

	public QuickViewCard (Context context) {
		super (context);
		createView ();
		Timber.e ("QuickViewCard instantiated");

	}

	private View createView () {

		LayoutInflater mInflater = (LayoutInflater) mApplicationController.getAppContext ().getSystemService (Context.LAYOUT_INFLATER_SERVICE);
		View v = mInflater.inflate (R.layout.quick_weather_detail, this, true);

		LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		setLayoutParams (ll);
		setupCardView (v);

		return v;
	}


	private void setupCardView (View v) {

		CardView quickCardView = (CardView) v.findViewById (R.id.quick_card);
		quickCardView.setOnClickListener (new View.OnClickListener () {
			@Override
			public void onClick (View v) {

				Timber.d ("Quick Card Pressed");

			}
		});


		setupDateViews (v);
		setupHighLow (v);
		setupIcon (v);
		setupShortDescription (v);
		Timber.e ("card setup");
	}


	private void setupDateViews (View v) {
		mDateTextView = (TextView) v.findViewById (R.id.quick_card_date);
	}

	private void setupHighLow (View v) {
		setupHighTextView (v);
		setupLowTextView (v);
	}

	private void setupHighTextView (View v) {
		mHighTextView = (TextView) v.findViewById (R.id.quick_card_high);
	}

	private void setupLowTextView (View v) {
		mLowTextView = (TextView) v.findViewById (R.id.quick_card_low);
	}

	private void setupIcon (View v) {
		mIcon = (ImageView) v.findViewById (R.id.quick_card_icon);
	}

	private void setupShortDescription (View v) {
		mDescriptionTextView = (TextView) v.findViewById (R.id.quick_card_weather_description);
	}

	public void setQuickCardData (CardData data) {
		mCardData = data;

		setDateText (mCardData.getShortDate ());
		setHighText (mCardData.getHighTemp ());
		setLowText (mCardData.getLowTemp ());
		setShortDescription (mCardData.getWeatherType ());
		setIcon (mCardData.getIcon ());
	}

	private void setDateText (String n) {
		mDateTextView.setText (n);
	}

	private void setHighText (Integer n) {
		if (n != null)
			mHighTextView.setText (Integer.toString (n) +  ApplicationSingleton.getINSTANCE ().getFahreinheitSymbol ());
	}

	private void setLowText (Integer n) {
		if (n != null)
			mLowTextView.setText (Integer.toString (n) + ApplicationSingleton.getINSTANCE ().getFahreinheitSymbol ());
	}

	private void setShortDescription (String n) {
		mDescriptionTextView.setText (n);
	}


	private void setIcon (String icon) {
		ApplicationController.loadIconInto (mIcon, icon, this);
		Timber.d ("finished creating quickview card");

	}
}
