package com.zly.model;

import java.util.Date;
import java.util.List;

public class OnPerPaper {
    private Integer id;

    private String username;

    private Integer paper;

    private Integer item;

    private String answer;

    private String time;

    private Paper papers;

    private Date created;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Paper getPapers() {
        return papers;
    }

    public void setPapers(Paper papers) {
        this.papers = papers;
    }

    public List<OnPerPaper> onPerPapers;

    public List<OnPerPaper> getOnPerPapers() {
        return onPerPapers;
    }

    public void setOnPerPapers(List<OnPerPaper> onPerPapers) {
        this.onPerPapers = onPerPapers;
    }

    public OnPerPaper(Integer id, String username, Integer paper, Integer item, String answer, String time) {
        this.id = id;
        this.username = username;
        this.paper = paper;
        this.item = item;
        this.answer = answer;
        this.time = time;
    }

    public OnPerPaper() {
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

    public Integer getPaper() {
        return paper;
    }

    public void setPaper(Integer paper) {
        this.paper = paper;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}