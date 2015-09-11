package rms.po;

import java.math.BigDecimal;
import java.util.Date;

public class order {
    private Integer id;

    private BigDecimal price;

    private Date createtime;

    private Boolean isbalance;

    private Boolean ispayment;

    private String waiter;

    private Integer rDiningtableId;

    private Integer numberofpeople;

    private BigDecimal discountamount;

    private BigDecimal couponamount;

    private Byte servingstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getIsbalance() {
        return isbalance;
    }

    public void setIsbalance(Boolean isbalance) {
        this.isbalance = isbalance;
    }

    public Boolean getIspayment() {
        return ispayment;
    }

    public void setIspayment(Boolean ispayment) {
        this.ispayment = ispayment;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter == null ? null : waiter.trim();
    }

    public Integer getrDiningtableId() {
        return rDiningtableId;
    }

    public void setrDiningtableId(Integer rDiningtableId) {
        this.rDiningtableId = rDiningtableId;
    }

    public Integer getNumberofpeople() {
        return numberofpeople;
    }

    public void setNumberofpeople(Integer numberofpeople) {
        this.numberofpeople = numberofpeople;
    }

    public BigDecimal getDiscountamount() {
        return discountamount;
    }

    public void setDiscountamount(BigDecimal discountamount) {
        this.discountamount = discountamount;
    }

    public BigDecimal getCouponamount() {
        return couponamount;
    }

    public void setCouponamount(BigDecimal couponamount) {
        this.couponamount = couponamount;
    }

    public Byte getServingstatus() {
        return servingstatus;
    }

    public void setServingstatus(Byte servingstatus) {
        this.servingstatus = servingstatus;
    }
}