package org.keepgoodness.ProfileOrganizer.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_ADDRESSES")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "numeric(10)", nullable = false)
    private long id;

    @Column(name = "ADDR_TYPE", length = 5)
    private String addrType;

    @Column(name = "ADDR_INFO", length = 300, nullable = true)
    private String addrInfo;

    @ManyToOne
    @JoinColumn(name = "T_PEOPLE_ID", nullable = false)
    private Person person;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
