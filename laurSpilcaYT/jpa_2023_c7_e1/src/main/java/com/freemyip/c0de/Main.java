package com.freemyip.c0de;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Group;
import com.freemyip.c0de.entities.User;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        // props.put("hibernate.hbm2ddl.auto", "create");

        // grab data from database

        // persistence using programatic approach no xml
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            User u1 = new User();
            u1.setName("samuel");

            User u2 = new User();
            u2.setName("thomson");

            Group g1 = new Group();
            g1.setName("home");
            
            Group g2 = new Group();
            g2.setName("work");
            
            g1.setUsers(List.of(u1,u2));
            g2.setUsers(List.of(u2));

            em.persist(u1);
            em.persist(u2);
            em.persist(g1);
            em.persist(g2);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}