package com.douglaslewis.weatherforecast.Views.WeekView.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.douglaslewis.weatherforecast.DataModels.CardData;
import com.douglaslewis.weatherforecast.Views.WeekView.QuickViewCard;

import java.util.List;


public class WeekRecyclerAdapter extends RecyclerView.Adapter<WeekRecyclerAdapter.ViewHolder> {
	private List<CardData> mCardDataElements;

	public WeekRecyclerAdapter (List<CardData> dataList) {
		mCardDataElements = dataList;
	}

	public void onDataChanged (List<CardData> data) {
		mCardDataElements = data;
		notifyDataSetChanged ();
	}

	@Override
	public WeekRecyclerAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		QuickViewCard card = new QuickViewCard (parent.getContext ());
		return new ViewHolder (card);
	}

	@Override
	public void onBindViewHolder (ViewHolder holder, int position) {
		holder.mQuickViewCard.setQuickCardData (mCardDataElements.get (position));
	}

	@Override
	public int getItemCount () {
		return mCardDataElements.size ();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public final QuickViewCard mQuickViewCard;

		public ViewHolder (QuickViewCard v) {
			super (v);
			mQuickViewCard = v;
		}
	}

}
