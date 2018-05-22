package com.zly.model;

import java.util.List;

public class SelectQuestion {
    private Integer id;

    private String subject;

    private String type;

    private String memo;

    private String title;

    private List<SelectItem> itemList;

    public List<SelectItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<SelectItem> itemList) {
        this.itemList = itemList;
    }

    public SelectQuestion(Integer id, String subject, String type, String memo, String title) {
        this.id = id;
        this.subject = subject;
        this.type = type;
        this.memo = memo;
        this.title = title;
    }

    public SelectQuestion() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}