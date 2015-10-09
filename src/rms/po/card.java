package rms.po;

import java.math.BigDecimal;

public class card {
    private Integer id;

    private String cardid;

    private String belongsCardid;

    private String username;

    private String phone;

    private String wechatOpenid;

    private Boolean isavailable;

    private BigDecimal money;

    private Integer allIntegral;

    private Integer monthIntegral;

    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid == null ? null : cardid.trim();
    }

    public String getBelongsCardid() {
        return belongsCardid;
    }

    public void setBelongsCardid(String belongsCardid) {
        this.belongsCardid = belongsCardid == null ? null : belongsCardid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid == null ? null : wechatOpenid.trim();
    }

    public Boolean getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(Boolean isavailable) {
        this.isavailable = isavailable;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getAllIntegral() {
        return allIntegral;
    }

    public void setAllIntegral(Integer allIntegral) {
        this.allIntegral = allIntegral;
    }

    public Integer getMonthIntegral() {
        return monthIntegral;
    }

    public void setMonthIntegral(Integer monthIntegral) {
        this.monthIntegral = monthIntegral;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}