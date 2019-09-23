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
        "sn",
        "picture",
        "thname",
        "enname",
        "sex",
        "job_position",
        "organization",
        "address",
        "email",
        "telephone",
        "fax",
        "type_professional",
        "other",
        "username",
        "password",
        "usertype_id",
        "usertype_name",
        "project_id",
        "project_thname",
        "project_enname",
        "project_type_plant_creature"
})
public class LoginUserResponse implements Serializable {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sn")
    private String sn;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("thname")
    private String thname;
    @JsonProperty("enname")
    private String enname;
    @JsonProperty("sex")
    private Integer sex;
    @JsonProperty("job_position")
    private String jobPosition;
    @JsonProperty("organization")
    private String organization;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("telephone")
    private String telephone;
    @JsonProperty("fax")
    private String fax;
    @JsonProperty("type_professional")
    private String typeProfessional;
    @JsonProperty("other")
    private String other;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("usertype_id")
    private String usertypeId;
    @JsonProperty("usertype_name")
    private String usertypeName;
    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("project_thname")
    private String projectThname;
    @JsonProperty("project_enname")
    private String projectEnname;
    @JsonProperty("project_type_plant_creature")
    private Integer projectTypePlantCreature;
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

    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
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

    @JsonProperty("sex")
    public Integer getSex() {
        return sex;
    }

    @JsonProperty("sex")
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @JsonProperty("job_position")
    public String getJobPosition() {
        return jobPosition;
    }

    @JsonProperty("job_position")
    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("telephone")
    public String getTelephone() {
        return telephone;
    }

    @JsonProperty("telephone")
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonProperty("fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("type_professional")
    public String getTypeProfessional() {
        return typeProfessional;
    }

    @JsonProperty("type_professional")
    public void setTypeProfessional(String typeProfessional) {
        this.typeProfessional = typeProfessional;
    }

    @JsonProperty("other")
    public String getOther() {
        return other;
    }

    @JsonProperty("other")
    public void setOther(String other) {
        this.other = other;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("usertype_id")
    public String getUsertypeId() {
        return usertypeId;
    }

    @JsonProperty("usertype_id")
    public void setUsertypeId(String usertypeId) {
        this.usertypeId = usertypeId;
    }

    @JsonProperty("usertype_name")
    public String getUsertypeName() {
        return usertypeName;
    }

    @JsonProperty("usertype_name")
    public void setUsertypeName(String usertypeName) {
        this.usertypeName = usertypeName;
    }

    @JsonProperty("project_id")
    public Integer getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("project_thname")
    public String getProjectThname() {
        return projectThname;
    }

    @JsonProperty("project_thname")
    public void setProjectThname(String projectThname) {
        this.projectThname = projectThname;
    }

    @JsonProperty("project_enname")
    public String getProjectEnname() {
        return projectEnname;
    }

    @JsonProperty("project_enname")
    public void setProjectEnname(String projectEnname) {
        this.projectEnname = projectEnname;
    }

    @JsonProperty("project_type_plant_creature")
    public Integer getProjectTypePlantCreature() {
        return projectTypePlantCreature;
    }

    @JsonProperty("project_type_plant_creature")
    public void setProjectTypePlantCreature(Integer projectTypePlantCreature) {
        this.projectTypePlantCreature = projectTypePlantCreature;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "LoginUserResponse{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", picture='" + picture + '\'' +
                ", thname='" + thname + '\'' +
                ", enname='" + enname + '\'' +
                ", sex=" + sex +
                ", jobPosition='" + jobPosition + '\'' +
                ", organization='" + organization + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", typeProfessional='" + typeProfessional + '\'' +
                ", other='" + other + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertypeId='" + usertypeId + '\'' +
                ", usertypeName='" + usertypeName + '\'' +
                ", projectId=" + projectId +
                ", projectThname='" + projectThname + '\'' +
                ", projectEnname='" + projectEnname + '\'' +
                ", projectTypePlantCreature=" + projectTypePlantCreature +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}