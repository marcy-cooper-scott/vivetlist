package com.vivetlist.main.models;

import com.fasterxml.jackson.annotation.JacksonInject;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<User> users;

    @OneToMany(mappedBy = "group")
    private List<Post> posts;

    public Group(long id, String name, List<User> users, List<Post> posts){
        this.id = id;
        this.name = name;
        this.users = users;
        this.posts = posts;
    }

    public Group(String name, List<User> users, List<Post> posts){
        this.name = name;
        this.users = users;
        this.posts = posts;
    }

    public Group(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
