package accountingsystem.main.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Turnover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDateTime date;
    private Long price;
    @Column(name="number_products")
    private Integer numberProducts;
    @Column(name="sum_profit")
    private Long sumProfit;
    @ManyToMany
    private List<WorkService> workServiceList;
    @ManyToMany
    private List<Product> productList;
    @ManyToOne
    private Company company;

    public Turnover(LocalDateTime date, Long price, Integer numberProducts, Long sumProfit, List<WorkService> workServiceList,
                    List<Product> productList, Company company) {
        this.date = date;
        this.price = price;
        this.numberProducts = numberProducts;
        this.sumProfit = sumProfit;
        this.workServiceList = workServiceList;
        this.productList = productList;
        this.company = company;
    }

    public List<WorkService> getWorkServiceList() {
        return workServiceList;
    }

    public void setWorkServiceList(List<WorkService> workServiceList) {
        this.workServiceList = workServiceList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Turnover() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
