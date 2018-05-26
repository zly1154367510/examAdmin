package com.zly.model;

import java.util.List;

public class TestPaper {
    private Integer id;

    private Integer pId;

    private Integer qId;

    private Paper paper;

    private SelectQuestion selectQuestion;

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public SelectQuestion getSelectQuestion() {
        return selectQuestion;
    }

    public void setSelectQuestion(SelectQuestion selectQuestion) {
        this.selectQuestion = selectQuestion;
    }

    public TestPaper(Integer id, Integer pId, Integer qId) {
        this.id = id;
        this.pId = pId;
        this.qId = qId;
    }

    public TestPaper() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }
}