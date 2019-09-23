package th.ac.kmitl.rspg.request;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "log_user_id",
        "startdate",
        "enddate",
        "name",
        "detail",
        "project_id",
        "start_rownum",
        "end_rownum"
})
public class SelectAllNewsRequest implements Serializable {

    @JsonProperty("log_user_id")
    private String logUserId;
    @JsonProperty("startdate")
    private String startdate;
    @JsonProperty("enddate")
    private String enddate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("detail")
    private String detail;
    @JsonProperty("project_id")
    private String projectId;
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

    @JsonProperty("project_id")
    public String getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(String projectId) {
        this.projectId = projectId;
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