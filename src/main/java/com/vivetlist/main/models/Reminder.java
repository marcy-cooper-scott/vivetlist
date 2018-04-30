package com.vivetlist.main.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reminders")
public class Reminder {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private Date scheduled_time;

    @OneToOne
    private User user;

    @OneToOne
    private Appointment appt;

    @OneToOne
    private Medicine med;

    @OneToOne
    private Notification_Time_Unit unit;

    public Reminder(long id, Date scheduled_time, User user, Appointment appt, Medicine med, Notification_Time_Unit unit){
        this.id = id;
        this.scheduled_time = scheduled_time;
        this.user = user;
        this.appt = appt;
        this.med = med;
        this.unit = unit;
    }

    public Reminder(Date scheduled_time, User user, Appointment appt, Medicine med, Notification_Time_Unit unit){
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

    public Date getScheduled_time() {
        return scheduled_time;
    }

    public void setScheduled_time(Date scheduled_time) {
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

    public Notification_Time_Unit getUnit() {
        return unit;
    }

    public void setUnit(Notification_Time_Unit unit) {
        this.unit = unit;
    }
}
