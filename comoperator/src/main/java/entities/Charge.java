package entities;

import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal sum;
    private Timestamp time;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Service service;

    public Charge() {
    }

    public Charge(BigDecimal sum, Timestamp time) {
        this.sum = sum;
        this.time = time;
    }

    public Charge(BigDecimal sum, Timestamp time, Client client, Service service) {
        this.sum = sum;
        this.time = time;
        service.addCharge(this);
        client.addCharge(this);
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
