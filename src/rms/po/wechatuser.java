package rms.po;

public class wechatuser {
    private Integer id;

    private String appid;

    private String appsecret;

    private String accessToken;

    private String accessTokenExpiresTime;

    private String accessTokenExpiresLastTime;

    private String pageAccessToken;

    private String pageAccessTokenExpiresTime;

    private String pageAccessTokenExpiresLastTime;

    private String jsapiTicket;

    private String jsapiTicketExpiresTime;

    private String jsapiTicketExpiresLastTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public String getAccessTokenExpiresTime() {
        return accessTokenExpiresTime;
    }

    public void setAccessTokenExpiresTime(String accessTokenExpiresTime) {
        this.accessTokenExpiresTime = accessTokenExpiresTime == null ? null : accessTokenExpiresTime.trim();
    }

    public String getAccessTokenExpiresLastTime() {
        return accessTokenExpiresLastTime;
    }

    public void setAccessTokenExpiresLastTime(String accessTokenExpiresLastTime) {
        this.accessTokenExpiresLastTime = accessTokenExpiresLastTime == null ? null : accessTokenExpiresLastTime.trim();
    }

    public String getPageAccessToken() {
        return pageAccessToken;
    }

    public void setPageAccessToken(String pageAccessToken) {
        this.pageAccessToken = pageAccessToken == null ? null : pageAccessToken.trim();
    }

    public String getPageAccessTokenExpiresTime() {
        return pageAccessTokenExpiresTime;
    }

    public void setPageAccessTokenExpiresTime(String pageAccessTokenExpiresTime) {
        this.pageAccessTokenExpiresTime = pageAccessTokenExpiresTime == null ? null : pageAccessTokenExpiresTime.trim();
    }

    public String getPageAccessTokenExpiresLastTime() {
        return pageAccessTokenExpiresLastTime;
    }

    public void setPageAccessTokenExpiresLastTime(String pageAccessTokenExpiresLastTime) {
        this.pageAccessTokenExpiresLastTime = pageAccessTokenExpiresLastTime == null ? null : pageAccessTokenExpiresLastTime.trim();
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket == null ? null : jsapiTicket.trim();
    }

    public String getJsapiTicketExpiresTime() {
        return jsapiTicketExpiresTime;
    }

    public void setJsapiTicketExpiresTime(String jsapiTicketExpiresTime) {
        this.jsapiTicketExpiresTime = jsapiTicketExpiresTime == null ? null : jsapiTicketExpiresTime.trim();
    }

    public String getJsapiTicketExpiresLastTime() {
        return jsapiTicketExpiresLastTime;
    }

    public void setJsapiTicketExpiresLastTime(String jsapiTicketExpiresLastTime) {
        this.jsapiTicketExpiresLastTime = jsapiTicketExpiresLastTime == null ? null : jsapiTicketExpiresLastTime.trim();
    }
}