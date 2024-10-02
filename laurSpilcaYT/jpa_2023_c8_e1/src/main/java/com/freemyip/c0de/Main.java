package com.freemyip.c0de;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Book;
import com.freemyip.c0de.entities.ElectronicDevice;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import net.datafaker.Faker;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create");

        // grab data from database

        // persistence using programatic approach no xml
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            Book book1 = new Book();
            book1.setAuthor(faker.book().author());
            book1.setGenre(faker.book().genre());
            book1.setTitle(faker.book().title());
            book1.setName("bookOne");

            Book book2 = new Book();
            book2.setAuthor(faker.book().author());
            book2.setGenre(faker.book().genre());
            book2.setTitle(faker.book().title());
            book2.setName("bookTwo");

            ElectronicDevice device1 = new ElectronicDevice();
            device1.setBackup(false);
            device1.setName(faker.electricalComponents().active());
            device1.setPowerSource("mains");

            ElectronicDevice device2 = new ElectronicDevice();
            device2.setBackup(false);
            device2.setName(faker.electricalComponents().active());
            device2.setPowerSource("mains");

            em.persist(device2);
            em.persist(device1);

            em.persist(book1);
            em.persist(book2);

            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}