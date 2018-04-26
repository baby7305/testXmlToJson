import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FetureDTO {
    @JsonProperty("FEATURECODE")
    private String fetureCode;
    @JsonProperty("FEATUREDESC")
    private String fetureDesc;
    @JsonProperty("FAMILYDESC")
    private String familyDesc;
    @JsonProperty("FAMILYCODE")
    private String familyCode;

    public FetureDTO() {
    }

    public FetureDTO(String fetureCode, String fetureDesc, String familyDesc, String familyCode) {
        this.fetureCode = fetureCode;
        this.fetureDesc = fetureDesc;
        this.familyDesc = familyDesc;
        this.familyCode = familyCode;
    }

    public String getFetureCode() {
        return fetureCode;
    }

    public void setFetureCode(String fetureCode) {
        this.fetureCode = fetureCode;
    }

    public String getFetureDesc() {
        return fetureDesc;
    }

    public void setFetureDesc(String fetureDesc) {
        this.fetureDesc = fetureDesc;
    }

    public String getFamilyDesc() {
        return familyDesc;
    }

    public void setFamilyDesc(String familyDesc) {
        this.familyDesc = familyDesc;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }

    @Override
    public String toString() {
        return "FetureDTO{" +
                "fetureCode=" + fetureCode +
                ", fetureDesc='" + fetureDesc + '\'' +
                ", familyDesc='" + familyDesc + '\'' +
                ", familyCode='" + familyCode + '\'' +
                '}';
    }
}
