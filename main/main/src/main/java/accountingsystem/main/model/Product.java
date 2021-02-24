package accountingsystem.main.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    private String name;
    private Long price;
    private String date;
    @Column(name="expiration_date")
    private String expirationDate;
    @ManyToOne
    private Manufacturer manufacturer;


    public Product() {
    }

    public Product(String description, String name, Manufacturer manufacturer, Long price, String date,
                   String expirationDate) {

        this.description = description;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.date = date;
        this.expirationDate = expirationDate;
    }
    public void setId(Long id) {
        Id = id;
    }
    public Long getId() {
        return Id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
