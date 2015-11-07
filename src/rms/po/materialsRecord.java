package rms.po;

import java.math.BigDecimal;
import java.util.Date;

public class materialsRecord {
    private Integer id;

    private Integer materialsId;

    private BigDecimal materialsSurplus;

    private String materialsUnit;

    private Boolean save;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialsId() {
        return materialsId;
    }

    public void setMaterialsId(Integer materialsId) {
        this.materialsId = materialsId;
    }

    public BigDecimal getMaterialsSurplus() {
        return materialsSurplus;
    }

    public void setMaterialsSurplus(BigDecimal materialsSurplus) {
        this.materialsSurplus = materialsSurplus;
    }

    public String getMaterialsUnit() {
        return materialsUnit;
    }

    public void setMaterialsUnit(String materialsUnit) {
        this.materialsUnit = materialsUnit == null ? null : materialsUnit.trim();
    }

    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}