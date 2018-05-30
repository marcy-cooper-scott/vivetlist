package com.vivetlist.main.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Column(nullable = false)
    private Instant scheduled_time;

    @OneToOne
    @JsonManagedReference
    private User user;

    @OneToOne
    @JsonManagedReference
    private Appointment appt;

    @OneToOne
    @JsonManagedReference
    private Medicine med;

    @OneToOne
    @JsonManagedReference
    private Notification_Type unit;

    public Reminder(long id, Instant scheduled_time, User user, Appointment appt, Medicine med, Notification_Type unit){
        this.id = id;
        this.scheduled_time = scheduled_time;
        this.user = user;
        this.appt = appt;
        this.med = med;
        this.unit = unit;
    }

    public Reminder(Instant scheduled_time, User user, Appointment appt, Medicine med, Notification_Type unit){
        this.scheduled_time = scheduled_time;
        this.user = user;
        this.appt = appt;
        this.med = med;
        this.unit = unit;
    }

    public Reminder(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getScheduled_time() {
        return scheduled_time;
    }

    public void setScheduled_time(Instant scheduled_time) {
        this.scheduled_time = scheduled_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Appointment getAppt() {
        return appt;
    }

    public void setAppt(Appointment appt) {
        this.appt = appt;
    }

    public Medicine getMed() {
        return med;
    }

    public void setMed(Medicine med) {
        this.med = med;
    }

    public Notification_Type getUnit() {
        return unit;
    }

    public void setUnit(Notification_Type unit) {
        this.unit = unit;
    }
}
