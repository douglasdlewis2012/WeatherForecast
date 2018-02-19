
package com.douglaslewis.weatherforecast.ForecastAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Generated
public class Daily implements Serializable {

    private String summary;
    private String icon;
    private List<Datum__> data = new ArrayList<>();
    private final Map<String, Object> additionalProperties = new HashMap<>();

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

    public Daily withSummary(String summary) {
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

    public Daily withIcon(String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    public List<Datum__> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum__> data) {
        this.data = data;
    }

    public Daily withData(List<Datum__> data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Daily withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
