package accountingsystem.main.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Turnover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String date;
    private Long price;
    @Column(name="number_products")
    private Integer numberProducts;
    @Column(name="sum_profit")
    private Long sumProfit;
    @ManyToMany
    private List<Service> serviceList;
    @ManyToMany
    private List<Product> productList;
    public Turnover( String date, Long price, Integer numberProducts, Long sumProfit) {

        this.date = date;
        this.price = price;
        this.numberProducts = numberProducts;
        this.sumProfit = sumProfit;
    }

    public Turnover() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNumberProducts() {
        return numberProducts;
    }

    public void setNumberProducts(Integer numberProducts) {
        this.numberProducts = numberProducts;
    }

    public Long getSumProfit() {
        return sumProfit;
    }

    public void setSumProfit(Long sumProfit) {
        this.sumProfit = sumProfit;
    }
}
