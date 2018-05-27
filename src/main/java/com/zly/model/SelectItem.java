package com.zly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SelectItem {
    private Integer id;

    private Integer selectQuestionId;


    @JsonIgnore
    private Boolean isanswer;

    private String content;

    private String memo;

    public SelectItem(Integer id, Integer selectQuestionId, Boolean isanswer, String content, String memo) {
        this.id = id;
        this.selectQuestionId = selectQuestionId;
        this.isanswer = isanswer;
        this.content = content;
        this.memo = memo;
    }

    public SelectItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelectQuestionId() {
        return selectQuestionId;
    }

    public void setSelectQuestionId(Integer selectQuestionId) {
        this.selectQuestionId = selectQuestionId;
    }

    public Boolean getIsanswer() {
        return isanswer;
    }

    public void setIsanswer(Boolean isanswer) {
        this.isanswer = isanswer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}