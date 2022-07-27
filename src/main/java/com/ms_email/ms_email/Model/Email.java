package com.ms_email.ms_email.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ms_email.ms_email.Enum.StatusEmail;

@Entity
@Table(name = "TB_EMAIL")
public class Email implements Serializable{

    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime senDateEmail;
    private StatusEmail statusEmail;
    

    public Email() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOwnerRef() {
        return ownerRef;
    }
    public void setOwnerRef(String ownerRed) {
        this.ownerRef = ownerRed;
    }
    public String getEmailFrom() {
        return emailFrom;
    }
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getSenDateEmail() {
        return senDateEmail;
    }
    public void setSenDateEmail(LocalDateTime senDateEmail) {
        this.senDateEmail = senDateEmail;
    }
    public StatusEmail getStatusEmail() {
        return statusEmail;
    }
    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }


    public String getEmailTo() {
        return emailTo;
    }


    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    

}
