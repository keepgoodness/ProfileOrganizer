package org.keepgoodness.ProfileOrganizer.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_PEOPLE")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "numeric(10)", nullable = false)
    private long id;

    @Column(name = "FULL_NAME", length = 90, nullable = false)
    private String fullName;

    @Column(name = "PIN", length = 10)
    private String pin;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> mails = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Address> addresses = new ArrayList<>();

    public Person() {
    }

    public Person(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;
    }

    public Person(String fullName, String pin, List<Email> mails) {
        this.fullName = fullName;
        this.pin = pin;
        this.mails = mails;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<Email> getMails() {
        return mails;
    }

    public void setMails(List<Email> emails) {
        this.mails = emails;
    }

    public void addMail(Email email){
        this.mails.add(email);
        email.setPerson(this);
    }

    public void removeMail(Email email){
        this.mails.remove(email);
        email.setPerson(null);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address){
        this.addresses.add(address);
        address.setPerson(this);
    }

    public void removeAddress(Address address){
        this.addresses.remove(address);
        address.setPerson(null);
    }
}
