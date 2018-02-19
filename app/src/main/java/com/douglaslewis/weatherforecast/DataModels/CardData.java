package com.douglaslewis.weatherforecast.DataModels;


public class CardData {
	/*
    Builder pattern - Design Patterns, Effective JAva

     */

	private final String mDate;
	private final Integer mTemperature;
	private final String mWeatherType;
	private final Integer mHighTemp;
	private final Integer mLowTemp;
	private final String mIcon;


	private CardData (final String date, final Integer temperature,
					  final String weatherType, final Integer highTemp, final Integer lowTemp, final String icon) {
		this.mDate = date;
		this.mTemperature = temperature;
		this.mWeatherType = weatherType;
		this.mHighTemp = highTemp;
		this.mLowTemp = lowTemp;
		this.mIcon = icon;

	}

	public String getDate () {
		return mDate;
	}

	public Integer getHighTemp () {
		return mHighTemp;
	}

	public Integer getLowTemp () {
		return mLowTemp;
	}

	public Integer getTemperature () {
		return mTemperature;
	}

	public String getWeatherType () {
		return mWeatherType;
	}

	public String getShortDate () {
		return mDate;
	}

	private static Integer checkIntegerNull (Integer val) {
		return val == null ? 0 : val;
	}

	private static String checkStringNull (String val) {
		return val == null ? " " : val;
	}

	public String getIcon () {
		return mIcon;
	}

	public static class CardBuilder {
		private final String nestedDate;
		private Integer nestedTemperature;
		private String nestedWeatherType;
		private Integer nestedHighTemp;
		private Integer nestedLowTemp;
		private String nestedIcon;

		public CardBuilder (final String date) {
			this.nestedDate = date;
		}

		public CardBuilder temperature (final Integer temp) {
			nestedTemperature = temp;
			return this;
		}

		public CardBuilder weatherType (final String weather) {
			nestedWeatherType = weather;
			return this;
		}

		public CardBuilder highTemperature (final Integer highTemp) {
			nestedHighTemp = highTemp;
			return this;
		}

		public CardBuilder lowTemperature (final Integer lowTemp) {
			nestedLowTemp = lowTemp;
			return this;
		}

		public CardBuilder icon (final String icon) {
			nestedIcon = icon;
			return this;
		}

		public CardData createCardData () {
			// Don't allocate null values, always allocate at least 0 or an empty string
			return new CardData (checkStringNull( nestedDate),
					checkIntegerNull (nestedTemperature), checkStringNull (nestedWeatherType),
					checkIntegerNull (nestedHighTemp), checkIntegerNull (nestedLowTemp), checkStringNull (nestedIcon));
		}
	}
}
