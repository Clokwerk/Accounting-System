package accountingsystem.main.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String founder;
    @ManyToMany
    private List<Product> products;
    @ManyToMany
    private List<Service> services;
    private String address;
    @Column(name="incorporation_date")
    private String incorporationDate;
    @Column(name="tax_number")
    private String taxNumber;
    @Column(name="registered_number")
    private String registeredNumber;

    public Company(Long id, String name, String founder, String address, String incorporationDate, String taxNumber,
                   String registeredNumber) {
        Id = id;
        this.name = name;
        this.founder = founder;
        this.address = address;
        this.incorporationDate = incorporationDate;
        this.taxNumber = taxNumber;
        this.registeredNumber = registeredNumber;
    }

    public Company() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIncorporationDate() {
        return incorporationDate;
    }

    public void setIncorporationDate(String incorporationDate) {
        this.incorporationDate = incorporationDate;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(String registeredNumber) {
        this.registeredNumber = registeredNumber;
    }
}
