package com.learninglog.learninglogproject.topic.model;

import java.sql.Timestamp;

public class Topic {
    private int id;
    private String name;
    private int user_id;
    private Timestamp CreatedAt;

    public Topic(int id, String name, int user_id, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        CreatedAt = createdAt;
    }

    public Topic (){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        CreatedAt = createdAt;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
