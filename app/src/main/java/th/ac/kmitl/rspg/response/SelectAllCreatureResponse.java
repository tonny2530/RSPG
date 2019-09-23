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
        "type_id",
        "vernacular_name",
        "scientific_name",
        "family_name",
        "common_name",
        "character",
        "original",
        "distribution",
        "ecology",
        "iucn",
        "other",
        "pic_first_filename",
        "user_id",
        "user_thname",
        "update_time",
        "picture",
        "habitat"
})
public class SelectAllCreatureResponse {

    @JsonProperty("id")
    private Integer id;
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
    @JsonProperty("character")
    private String character;
    @JsonProperty("original")
    private String original;
    @JsonProperty("distribution")
    private String distribution;
    @JsonProperty("ecology")
    private String ecology;
    @JsonProperty("iucn")
    private String iucn;
    @JsonProperty("other")
    private String other;
    @JsonProperty("pic_first_filename")
    private String picFirstFilename;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_thname")
    private String userThname;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("habitat")
    private String habitat;
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

    @JsonProperty("character")
    public String getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(String character) {
        this.character = character;
    }

    @JsonProperty("original")
    public String getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(String original) {
        this.original = original;
    }

    @JsonProperty("distribution")
    public String getDistribution() {
        return distribution;
    }

    @JsonProperty("distribution")
    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    @JsonProperty("ecology")
    public String getEcology() {
        return ecology;
    }

    @JsonProperty("ecology")
    public void setEcology(String ecology) {
        this.ecology = ecology;
    }

    @JsonProperty("iucn")
    public String getIucn() {
        return iucn;
    }

    @JsonProperty("iucn")
    public void setIucn(String iucn) {
        this.iucn = iucn;
    }

    @JsonProperty("other")
    public String getOther() {
        return other;
    }

    @JsonProperty("other")
    public void setOther(String other) {
        this.other = other;
    }

    @JsonProperty("pic_first_filename")
    public String getPicFirstFilename() {
        return picFirstFilename;
    }

    @JsonProperty("pic_first_filename")
    public void setPicFirstFilename(String picFirstFilename) {
        this.picFirstFilename = picFirstFilename;
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

    @JsonProperty("update_time")
    public String getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("picture")
    public String getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @JsonProperty("habitat")
    public String getHabitat() {
        return habitat;
    }

    @JsonProperty("habitat")
    public void setHabitat(String habitat) {
        this.habitat = habitat;
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