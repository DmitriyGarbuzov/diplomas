package com.diplomas.web.dto;

public class StudentGroupDTO {
    
    private Long id;
    
    private String groupName;
    
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

	@Override
	public String toString() {
		return "StudentGroupDTO [id=" + id + ", groupName=" + groupName + "]";
	}
}
