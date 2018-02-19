
package com.douglaslewis.weatherforecast.ForecastAPI;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//Generated

//Generated
public class ForecastResponse implements Serializable {

    private Date jsonDownloadDate;
    private String locationName;



    private Double latitude;
    private Double longitude;
    private String timezone;
    private Integer offset;
    private Currently currently;
    private Minutely minutely;
    private Hourly hourly;
    private Daily daily;
    private Flags flags;
    private final Map<String, Object> additionalProperties = new HashMap<>();
    private static final long serialVersionUID = 0L;


    public void setJsonDownloadDate (Date d){
        jsonDownloadDate = d;
    }

    public Date getJsonDownloadDate (){
        return jsonDownloadDate;
    }

    public String getLocationName () {
        return locationName;
    }

    public void setLocationName (String locationName) {
        this.locationName = locationName;
    }
    /**
     * 
     * @return
     *     The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public ForecastResponse withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public ForecastResponse withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public ForecastResponse withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * 
     * @return
     *     The offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public ForecastResponse withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * 
     * @return
     *     The currently
     */
    public Currently getCurrently() {
        return currently;
    }

    /**
     * 
     * @param currently
     *     The currently
     */
    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public ForecastResponse withCurrently(Currently currently) {
        this.currently = currently;
        return this;
    }

    /**
     * 
     * @return
     *     The minutely
     */
    public Minutely getMinutely() {
        return minutely;
    }

    /**
     * 
     * @param minutely
     *     The minutely
     */
    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    public ForecastResponse withMinutely(Minutely minutely) {
        this.minutely = minutely;
        return this;
    }

    /**
     * 
     * @return
     *     The hourly
     */
    public Hourly getHourly() {
        return hourly;
    }

    /**
     * 
     * @param hourly
     *     The hourly
     */
    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public ForecastResponse withHourly(Hourly hourly) {
        this.hourly = hourly;
        return this;
    }

    /**
     * 
     * @return
     *     The daily
     */
    public Daily getDaily() {
        return daily;
    }

    /**
     * 
     * @param daily
     *     The daily
     */
    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public ForecastResponse withDaily(Daily daily) {
        this.daily = daily;
        return this;
    }

    /**
     * 
     * @return
     *     The flags
     */
    public Flags getFlags() {
        return flags;
    }

    /**
     * 
     * @param flags
     *     The flags
     */
    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public ForecastResponse withFlags(Flags flags) {
        this.flags = flags;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public ForecastResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
