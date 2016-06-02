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

    @CreatedDate
    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "created_ts", nullable = false)
    private DateTime createdTs;

    @LastModifiedDate
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "modified_ts")
    private DateTime modifiedTs;

    @Column(name = "subject", nullable = false)
    private String subject;
    
    @Column(name = "file_name", nullable = false)
    private String fileName;
    
    @Column(name = "self_href", nullable = false)
    private String selfHref;
    
    @Column(name = "year", nullable = false)
    private String year;
    
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
    
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public DateTime getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(DateTime createdTs) {
        this.createdTs = createdTs;
    }

    public DateTime getModifiedTs() {
        return modifiedTs;
    }

    public void setModifiedTs(DateTime modifiedTs) {
        this.modifiedTs = modifiedTs;
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

    @Override
	public String toString() {
		return "GraduateWork [uuid=" + uuid + ", subject=" + subject + ", selfHref=" + selfHref + ", year=" + year
				+ ", student=" + student + ", degree=" + degree + ", headWork=" + headWork + "]";
	}
}
