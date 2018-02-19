package com.douglaslewis.weatherforecast.Views.WeekView;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public final class CardSpacingDecoration extends RecyclerView.ItemDecoration {
	//Utility to space Cards in recylcerview.
	@SuppressWarnings("FieldCanBeLocal")
	private final int mSpacing = 10;
	private CardOrientation mOrientation;

	enum CardOrientation{
		HORIZONTAL, VERTICAL
	}
	public CardSpacingDecoration (int orientation) {
		setOrientation (orientation);
	}

	private void setOrientation(int orientation){
		mOrientation = (orientation==LinearLayout.HORIZONTAL) ? CardOrientation.HORIZONTAL : CardOrientation.VERTICAL;
	}

	@Override
	public void getItemOffsets (Rect outRect, View v, RecyclerView parent, RecyclerView.State state) {

		if (parent.getChildAdapterPosition (v) != parent.getAdapter ().getItemCount () - 1){
			switch (mOrientation){
				case HORIZONTAL:
					outRect.right = mSpacing;
					break;

				case VERTICAL:
					outRect.bottom = mSpacing;
					break;

				default:
			}
		}

	}

}
