package com.diplomas.web.dto;

import java.util.UUID;

public class GraduateWorkDTO {
    
    private UUID uuid;
    
    private String subject;
    
    private String selfHref;
    
    private String year;
    
    private StudentDTO student;
    
    private DegreeDTO degree;
    
    private HeadWorkDTO headWork;
    
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSelfHref() {
        return selfHref;
    }

    public void setSelfHref(String selfHref) {
        this.selfHref = selfHref;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public DegreeDTO getDegree() {
        return degree;
    }

    public void setDegree(DegreeDTO degree) {
        this.degree = degree;
    }

    public HeadWorkDTO getHeadWork() {
        return headWork;
    }

    public void setHeadWork(HeadWorkDTO headWork) {
        this.headWork = headWork;
    }

    @Override
	public String toString() {
		return "GraduateWorkDTO [uuid=" + uuid + ", subject=" + subject + ", selfHref=" + selfHref + ", year=" + year
				+ ", student=" + student + ", degree=" + degree + ", headWork=" + headWork + "]";
	}
}
