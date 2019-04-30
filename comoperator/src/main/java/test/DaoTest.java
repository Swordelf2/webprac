package test;

import dao.*;
import entities.Client;
import entities.Contact;
import entities.Credit;
import entities.Deposit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class DaoTest {
    @Test
    public void MainTest()
    {
        ActivatedserviceDao activatedserviceDao = new ActivatedserviceDao();
        ChargeDao chargeDao = new ChargeDao();
        ClientDao clientDao = new ClientDao();
        ContactDao contactDao = new ContactDao();
        CreditDao creditDao = new CreditDao();
        DepositDao depositDao = new DepositDao();
        ServiceDao serviceDao = new ServiceDao();

        Date date1 = Date.valueOf("2018-12-30");
        Date date2 = Date.valueOf("2019-01-01");
        Timestamp time = Timestamp.valueOf("2019-02-01 22:22:22");

        /* Test Client and associated entities */
        Client client = new Client("I", "Evgeny");
        Contact contact = new Contact("e", "newmail@newmail.ru", client);
        Credit credit = new Credit(new BigDecimal(50.00), date1, date2, client);
        Deposit deposit = new Deposit(new BigDecimal(50.00), time, client);
        int id = clientDao.add(client);
        client = clientDao.get(id);
        Assert.assertTrue(client.getContacts().contains(contact));
        Assert.assertTrue(client.getCredits().contains(credit));
        Assert.assertTrue(client.getDeposits().contains(deposit));
    }
}
