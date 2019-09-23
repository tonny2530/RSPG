package th.ac.kmitl.rspg.response;

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
        "id",
        "date",
        "time",
        "name",
        "short_detail",
        "full_detail",
        "user_id",
        "user_thname",
        "user_enname",
        "pic_first_filename",
        "project_id",
        "_public"
})
public class SelectAllNewsResponse implements Serializable {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;
    @JsonProperty("name")
    private String name;
    @JsonProperty("short_detail")
    private String shortDetail;
    @JsonProperty("full_detail")
    private String fullDetail;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_thname")
    private String userThname;
    @JsonProperty("user_enname")
    private String userEnname;
    @JsonProperty("pic_first_filename")
    private String picFirstFilename;
    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("_public")
    private Integer _public;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("short_detail")
    public String getShortDetail() {
        return shortDetail;
    }

    @JsonProperty("short_detail")
    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
    }

    @JsonProperty("full_detail")
    public String getFullDetail() {
        return fullDetail;
    }

    @JsonProperty("full_detail")
    public void setFullDetail(String fullDetail) {
        this.fullDetail = fullDetail;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("user_thname")
    public String getUserThname() {
        return userThname;
    }

    @JsonProperty("user_thname")
    public void setUserThname(String userThname) {
        this.userThname = userThname;
    }

    @JsonProperty("user_enname")
    public String getUserEnname() {
        return userEnname;
    }

    @JsonProperty("user_enname")
    public void setUserEnname(String userEnname) {
        this.userEnname = userEnname;
    }

    @JsonProperty("pic_first_filename")
    public String getPicFirstFilename() {
        return picFirstFilename;
    }

    @JsonProperty("pic_first_filename")
    public void setPicFirstFilename(String picFirstFilename) {
        this.picFirstFilename = picFirstFilename;
    }

    @JsonProperty("project_id")
    public Integer getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("_public")
    public Integer getPublic() {
        return _public;
    }

    @JsonProperty("_public")
    public void setPublic(Integer _public) {
        this._public = _public;
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