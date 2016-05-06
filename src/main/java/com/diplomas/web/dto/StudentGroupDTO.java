package com.diplomas.web.dto;

public class StudentGroupDTO {
    
    private Long id;
    
    private String groupName;
    
    private CathedraDTO cathedra;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public CathedraDTO getCathedra() {
        return cathedra;
    }

    public void setCathedra(CathedraDTO cathedra) {
        this.cathedra = cathedra;
    }

    @Override
    public String toString() {
	return "StudentGroupDTO [groupName=" + groupName + ", cathedra="
		+ cathedra + "]";
    } 
    
    
}
