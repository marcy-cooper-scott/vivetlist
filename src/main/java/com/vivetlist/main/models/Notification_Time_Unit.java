package com.vivetlist.main.models;

import org.aspectj.weaver.ast.Not;

import javax.persistence.*;

@Entity
@Table(name = "notification_time_unit")
public class Notification_Time_Unit {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 3)
    private String name;

    public Notification_Time_Unit(){}

    public Notification_Time_Unit(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Notification_Time_Unit(String name){
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
