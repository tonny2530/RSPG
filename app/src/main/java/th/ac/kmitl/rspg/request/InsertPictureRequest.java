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
        "base64encode",
        "name",
        "detail",
        "first",
        "plant_id",
        "creature_id",
        "news_id"
})
public class InsertPictureRequest {

    @JsonProperty("log_user_id")
    private Integer logUserId;
    @JsonProperty("base64encode")
    private String base64encode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("detail")
    private String detail;
    @JsonProperty("first")
    private String first;
    @JsonProperty("plant_id")
    private Integer plantId;
    @JsonProperty("creature_id")
    private Integer creatureId;
    @JsonProperty("news_id")
    private Integer newsId;
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

    @JsonProperty("base64encode")
    public String getBase64encode() {
        return base64encode;
    }

    @JsonProperty("base64encode")
    public void setBase64encode(String base64encode) {
        this.base64encode = base64encode;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    @JsonProperty("first")
    public String getFirst() {
        return first;
    }

    @JsonProperty("first")
    public void setFirst(String first) {
        this.first = first;
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

    @JsonProperty("news_id")
    public Integer getNewsId() {
        return newsId;
    }

    @JsonProperty("news_id")
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
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