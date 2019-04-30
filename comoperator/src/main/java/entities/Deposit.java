package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal sum;
    private Timestamp time;
    @ManyToOne
    private Client client;

    public Deposit() {
    }

    public Deposit(BigDecimal sum, Timestamp time) {
        this.sum = sum;
        this.time = time;
    }

    public Deposit(BigDecimal sum, Timestamp time, Client client) {
        this.sum = sum;
        this.time = time;
        client.addDeposit(this);
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
