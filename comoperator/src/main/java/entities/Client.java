package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String name;
    private BigDecimal balance = new BigDecimal(0.00);
    private BigDecimal creditlimit = new BigDecimal(100.00);
    private Integer credittime = 5;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activatedservice> activatedservices = new ArrayList<Activatedservice>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Charge> charges = new ArrayList<Charge>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts = new ArrayList<Contact>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Credit> credits = new ArrayList<Credit>();
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deposit> deposits = new ArrayList<Deposit>();

    public Client() {
    }

    public Client(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Client(String type, String name, BigDecimal balance) {
        this.type = type;
        this.name = name;
        this.balance = balance;
    }

    public void addActivatedservice(Activatedservice activatedservice)
    {
        activatedservices.add(activatedservice);
        activatedservice.setClient(this);
    }

    public void addCharge(Charge charge)
    {
        charges.add(charge);
        charge.setClient(this);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        contact.setClient(this);
    }

    public void addCredit(Credit credit) {
        credits.add(credit);
        credit.setClient(this);
    }

    public void addDeposit(Deposit deposit)
    {
        deposits.add(deposit);
        deposit.setClient(this);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(BigDecimal creditlimit) {
        this.creditlimit = creditlimit;
    }

    public Integer getCredittime() {
        return credittime;
    }

    public void setCredittime(Integer credittime) {
        this.credittime = credittime;
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

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
