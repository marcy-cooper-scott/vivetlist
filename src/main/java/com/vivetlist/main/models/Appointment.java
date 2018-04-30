package com.vivetlist.main.models;

import javax.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String doctor_name;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Appointment(long id, String doctor_name, String location, User user){
        this.id = id;
        this.doctor_name = doctor_name;
        this.location = location;
        this.user = user;
    }

    public Appointment(String doctor_name, String location, User user){
        this.doctor_name = doctor_name;
        this.location = location;
        this.user = user;
    }

    public Appointment(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
