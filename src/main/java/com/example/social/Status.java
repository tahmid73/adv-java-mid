package com.example.social;

public class Status {
    private String status;
    private int id;
    private int user_id;
    private String created_on;
    private int like;

    public Status(String status, int id, int user_id, int like,String created_on) {
        this.status = status;
        this.id=id;
        this.user_id=user_id;
        this.created_on=created_on;
        this.like=like;
    }
    public Status(String status, int id, int user_id) {
        this.status = status;
        this.id=id;
        this.user_id=user_id;
    }

    public Status(String status, int like) {
        this.status = status;
        this.like=like;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public int getLike() { return like;}

    public void setLike(int like) { this.like = like; }
}
