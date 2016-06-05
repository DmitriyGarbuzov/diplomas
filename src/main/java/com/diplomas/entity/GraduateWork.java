package com.diplomas.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Table(name = "graduate_work")
public class GraduateWork extends BaseEntity{
    
    @Type(type = "pg-uuid")
    @Column(name = "uuid", unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();

    @Column(name = "subject", nullable = false)
    private String subject;
    
    @Column(name = "file_name", nullable = true)
    private String fileName;
    
    @Column(name = "self_href", nullable = true)
    private String selfHref;
    
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "degree_id", nullable = false)
    private Degree degree;
    
    @ManyToOne
    @JoinColumn(name = "cathedra_id", nullable = false)
    private Cathedra cathedra;
    
    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup group;
    
    @ManyToOne
    @JoinColumn(name = "head_work_id", nullable = false)
    private HeadWork headWork;

    @Column(name = "control_of_norms", nullable = false)
    private String controlOfNormsDate;

    @Column(name = "pre_protection", nullable = false)
    private String preProtectionDate;

    @Column(name = "protection", nullable = false)
    private String protectionDate;
    
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Cathedra getCathedra() {
		return cathedra;
	}

	public void setCathedra(Cathedra cathedra) {
		this.cathedra = cathedra;
	}
	
	public StudentGroup getGroup() {
		return group;
	}

	public void setGroup(StudentGroup group) {
		this.group = group;
	}

	public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public HeadWork getHeadWork() {
        return headWork;
    }

    public void setHeadWork(HeadWork headWork) {
        this.headWork = headWork;
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

    @Override
    public String toString() {
        return "GraduateWork{" +
                "uuid=" + uuid +
                ", subject='" + subject + '\'' +
                ", fileName='" + fileName + '\'' +
                ", selfHref='" + selfHref + '\'' +
                ", student=" + student +
                ", degree=" + degree +
                ", cathedra=" + cathedra +
                ", group=" + group +
                ", headWork=" + headWork +
                ", controlOfNormsDate='" + controlOfNormsDate + '\'' +
                ", preProtectionDate='" + preProtectionDate + '\'' +
                ", protectionDate='" + protectionDate + '\'' +
                '}';
    }
}
