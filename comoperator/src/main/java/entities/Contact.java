package entities;

import javax.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String description;
    @ManyToOne
    private Client client;

    public Contact() {
    }

    public Contact(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public Contact(String type, String description, Client client) {
        this.type = type;
        this.description = description;
        client.addContact(this);
    }

    /* Getters and setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
