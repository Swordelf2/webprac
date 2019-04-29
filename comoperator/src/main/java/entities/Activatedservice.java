package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Activatedservice implements Serializable {
    @Id
    @ManyToOne
    private Client client;
    @Id
    private String number;
    @Id
    @ManyToOne
    private Service service;
    private Timestamp starttime;
    private Timestamp endtime;

    /* Getters and setters */
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activatedservice that = (Activatedservice) o;
        return client.equals(that.client) &&
                number.equals(that.number) &&
                service.equals(that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, number, service);
    }
}
