package com.vivetlist.main.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aspectj.weaver.ast.Not;

import javax.persistence.*;

@Entity
@Table(name = "notification_type")
public class Notification_Type {

    @Id
    @GeneratedValue
    @JsonBackReference
    private long id;

    @Column(length = 5)
    private String name;

    public Notification_Type(){}

    public Notification_Type(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Notification_Type(String name){
        this.name = name;
    }

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
