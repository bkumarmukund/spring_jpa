package com.freemyip.c0de;

import java.util.HashMap;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Product;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n\n\n\n");

        // two ways to get EntityManagerFacotry

        // if we are using persistence xml file
        // EntityManagerFactory emf =
        // Persistence.createEntityManagerFactory("my-persistence-unit");

        // persistence using programatic approach no xml
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(), new HashMap<>());
        

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Generate data
            Product product = new Product();
            product.setId(2L);
            product.setName("Milk Shake");

            em.persist(product); // add thi to the context -> this is not INSERT QUERY

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}