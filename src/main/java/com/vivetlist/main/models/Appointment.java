package com.vivetlist.main.models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "appointments")
@JsonPropertyOrder({"name", "start", "location"})
public class Appointment {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @JsonProperty("name")
    @Column(nullable = false)
    private String doctor_name;

    @Column(nullable = false)
    private String location;

    @Column
    @JsonProperty("start")
//    @JsonFormat(
//            shape = JsonFormat.Shape.STRING,
//            pattern = "dd-MM-yyyy")
    private Date date_time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    public Appointment(long id, String doctor_name, String location, Date date_time, User user){
        this.id = id;
        this.doctor_name = doctor_name;
        this.location = location;
        this.date_time = date_time;
        this.user = user;
    }

    public Appointment(String doctor_name, String location, Date date_time, User user){
        this.doctor_name = doctor_name;
        this.location = location;
        this.date_time = date_time;
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

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }
}
