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
        "keyword",
        "type",
        "start_rownum",
        "end_rownum"
})
public class SearchAllRequest {

    @JsonProperty("log_user_id")
    private String logUserId;
    @JsonProperty("keyword")
    private String keyword;
    @JsonProperty("type")
    private String type;
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