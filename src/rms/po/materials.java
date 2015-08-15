package rms.po;

import java.math.BigDecimal;

public class materials {
    private Integer id;

    private String name;

    private BigDecimal surplus;

    private Long lastsurplus;

    private String unit;

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

    public BigDecimal getSurplus() {
        return surplus;
    }

    public void setSurplus(BigDecimal surplus) {
        this.surplus = surplus;
    }

    public Long getLastsurplus() {
        return lastsurplus;
    }

    public void setLastsurplus(Long lastsurplus) {
        this.lastsurplus = lastsurplus;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}