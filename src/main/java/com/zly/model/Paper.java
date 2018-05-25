package com.zly.model;

import java.util.Date;

public class Paper {
    private Integer id;

    private Date created;

    private String subject;

    private String name;

    public Paper(Integer id, Date created, String subject, String name) {
        this.id = id;
        this.created = created;
        this.subject = subject;
        this.name = name;
    }

    public Paper() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}