package com.vivetlist.main.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column(length = 500)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Post(long id, String title, String body, User user, Group group){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.group = group;
    }

    public Post(String title, String body, User user, Group group){
        this.title = title;
        this.body = body;
        this.user = user;
        this.group = group;
    }

    public Post(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}