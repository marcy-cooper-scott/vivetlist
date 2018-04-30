package com.vivetlist.main.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String medicine_name;

    @Column
    private Date refill_date;

    @Column(length = 500)
    private String notes;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<User> users;

    public Medicine(long id, String medicine_name, Date refill_date, String notes, List<User> users){
        this.id = id;
        this.medicine_name = medicine_name;
        this.refill_date = refill_date;
        this.notes = notes;
        this.users = users;
    }

    public Medicine(String medicine_name, Date refill_date, String notes, List<User> users){
        this.medicine_name = medicine_name;
        this.refill_date = refill_date;
        this.notes = notes;
        this.users = users;
    }

    public Medicine(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public Date getRefill_date() {
        return refill_date;
    }

    public void setRefill_date(Date refill_date) {
        this.refill_date = refill_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}