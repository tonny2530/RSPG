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
        "flower_time",
        "fruit_time",
        "propagation",
        "culture_detail",
        "other",
        "pic_first_filename",
        "user_id",
        "user_thname",
        "update_time",
        "picture",
        "habitat"
})
public class SelectAllPlantResponse {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sn")
    private String sn;
    @JsonProperty("type_id")
    private Object typeId;
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
    private Object original;
    @JsonProperty("distribution")
    private Object distribution;
    @JsonProperty("ecology")
    private Object ecology;
    @JsonProperty("flower_time")
    private Object flowerTime;
    @JsonProperty("fruit_time")
    private Object fruitTime;
    @JsonProperty("propagation")
    private Object propagation;
    @JsonProperty("culture_detail")
    private Object cultureDetail;
    @JsonProperty("other")
    private Object other;
    @JsonProperty("pic_first_filename")
    private String picFirstFilename;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_thname")
    private Object userThname;
    @JsonProperty("update_time")
    private Object updateTime;
    @JsonProperty("picture")
    private Object picture;
    @JsonProperty("habitat")
    private Object habitat;
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
    public Object getTypeId() {
        return typeId;
    }

    @JsonProperty("type_id")
    public void setTypeId(Object typeId) {
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
    public Object getOriginal() {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(Object original) {
        this.original = original;
    }

    @JsonProperty("distribution")
    public Object getDistribution() {
        return distribution;
    }

    @JsonProperty("distribution")
    public void setDistribution(Object distribution) {
        this.distribution = distribution;
    }

    @JsonProperty("ecology")
    public Object getEcology() {
        return ecology;
    }

    @JsonProperty("ecology")
    public void setEcology(Object ecology) {
        this.ecology = ecology;
    }

    @JsonProperty("flower_time")
    public Object getFlowerTime() {
        return flowerTime;
    }

    @JsonProperty("flower_time")
    public void setFlowerTime(Object flowerTime) {
        this.flowerTime = flowerTime;
    }

    @JsonProperty("fruit_time")
    public Object getFruitTime() {
        return fruitTime;
    }

    @JsonProperty("fruit_time")
    public void setFruitTime(Object fruitTime) {
        this.fruitTime = fruitTime;
    }

    @JsonProperty("propagation")
    public Object getPropagation() {
        return propagation;
    }

    @JsonProperty("propagation")
    public void setPropagation(Object propagation) {
        this.propagation = propagation;
    }

    @JsonProperty("culture_detail")
    public Object getCultureDetail() {
        return cultureDetail;
    }

    @JsonProperty("culture_detail")
    public void setCultureDetail(Object cultureDetail) {
        this.cultureDetail = cultureDetail;
    }

    @JsonProperty("other")
    public Object getOther() {
        return other;
    }

    @JsonProperty("other")
    public void setOther(Object other) {
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
    public Object getUserThname() {
        return userThname;
    }

    @JsonProperty("user_thname")
    public void setUserThname(Object userThname) {
        this.userThname = userThname;
    }

    @JsonProperty("update_time")
    public Object getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("picture")
    public Object getPicture() {
        return picture;
    }

    @JsonProperty("picture")
    public void setPicture(Object picture) {
        this.picture = picture;
    }

    @JsonProperty("habitat")
    public Object getHabitat() {
        return habitat;
    }

    @JsonProperty("habitat")
    public void setHabitat(Object habitat) {
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