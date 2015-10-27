package rms.po;

import java.util.Date;

public class materialsRecord {
    private Integer id;

    private Integer materialsId;

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