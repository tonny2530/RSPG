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
        "type_id",
        "vernacular_name",
        "scientific_name",
        "family_name",
        "common_name",
        "habitat_latitude",
        "habitat_longitude",
        "start_rownum",
        "end_rownum"
})
public class SelectAllPlantRequest {

    @JsonProperty("log_user_id")
    private String logUserId;
    @JsonProperty("sn")
    private String sn;
    @JsonProperty("type_id")
    private String typeId;
    @JsonProperty("vernacular_name")
    private String vernacularName;
    @JsonProperty("scientific_name")
    private String scientificName;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("habitat_latitude")
    private String habitatLatitude;
    @JsonProperty("habitat_longitude")
    private String habitatLongitude;
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

    @JsonProperty("type_id")
    public String getTypeId() {
        return typeId;
    }

    @JsonProperty("type_id")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("vernacular_name")
    public String getVernacularName() {
        return vernacularName;
    }

    @JsonProperty("vernacular_name")
    public void setVernacularName(String vernacularName) {
        this.vernacularName = vernacularName;
    }

    @JsonProperty("scientific_name")
    public String getScientificName() {
        return scientificName;
    }

    @JsonProperty("scientific_name")
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @JsonProperty("family_name")
    public String getFamilyName() {
        return familyName;
    }

    @JsonProperty("family_name")
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @JsonProperty("common_name")
    public String getCommonName() {
        return commonName;
    }

    @JsonProperty("common_name")
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @JsonProperty("habitat_latitude")
    public String getHabitatLatitude() {
        return habitatLatitude;
    }

    @JsonProperty("habitat_latitude")
    public void setHabitatLatitude(String habitatLatitude) {
        this.habitatLatitude = habitatLatitude;
    }

    @JsonProperty("habitat_longitude")
    public String getHabitatLongitude() {
        return habitatLongitude;
    }

    @JsonProperty("habitat_longitude")
    public void setHabitatLongitude(String habitatLongitude) {
        this.habitatLongitude = habitatLongitude;
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