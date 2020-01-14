package com.cbt.entity;
// Generated 12-Jan-2020 16:42:34 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Statusdetail generated by hbm2java
 */
@Entity
@Table(name="statusdetail"
    ,catalog="computerbasedtest"
)
public class Statusdetail  implements java.io.Serializable {


     private String userId;
     private User user;
     private String description;
     private Date expiredDate;

    public Statusdetail() {
    }

    public Statusdetail(User user, String description, Date expiredDate) {
       this.user = user;
       this.description = description;
       this.expiredDate = expiredDate;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="user"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="User_id", unique=true, nullable=false, length=9)
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="description", nullable=false, length=100)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="expired_date", nullable=false, length=10)
    public Date getExpiredDate() {
        return this.expiredDate;
    }
    
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }




}


