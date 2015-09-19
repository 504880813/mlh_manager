package rms.po;

public class wechatuserWithBLOBs extends wechatuser {
    private String accessTokenExpiresTime;

    private String pageAccessTokenExpiresTime;

    public String getAccessTokenExpiresTime() {
        return accessTokenExpiresTime;
    }

    public void setAccessTokenExpiresTime(String accessTokenExpiresTime) {
        this.accessTokenExpiresTime = accessTokenExpiresTime == null ? null : accessTokenExpiresTime.trim();
    }

    public String getPageAccessTokenExpiresTime() {
        return pageAccessTokenExpiresTime;
    }

    public void setPageAccessTokenExpiresTime(String pageAccessTokenExpiresTime) {
        this.pageAccessTokenExpiresTime = pageAccessTokenExpiresTime == null ? null : pageAccessTokenExpiresTime.trim();
    }
}