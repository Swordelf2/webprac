package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal sum;
    private Date startdate;
    private Date enddate;
    @ManyToOne
    private Client client;

    public Credit() {
    }

    public Credit(BigDecimal sum, Date startdate, Date enddate) {
        this.sum = sum;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public Credit(BigDecimal sum, Date startdate, Date enddate, Client client) {
        this.sum = sum;
        this.startdate = startdate;
        this.enddate = enddate;
        client.addCredit(this);
    }

    /* Getters and setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
