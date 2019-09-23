package th.ac.kmitl.rspg.request;

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
        "log_user_id",
        "sn",
        "thname",
        "enname",
        "thresearch",
        "enresearch",
        "character",
        "startdate",
        "enddate",
        "group",
        "keyword",
        "type",
        "type_plant_creature",
        "status",
        "start_rownum",
        "end_rownum"
})
public class SelectAllProjectRequest {

    @JsonProperty("log_user_id")
    private String logUserId;
    @JsonProperty("sn")
    private String sn;
    @JsonProperty("thname")
    private String thname;
    @JsonProperty("enname")
    private String enname;
    @JsonProperty("thresearch")
    private String thresearch;
    @JsonProperty("enresearch")
    private String enresearch;
    @JsonProperty("character")
    private String character;
    @JsonProperty("startdate")
    private String startdate;
    @JsonProperty("enddate")
    private String enddate;
    @JsonProperty("group")
    private String group;
    @JsonProperty("keyword")
    private String keyword;
    @JsonProperty("type")
    private String type;
    @JsonProperty("type_plant_creature")
    private String typePlantCreature;
    @JsonProperty("status")
    private String status;
    @JsonProperty("start_rownum")
    private String startRownum;
    @JsonProperty("end_rownum")
    private String endRownum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("log_user_id")
    public String getLogUserId() {
        return logUserId;
    }

    @JsonProperty("log_user_id")
    public void setLogUserId(String logUserId) {
        this.logUserId = logUserId;
    }

    @JsonProperty("sn")
    public String getSn() {
        return sn;
    }

    @JsonProperty("sn")
    public void setSn(String sn) {
        this.sn = sn;
    }

    @JsonProperty("thname")
    public String getThname() {
        return thname;
    }

    @JsonProperty("thname")
    public void setThname(String thname) {
        this.thname = thname;
    }

    @JsonProperty("enname")
    public String getEnname() {
        return enname;
    }

    @JsonProperty("enname")
    public void setEnname(String enname) {
        this.enname = enname;
    }

    @JsonProperty("thresearch")
    public String getThresearch() {
        return thresearch;
    }

    @JsonProperty("thresearch")
    public void setThresearch(String thresearch) {
        this.thresearch = thresearch;
    }

    @JsonProperty("enresearch")
    public String getEnresearch() {
        return enresearch;
    }

    @JsonProperty("enresearch")
    public void setEnresearch(String enresearch) {
        this.enresearch = enresearch;
    }

    @JsonProperty("character")
    public String getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(String character) {
        this.character = character;
    }

    @JsonProperty("startdate")
    public String getStartdate() {
        return startdate;
    }

    @JsonProperty("startdate")
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @JsonProperty("enddate")
    public String getEnddate() {
        return enddate;
    }

    @JsonProperty("enddate")
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("keyword")
    public String getKeyword() {
        return keyword;
    }

    @JsonProperty("keyword")
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("type_plant_creature")
    public String getTypePlantCreature() {
        return typePlantCreature;
    }

    @JsonProperty("type_plant_creature")
    public void setTypePlantCreature(String typePlantCreature) {
        this.typePlantCreature = typePlantCreature;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("start_rownum")
    public String getStartRownum() {
        return startRownum;
    }

    @JsonProperty("start_rownum")
    public void setStartRownum(String startRownum) {
        this.startRownum = startRownum;
    }

    @JsonProperty("end_rownum")
    public String getEndRownum() {
        return endRownum;
    }

    @JsonProperty("end_rownum")
    public void setEndRownum(String endRownum) {
        this.endRownum = endRownum;
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