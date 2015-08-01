package rms.po;

import java.math.BigDecimal;

public class dish {
    private Integer id;

    private String name;

    private BigDecimal price;

    private Integer rcategoryid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRcategoryid() {
        return rcategoryid;
    }

    public void setRcategoryid(Integer rcategoryid) {
        this.rcategoryid = rcategoryid;
    }
}