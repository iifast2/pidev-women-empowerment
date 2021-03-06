//User.java

package com.pidevteam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    @NotNull
    @Size(min = 3, message = "Username Length Should Be At Least 3!")
    private String username;

    @Column
    @JsonIgnore
    @NotNull
    @Size(min = 3, message = "Password Length Should Be At Least 3!")
    private String password;

    @Column
    //@NotNull
    private String birthdate;

    private String address;


    //@Column(unique = true)
    private String email;


    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Notification> notifications;

    @ManyToOne
    private Subscription subscriptions;
    @Enumerated(EnumType.STRING)
    private  Etat etat ;

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    @JsonIgnoreProperties("users")
    private List<Role> roles = new ArrayList<>();
    private  String phone ;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Publicity> publicities ;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Publication> publications ;

    @OneToMany(mappedBy="user")
    @JsonIgnore
    List<Certificat> certificats;


    @ManyToMany ()
    //hethi  zdtha ena
    @JoinTable(name = "USER_formation", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "Formation_ID") })
    List<Formation> formations;
/// hethii yousser
@OneToMany(mappedBy = "user")
private List<Appointment> appointments ;
    @OneToMany(mappedBy = "user")
    private List<Reclamation> reclamations ;
///hethii taysir
@ManyToMany(cascade = CascadeType.ALL)
@JsonIgnore
@JoinTable(name = "USER_EVENT", joinColumns = {
        @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
        @JoinColumn(name = "EVENT_ID") })
List<Events> events ;

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Reclamation> getReclamations() {
        return reclamations;
    }

    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }

    public List<Certificat> getCertificats() {
        return certificats;
    }

    public void setCertificats(List<Certificat> certificats) {
        this.certificats = certificats;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Publicity> getPublicities() {
        return publicities;
    }

    public void setPublicities(List<Publicity> publicities) {
        this.publicities = publicities;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Subscription getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscription subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
// @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // @JsonIgnoreProperties("user")
    //  private List<Request> requests;

    //  public List<Request> getRequests() {
    //    return requests;
    //}

    //public void setRequests(List<Request> requests) {
    //     this.requests = requests;
    //}

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


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Notification> getNotifications() {

        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}