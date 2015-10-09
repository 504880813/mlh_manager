package rms.po;

import java.math.BigDecimal;

public class cardLevel {
    private Integer id;

    private String cardlevel;

    private BigDecimal discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardlevel() {
        return cardlevel;
    }

    public void setCardlevel(String cardlevel) {
        this.cardlevel = cardlevel == null ? null : cardlevel.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}