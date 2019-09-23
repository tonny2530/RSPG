package th.ac.kmitl.rspg.response;

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
        "id",
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
        "introduction",
        "objective",
        "scope",
        "expected",
        "reference",
        "method",
        "budget",
        "project_manager_thname",
        "project_manager_email",
        "status",
        "progress_completed",
        "progress_ongoing",
        "progress_notstart",
        "user",
        "organization",
        "document"
})
public class SelectAllProjectResponse {

    @JsonProperty("id")
    private Integer id;
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
    private Object character;
    @JsonProperty("startdate")
    private String startdate;
    @JsonProperty("enddate")
    private String enddate;
    @JsonProperty("group")
    private Object group;
    @JsonProperty("keyword")
    private Object keyword;
    @JsonProperty("type")
    private Object type;
    @JsonProperty("type_plant_creature")
    private Integer typePlantCreature;
    @JsonProperty("introduction")
    private String introduction;
    @JsonProperty("objective")
    private String objective;
    @JsonProperty("scope")
    private Object scope;
    @JsonProperty("expected")
    private Object expected;
    @JsonProperty("reference")
    private Object reference;
    @JsonProperty("method")
    private Object method;
    @JsonProperty("budget")
    private Object budget;
    @JsonProperty("project_manager_thname")
    private Object projectManagerThname;
    @JsonProperty("project_manager_email")
    private Object projectManagerEmail;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("progress_completed")
    private Integer progressCompleted;
    @JsonProperty("progress_ongoing")
    private Integer progressOngoing;
    @JsonProperty("progress_notstart")
    private Integer progressNotstart;
    @JsonProperty("user")
    private Object user;
    @JsonProperty("organization")
    private Object organization;
    @JsonProperty("document")
    private Object document;
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
    public Object getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(Object character) {
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
    public Object getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(Object group) {
        this.group = group;
    }

    @JsonProperty("keyword")
    public Object getKeyword() {
        return keyword;
    }

    @JsonProperty("keyword")
    public void setKeyword(Object keyword) {
        this.keyword = keyword;
    }

    @JsonProperty("type")
    public Object getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Object type) {
        this.type = type;
    }

    @JsonProperty("type_plant_creature")
    public Integer getTypePlantCreature() {
        return typePlantCreature;
    }

    @JsonProperty("type_plant_creature")
    public void setTypePlantCreature(Integer typePlantCreature) {
        this.typePlantCreature = typePlantCreature;
    }

    @JsonProperty("introduction")
    public String getIntroduction() {
        return introduction;
    }

    @JsonProperty("introduction")
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @JsonProperty("objective")
    public String getObjective() {
        return objective;
    }

    @JsonProperty("objective")
    public void setObjective(String objective) {
        this.objective = objective;
    }

    @JsonProperty("scope")
    public Object getScope() {
        return scope;
    }

    @JsonProperty("scope")
    public void setScope(Object scope) {
        this.scope = scope;
    }

    @JsonProperty("expected")
    public Object getExpected() {
        return expected;
    }

    @JsonProperty("expected")
    public void setExpected(Object expected) {
        this.expected = expected;
    }

    @JsonProperty("reference")
    public Object getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(Object reference) {
        this.reference = reference;
    }

    @JsonProperty("method")
    public Object getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(Object method) {
        this.method = method;
    }

    @JsonProperty("budget")
    public Object getBudget() {
        return budget;
    }

    @JsonProperty("budget")
    public void setBudget(Object budget) {
        this.budget = budget;
    }

    @JsonProperty("project_manager_thname")
    public Object getProjectManagerThname() {
        return projectManagerThname;
    }

    @JsonProperty("project_manager_thname")
    public void setProjectManagerThname(Object projectManagerThname) {
        this.projectManagerThname = projectManagerThname;
    }

    @JsonProperty("project_manager_email")
    public Object getProjectManagerEmail() {
        return projectManagerEmail;
    }

    @JsonProperty("project_manager_email")
    public void setProjectManagerEmail(Object projectManagerEmail) {
        this.projectManagerEmail = projectManagerEmail;
    }

    @JsonProperty("status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("progress_completed")
    public Integer getProgressCompleted() {
        return progressCompleted;
    }

    @JsonProperty("progress_completed")
    public void setProgressCompleted(Integer progressCompleted) {
        this.progressCompleted = progressCompleted;
    }

    @JsonProperty("progress_ongoing")
    public Integer getProgressOngoing() {
        return progressOngoing;
    }

    @JsonProperty("progress_ongoing")
    public void setProgressOngoing(Integer progressOngoing) {
        this.progressOngoing = progressOngoing;
    }

    @JsonProperty("progress_notstart")
    public Integer getProgressNotstart() {
        return progressNotstart;
    }

    @JsonProperty("progress_notstart")
    public void setProgressNotstart(Integer progressNotstart) {
        this.progressNotstart = progressNotstart;
    }

    @JsonProperty("user")
    public Object getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(Object user) {
        this.user = user;
    }

    @JsonProperty("organization")
    public Object getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(Object organization) {
        this.organization = organization;
    }

    @JsonProperty("document")
    public Object getDocument() {
        return document;
    }

    @JsonProperty("document")
    public void setDocument(Object document) {
        this.document = document;
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