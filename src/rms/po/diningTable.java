package rms.po;

public class diningTable {
    private Integer id;

    private String seatnumber;

    private Boolean isfree;

    private String freeimage;

    private String busyimage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatnumber = seatnumber == null ? null : seatnumber.trim();
    }

    public Boolean getIsfree() {
        return isfree;
    }

    public void setIsfree(Boolean isfree) {
        this.isfree = isfree;
    }

    public String getFreeimage() {
        return freeimage;
    }

    public void setFreeimage(String freeimage) {
        this.freeimage = freeimage == null ? null : freeimage.trim();
    }

    public String getBusyimage() {
        return busyimage;
    }

    public void setBusyimage(String busyimage) {
        this.busyimage = busyimage == null ? null : busyimage.trim();
    }
}