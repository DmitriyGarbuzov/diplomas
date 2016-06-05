package com.diplomas.web.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

public class GraduateWorkDTO {

    private UUID uuid;

    private String controlOfNormsDate;

    private String preProtectionDate;

    private String protectionDate;

    private String subject;

    private String fileName;

    private String selfHref;

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

    public String getControlOfNormsDate() {
        return controlOfNormsDate;
    }

    public void setControlOfNormsDate(String controlOfNormsDate) {
        this.controlOfNormsDate = controlOfNormsDate;
    }

    public String getPreProtectionDate() {
        return preProtectionDate;
    }

    public void setPreProtectionDate(String preProtectionDate) {
        this.preProtectionDate = preProtectionDate;
    }

    public String getProtectionDate() {
        return protectionDate;
    }

    public void setProtectionDate(String protectionDate) {
        this.protectionDate = protectionDate;
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
        return "GraduateWorkDTO [uuid=" + uuid + ", subject=" + subject + ", selfHref=" + selfHref
                + ", student=" + student + ", degree=" + degree + ", headWork=" + headWork + "]";
    }
}
