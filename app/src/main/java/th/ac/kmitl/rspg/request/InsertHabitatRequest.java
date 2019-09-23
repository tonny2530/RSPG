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
        "plant_id",
        "creature_id",
        "latitude",
        "longitude",
        "area"
})
public class InsertHabitatRequest {

    @JsonProperty("log_user_id")
    private Integer logUserId;
    @JsonProperty("plant_id")
    private Integer plantId;
    @JsonProperty("creature_id")
    private Integer creatureId;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("area")
    private String area;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("log_user_id")
    public Integer getLogUserId() {
        return logUserId;
    }

    @JsonProperty("log_user_id")
    public void setLogUserId(Integer logUserId) {
        this.logUserId = logUserId;
    }

    @JsonProperty("plant_id")
    public Integer getPlantId() {
        return plantId;
    }

    @JsonProperty("plant_id")
    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }

    @JsonProperty("creature_id")
    public Integer getCreatureId() {
        return creatureId;
    }

    @JsonProperty("creature_id")
    public void setCreatureId(Integer creatureId) {
        this.creatureId = creatureId;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(String area) {
        this.area = area;
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