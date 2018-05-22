package com.zly.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class Admin {
    private Integer id;

    @NotEmpty(message = "账号不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String cickname;

    private Date created;

    public Admin(Integer id, String username, String password, String cickname, Date created) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cickname = cickname;
        this.created = created;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCickname() {
        return cickname;
    }

    public void setCickname(String cickname) {
        this.cickname = cickname == null ? null : cickname.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}