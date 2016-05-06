package com.diplomas.web.dto;

public class CathedraDTO {
    
    private Long id;
    
    private String cathedraName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCathedraName() {
        return cathedraName;
    }

    public void setCathedraName(String cathedraName) {
        this.cathedraName = cathedraName;
    }

    @Override
    public String toString() {
	return "CathedraDTO [cathedraName=" + cathedraName + "]";
    }
}
