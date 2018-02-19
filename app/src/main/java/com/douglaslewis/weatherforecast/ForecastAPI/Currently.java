
package com.douglaslewis.weatherforecast.ForecastAPI;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

//Generated
public class Currently implements Serializable{

    private Double time;
    private String summary;
    private String icon;
    private Double nearestStormDistance;
    private Double nearestStormBearing;
    private Double precipIntensity;
    private Double precipProbability;
    private Double temperature;
    private Double apparentTemperature;
    private Double dewPoint;
    private Double humidity;
    private Double windSpeed;
    private Double windBearing;
    private Double visibility;
    private Double cloudCover;
    private Double pressure;
    private Double ozone;
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The time
     */
    public Double getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(Double time) {
        this.time = time;
    }

    public Currently withTime(Double time) {
        this.time = time;
        return this;
    }

    /**
     * 
     * @return
     *     The summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     * @param summary
     *     The summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Currently withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * 
     * @return
     *     The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Currently withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * 
     * @return
     *     The nearestStormDistance
     */
    public Double getNearestStormDistance() {
        return nearestStormDistance;
    }

    /**
     * 
     * @param nearestStormDistance
     *     The nearestStormDistance
     */
    public void setNearestStormDistance(Double nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public Currently withNearestStormDistance(Double nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
        return this;
    }

    /**
     * 
     * @return
     *     The nearestStormBearing
     */
    public Double getNearestStormBearing() {
        return nearestStormBearing;
    }

    /**
     * 
     * @param nearestStormBearing
     *     The nearestStormBearing
     */
    public void setNearestStormBearing(Double nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public Currently withNearestStormBearing(Double nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
        return this;
    }

    /**
     * 
     * @return
     *     The precipIntensity
     */
    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    /**
     * 
     * @param precipIntensity
     *     The precipIntensity
     */
    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Currently withPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
        return this;
    }

    /**
     * 
     * @return
     *     The precipProbability
     */
    public Double getPrecipProbability() {
        return precipProbability;
    }

    /**
     * 
     * @param precipProbability
     *     The precipProbability
     */
    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Currently withPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
        return this;
    }

    /**
     * 
     * @return
     *     The temperature
     */
    public Double getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Currently withTemperature(Double temperature) {
        this.temperature = temperature;
        return this;
    }

    /**
     * 
     * @return
     *     The apparentTemperature
     */
    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    /**
     * 
     * @param apparentTemperature
     *     The apparentTemperature
     */
    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Currently withApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
        return this;
    }

    /**
     * 
     * @return
     *     The dewPoint
     */
    public Double getDewPoint() {
        return dewPoint;
    }

    /**
     * 
     * @param dewPoint
     *     The dewPoint
     */
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Currently withDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public Double getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Currently withHumidity(Double humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * 
     * @return
     *     The windSpeed
     */
    public Double getWindSpeed() {
        return windSpeed;
    }

    /**
     * 
     * @param windSpeed
     *     The windSpeed
     */
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Currently withWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    /**
     * 
     * @return
     *     The windBearing
     */
    public Double getWindBearing() {
        return windBearing;
    }

    /**
     * 
     * @param windBearing
     *     The windBearing
     */
    public void setWindBearing(Double windBearing) {
        this.windBearing = windBearing;
    }

    public Currently withWindBearing(Double windBearing) {
        this.windBearing = windBearing;
        return this;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    public Double getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Currently withVisibility(Double visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     * 
     * @return
     *     The cloudCover
     */
    public Double getCloudCover() {
        return cloudCover;
    }

    /**
     * 
     * @param cloudCover
     *     The cloudCover
     */
    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Currently withCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
        return this;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Currently withPressure(Double pressure) {
        this.pressure = pressure;
        return this;
    }

    /**
     * 
     * @return
     *     The ozone
     */
    public Double getOzone() {
        return ozone;
    }

    /**
     * 
     * @param ozone
     *     The ozone
     */
    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public Currently withOzone(Double ozone) {
        this.ozone = ozone;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Currently withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
