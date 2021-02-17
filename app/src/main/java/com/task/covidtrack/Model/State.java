
package com.task.covidtrack.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ID",
    "Message",
    "Global",
    "Countries",
    "Date"
})
public class State {

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Global")
    private Global global;
    @JsonProperty("Countries")
    private List<Country> countries = null;
    @JsonProperty("Date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Global")
    public Global getGlobal() {
        return global;
    }

    @JsonProperty("Global")
    public void setGlobal(Global global) {
        this.global = global;
    }

    @JsonProperty("Countries")
    public List<Country> getCountries() {
        return countries;
    }

    @JsonProperty("Countries")
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
