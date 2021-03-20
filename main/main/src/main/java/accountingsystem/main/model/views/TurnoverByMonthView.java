package accountingsystem.main.model.views;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Subselect("select * from public.turnover_by_month")
@Immutable
public class TurnoverByMonthView {

    @Id
    @Column(name="company_id")
    private Long companyId;

    private Long month;

    private Long year;

    private Long amount;

    public TurnoverByMonthView() {
    }

    public TurnoverByMonthView(Long month, Long year, Long amount) {
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
