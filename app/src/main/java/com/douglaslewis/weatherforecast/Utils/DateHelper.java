package com.douglaslewis.weatherforecast.Utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public final class DateHelper {
	@SuppressLint("SimpleDateFormat")
	private final static DateFormat mDayOfWeekFormat = new SimpleDateFormat ("EEEE");
	@SuppressLint("SimpleDateFormat")
	private final static DateFormat mDayAndMonthFormat = new SimpleDateFormat ("MMMM dd");
	@SuppressLint("SimpleDateFormat")
	private final static DateFormat mShortDayAndMonthFormat = new SimpleDateFormat ("MMM dd");

	private final static int ONE_DAY = (1000 * 60 * 60 * 24);// This is not the most accurate way to do this

	private DateHelper () {
		throw new IllegalStateException ("No Instances, use class");
	}// No instances... This is a helper.  Always access it through the class


	private static String getDayOfWeek (Date date) {
		return mDayOfWeekFormat.format (date);
	}

	private static String getDayAndMonth (Date date) {
		return mDayAndMonthFormat.format (date);
	}

	public static String getShortDayAndMonth (Date date) {
		return mShortDayAndMonthFormat.format (date);
	}


	public static String getShortDayAndMonthPlus (Date date, int days) {
		return mShortDayAndMonthFormat.format (dayPlusDays (date, days));
	}

	public static String getDayAndMonthPlus (Date date, int days) {
		return getDayAndMonth (dayPlusDays (date, days));
	}

	public static String getDayOfWeekPlus (Date date, int days) {
		return getDayOfWeek (dayPlusDays (date, days));
	}

	private static Date dayPlusDays (Date date, int days) {
		/*  if we need to be very accurate we should use Java 8 and JSR 310  Date is imprecise */
		return new Date (date.getTime () + (ONE_DAY * days));

	}
}
