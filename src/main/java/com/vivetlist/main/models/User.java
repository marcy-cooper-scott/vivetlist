package com.vivetlist.main.models;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 100)
    private String phone_number;

    @Column(length = 100, nullable = false)
    private String time_zone;

    @Column
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isAdmin;

//    @OneToMany(mappedBy = "user")
//    private List<Appointment> appointments;

    @ManyToMany
    @JoinColumn(name = "medicine_id")
    private List<Medicine> medicines;

    @ManyToMany
    @JoinColumn(name = "group_id")
    private List<Group> groups;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(long id, String username, String password, String email, String phone_number, String time_zone, boolean isAdmin,
//                List<Appointment>appointments,
                List<Medicine>medicines, List<Group> groups, List<Post> posts){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.time_zone = time_zone;
        this.isAdmin = isAdmin;
//        this.appointments = appointments;
        this.medicines = medicines;
        this.groups = groups;
        this.posts = posts;
    }

    public User(String username, String password, String email, String phone_number, String time_zone, boolean isAdmin,
//                List<Appointment>appointments,
                List<Medicine>medicines, List<Group> groups, List<Post> posts){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.time_zone = time_zone;
        this.isAdmin = isAdmin;
//        this.appointments = appointments;
        this.medicines = medicines;
        this.groups = groups;
        this.posts = posts;
    }

    public User(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
