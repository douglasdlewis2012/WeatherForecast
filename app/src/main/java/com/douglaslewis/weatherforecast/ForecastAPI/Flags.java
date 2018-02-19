
package com.douglaslewis.weatherforecast.ForecastAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Generated
public class Flags implements Serializable {

    private List<String> sources = new ArrayList<>();
    private List<String> darkskyStations = new ArrayList<>();
    private List<String> datapointStations = new ArrayList<>();
    private List<String> isdStations = new ArrayList<>();
    private List<String> madisStations = new ArrayList<>();
    private String units;
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The sources
     */
    public List<String> getSources() {
        return sources;
    }

    /**
     * 
     * @param sources
     *     The sources
     */
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public Flags withSources(List<String> sources) {
        this.sources = sources;
        return this;
    }

    /**
     * 
     * @return
     *     The darkskyStations
     */
    public List<String> getDarkskyStations() {
        return darkskyStations;
    }

    /**
     * 
     * @param darkskyStations
     *     The darksky-stations
     */
    public void setDarkskyStations(List<String> darkskyStations) {
        this.darkskyStations = darkskyStations;
    }

    public Flags withDarkskyStations(List<String> darkskyStations) {
        this.darkskyStations = darkskyStations;
        return this;
    }

    /**
     * 
     * @return
     *     The datapointStations
     */
    public List<String> getDatapointStations() {
        return datapointStations;
    }

    /**
     * 
     * @param datapointStations
     *     The datapoint-stations
     */
    public void setDatapointStations(List<String> datapointStations) {
        this.datapointStations = datapointStations;
    }

    public Flags withDatapointStations(List<String> datapointStations) {
        this.datapointStations = datapointStations;
        return this;
    }

    /**
     * 
     * @return
     *     The isdStations
     */
    public List<String> getIsdStations() {
        return isdStations;
    }

    /**
     * 
     * @param isdStations
     *     The isd-stations
     */
    public void setIsdStations(List<String> isdStations) {
        this.isdStations = isdStations;
    }

    public Flags withIsdStations(List<String> isdStations) {
        this.isdStations = isdStations;
        return this;
    }

    /**
     * 
     * @return
     *     The madisStations
     */
    public List<String> getMadisStations() {
        return madisStations;
    }

    /**
     * 
     * @param madisStations
     *     The madis-stations
     */
    public void setMadisStations(List<String> madisStations) {
        this.madisStations = madisStations;
    }

    public Flags withMadisStations(List<String> madisStations) {
        this.madisStations = madisStations;
        return this;
    }

    /**
     * 
     * @return
     *     The units
     */
    public String getUnits() {
        return units;
    }

    /**
     * 
     * @param units
     *     The units
     */
    public void setUnits(String units) {
        this.units = units;
    }

    public Flags withUnits(String units) {
        this.units = units;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Flags withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
