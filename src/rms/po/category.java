package rms.po;

import javax.validation.constraints.Size;


public class category {
    private Integer id;
    
    @Size(max=10,min=1,message="{all.name.length.error}")
    private String name;

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
}