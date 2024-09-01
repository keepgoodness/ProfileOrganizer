package org.keepgoodness.ProfileOrganizer.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_MAILS")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "numeric(10)", nullable = false)
    private Long id;

    @Column(name = "EMAIL_TYPE", length = 5, nullable = false)
    private String emailType;

    @Column(name = "EMAIL", length = 40)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "T_PEOPLE_ID")
    private Person person;

    public Email() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
