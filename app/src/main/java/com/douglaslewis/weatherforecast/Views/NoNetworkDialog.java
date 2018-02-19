package com.douglaslewis.weatherforecast.Views;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.douglaslewis.weatherforecast.Controllers.ApplicationController;
import com.douglaslewis.weatherforecast.R;


public class NoNetworkDialog extends DialogFragment {
	@SuppressWarnings("FieldCanBeLocal")
	private final String NETWORK_ERROR_ID = "network_error";
	@SuppressWarnings("FieldCanBeLocal")
	private final String NO_NETWORK_ID = "no_network";
	private final ApplicationController mApplicationController = new ApplicationController ();
	private DialogListener mDialogListener;


	@NonNull
	@Override
	public Dialog onCreateDialog (Bundle savedInstanceState) {

		AlertDialog.Builder builder = new AlertDialog.Builder (getActivity ());
		builder.setTitle (mApplicationController.getString (NETWORK_ERROR_ID));
		builder.setIcon (R.drawable.error);
		builder.setMessage (mApplicationController.getString (NO_NETWORK_ID));

		builder.setPositiveButton (R.string.retry, new DialogInterface.OnClickListener () {
			@Override
			public void onClick (DialogInterface dialog, int which) {
				// Clicked
				mDialogListener.onReloadPressed ();
			}
		});

		builder.setNegativeButton (R.string.cancel, new DialogInterface.OnClickListener () {
			@Override
			public void onClick (DialogInterface dialog, int which) {
				// Clicked
			}
		});

		return builder.create ();
	}


	@Override
	public void onAttach (Activity activity) {
		super.onAttach (activity);

		try {
			mDialogListener = (DialogListener) activity;
		} catch (ClassCastException e) {
			throw new IllegalStateException ("Must implement DialogListener");
		}

	}

	public interface DialogListener {
		void onReloadPressed ();
	}

}
