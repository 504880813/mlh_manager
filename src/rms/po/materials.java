package rms.po;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

public class materials {
    private Integer id;
    
    @Size(min=1,max=10,message="{all.name.length.error}")
    private String name;
    //剩余数量
    private BigDecimal surplus;

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
}