
package com.task.Pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agebracket",
    "backupnotes",
    "contractedfromwhichpatientsuspected",
    "currentstatus",
    "dateannounced",
    "detectedcity",
    "detecteddistrict",
    "detectedstate",
    "estimatedonsetdate",
    "gender",
    "nationality",
    "notes",
    "numcases",
    "patientnumber",
    "source1",
    "source2",
    "source3",
    "statecode",
    "statepatientnumber",
    "statuschangedate",
    "typeoftransmission"
})
public class RawDatum {

    @JsonProperty("agebracket")
    private String agebracket;
    @JsonProperty("backupnotes")
    private String backupnotes;
    @JsonProperty("contractedfromwhichpatientsuspected")
    private String contractedfromwhichpatientsuspected;
    @JsonProperty("currentstatus")
    private String currentstatus;
    @JsonProperty("dateannounced")
    private String dateannounced;
    @JsonProperty("detectedcity")
    private String detectedcity;
    @JsonProperty("detecteddistrict")
    private String detecteddistrict;
    @JsonProperty("detectedstate")
    private String detectedstate;
    @JsonProperty("estimatedonsetdate")
    private String estimatedonsetdate;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("notes")
    private String notes;
    @JsonProperty("numcases")
    private String numcases;
    @JsonProperty("patientnumber")
    private String patientnumber;
    @JsonProperty("source1")
    private String source1;
    @JsonProperty("source2")
    private String source2;
    @JsonProperty("source3")
    private String source3;
    @JsonProperty("statecode")
    private String statecode;
    @JsonProperty("statepatientnumber")
    private String statepatientnumber;
    @JsonProperty("statuschangedate")
    private String statuschangedate;
    @JsonProperty("typeoftransmission")
    private String typeoftransmission;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("agebracket")
    public String getAgebracket() {
        return agebracket;
    }

    @JsonProperty("agebracket")
    public void setAgebracket(String agebracket) {
        this.agebracket = agebracket;
    }

    @JsonProperty("backupnotes")
    public String getBackupnotes() {
        return backupnotes;
    }

    @JsonProperty("backupnotes")
    public void setBackupnotes(String backupnotes) {
        this.backupnotes = backupnotes;
    }

    @JsonProperty("contractedfromwhichpatientsuspected")
    public String getContractedfromwhichpatientsuspected() {
        return contractedfromwhichpatientsuspected;
    }

    @JsonProperty("contractedfromwhichpatientsuspected")
    public void setContractedfromwhichpatientsuspected(String contractedfromwhichpatientsuspected) {
        this.contractedfromwhichpatientsuspected = contractedfromwhichpatientsuspected;
    }

    @JsonProperty("currentstatus")
    public String getCurrentstatus() {
        return currentstatus;
    }

    @JsonProperty("currentstatus")
    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    @JsonProperty("dateannounced")
    public String getDateannounced() {
        return dateannounced;
    }

    @JsonProperty("dateannounced")
    public void setDateannounced(String dateannounced) {
        this.dateannounced = dateannounced;
    }

    @JsonProperty("detectedcity")
    public String getDetectedcity() {
        return detectedcity;
    }

    @JsonProperty("detectedcity")
    public void setDetectedcity(String detectedcity) {
        this.detectedcity = detectedcity;
    }

    @JsonProperty("detecteddistrict")
    public String getDetecteddistrict() {
        return detecteddistrict;
    }

    @JsonProperty("detecteddistrict")
    public void setDetecteddistrict(String detecteddistrict) {
        this.detecteddistrict = detecteddistrict;
    }

    @JsonProperty("detectedstate")
    public String getDetectedstate() {
        return detectedstate;
    }

    @JsonProperty("detectedstate")
    public void setDetectedstate(String detectedstate) {
        this.detectedstate = detectedstate;
    }

    @JsonProperty("estimatedonsetdate")
    public String getEstimatedonsetdate() {
        return estimatedonsetdate;
    }

    @JsonProperty("estimatedonsetdate")
    public void setEstimatedonsetdate(String estimatedonsetdate) {
        this.estimatedonsetdate = estimatedonsetdate;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("nationality")
    public String getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("numcases")
    public String getNumcases() {
        return numcases;
    }

    @JsonProperty("numcases")
    public void setNumcases(String numcases) {
        this.numcases = numcases;
    }

    @JsonProperty("patientnumber")
    public String getPatientnumber() {
        return patientnumber;
    }

    @JsonProperty("patientnumber")
    public void setPatientnumber(String patientnumber) {
        this.patientnumber = patientnumber;
    }

    @JsonProperty("source1")
    public String getSource1() {
        return source1;
    }

    @JsonProperty("source1")
    public void setSource1(String source1) {
        this.source1 = source1;
    }

    @JsonProperty("source2")
    public String getSource2() {
        return source2;
    }

    @JsonProperty("source2")
    public void setSource2(String source2) {
        this.source2 = source2;
    }

    @JsonProperty("source3")
    public String getSource3() {
        return source3;
    }

    @JsonProperty("source3")
    public void setSource3(String source3) {
        this.source3 = source3;
    }

    @JsonProperty("statecode")
    public String getStatecode() {
        return statecode;
    }

    @JsonProperty("statecode")
    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    @JsonProperty("statepatientnumber")
    public String getStatepatientnumber() {
        return statepatientnumber;
    }

    @JsonProperty("statepatientnumber")
    public void setStatepatientnumber(String statepatientnumber) {
        this.statepatientnumber = statepatientnumber;
    }

    @JsonProperty("statuschangedate")
    public String getStatuschangedate() {
        return statuschangedate;
    }

    @JsonProperty("statuschangedate")
    public void setStatuschangedate(String statuschangedate) {
        this.statuschangedate = statuschangedate;
    }

    @JsonProperty("typeoftransmission")
    public String getTypeoftransmission() {
        return typeoftransmission;
    }

    @JsonProperty("typeoftransmission")
    public void setTypeoftransmission(String typeoftransmission) {
        this.typeoftransmission = typeoftransmission;
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
