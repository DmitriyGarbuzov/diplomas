package com.diplomas.web.dto;

public class DegreeDTO {
    
    private Long id;
    
    private String degreeName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegreeName() {
	return degreeName;
    }

    public void setDegreeName(String degreeName) {
	this.degreeName = degreeName;
    }

    @Override
    public String toString() {
	return "DegreeDTO [id=" + id + ", degreeName=" + degreeName + "]";
    }
}
