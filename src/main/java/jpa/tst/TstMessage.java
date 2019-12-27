package jpa.tst;

import jpa.entity.TextMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TstMessage {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("ormLesson");
        EntityManager manager = factory.createEntityManager();


        manager.getTransaction().begin();

        TextMessage textMessage = new TextMessage();
        textMessage.setAuthor("author");
        textMessage.setText("some text");
        textMessage.setSent(new GregorianCalendar());




    }
}
