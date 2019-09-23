package th.ac.kmitl.rspg.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "log_user_id",
        "id"
})
public class SelectUserRequest {

    @JsonProperty("log_user_id")
    private Integer logUserId;
    @JsonProperty("id")
    private Integer id;
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

    @JsonProperty("id")
    public Integer getid() {
        return id;
    }

    @JsonProperty("id")
    public void setid(Integer id) {
        this.id = id;
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