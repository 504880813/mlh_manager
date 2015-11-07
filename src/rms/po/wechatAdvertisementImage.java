package rms.po;

public class wechatAdvertisementImage {
    private Integer id;

    private String name;

    private String path;

    private Boolean usingstatus;

    private String description;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Boolean getUsingstatus() {
        return usingstatus;
    }

    public void setUsingstatus(Boolean usingstatus) {
        this.usingstatus = usingstatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}