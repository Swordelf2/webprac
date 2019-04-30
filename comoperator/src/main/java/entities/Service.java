package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String tariffdescription;
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activatedservice> activatedservices = new ArrayList<Activatedservice>();
    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Charge> charges = new ArrayList<Charge>();

    public Service() {
    }

    public Service(String name, String description, String tariffdescription) {
        this.name = name;
        this.description = description;
        this.tariffdescription = tariffdescription;
    }

    public void addActivatedservice(Activatedservice activatedservice)
    {
        activatedservices.add(activatedservice);
        activatedservice.setService(this);
    }

    public void addCharge(Charge charge)
    {
        charges.add(charge);
        charge.setService(this);
    }

    /* Getters and setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTariffdescription() {
        return tariffdescription;
    }

    public void setTariffdescription(String tariffdescription) {
        this.tariffdescription = tariffdescription;
    }

    public List<Activatedservice> getActivatedservices() {
        return activatedservices;
    }

    public void setActivatedservices(List<Activatedservice> activatedservices) {
        this.activatedservices = activatedservices;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
