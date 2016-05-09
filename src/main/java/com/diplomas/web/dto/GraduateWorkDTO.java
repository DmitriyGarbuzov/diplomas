package com.diplomas.web.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class GraduateWorkDTO {

    private UUID uuid;

    private String subject;

    private String fileName;

    private String selfHref;

    private String year;

    private StudentDTO student;

    private CathedraDTO cathedra;

    private StudentGroupDTO group;

    private DegreeDTO degree;

    private HeadWorkDTO headWork;

    private MultipartFile file;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public CathedraDTO getCathedra() {
        return cathedra;
    }

    public void setCathedra(CathedraDTO cathedra) {
        this.cathedra = cathedra;
    }

    public StudentGroupDTO getGroup() {
        return group;
    }

    public void setGroup(StudentGroupDTO group) {
        this.group = group;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "GraduateWorkDTO [uuid=" + uuid + ", subject=" + subject + ", selfHref=" + selfHref + ", year=" + year
                + ", student=" + student + ", degree=" + degree + ", headWork=" + headWork + "]";
    }
}
