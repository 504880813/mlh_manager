package rms.po;

import java.math.BigDecimal;

public class orderdetail {
    private Integer id;

    private Integer dishnumber;

    private String rdishname;

    private Integer corderid;

    private Integer echelon;

    private BigDecimal price;

    private Byte servingstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDishnumber() {
        return dishnumber;
    }

    public void setDishnumber(Integer dishnumber) {
        this.dishnumber = dishnumber;
    }

    public String getRdishname() {
        return rdishname;
    }

    public void setRdishname(String rdishname) {
        this.rdishname = rdishname == null ? null : rdishname.trim();
    }

    public Integer getCorderid() {
        return corderid;
    }

    public void setCorderid(Integer corderid) {
        this.corderid = corderid;
    }

    public Integer getEchelon() {
        return echelon;
    }

    public void setEchelon(Integer echelon) {
        this.echelon = echelon;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getServingstatus() {
        return servingstatus;
    }

    public void setServingstatus(Byte servingstatus) {
        this.servingstatus = servingstatus;
    }
}