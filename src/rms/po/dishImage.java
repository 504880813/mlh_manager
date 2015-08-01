package rms.po;

public class dishImage {
    private Integer id;

    private String imagepath;

    private Integer rdishid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public Integer getRdishid() {
        return rdishid;
    }

    public void setRdishid(Integer rdishid) {
        this.rdishid = rdishid;
    }
}