package com.freemyip.c0de;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Product;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        // props.put("hibernate.hbm2ddl.auto", "none");

        // grab data from database

        // persistence using programatic approach no xml
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // jpql queries
            // String jpql = "SELECT p FROM Product p";
            // String jpql = "SELECT p FROM Product p WHERE p.price > 50";
            /*
             * String jpql =
             * "SELECT p FROM Product p WHERE p.price > :price AND p.name LIKE :name";
             * q.setParameter("price", 20);
             * q.setParameter("name", "%ui%");
             * TypedQuery<Product> q = em.createQuery(jpql, Product.class);
             * List<Product> productList = q.getResultList();
             * productList.forEach(System.out::println);
             */
            // functions
            /*
             * String jpql = "SELECT AVG(p.price) FROM Product p";
             * TypedQuery<Double> q = em.createQuery(jpql, Double.class);
             * List<Double> productList = q.getResultList();
             * productList.forEach(System.out::println);
             */

            /*
             * String jpql = "SELECT p.name, p.price FROM Product p";
             * TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
             * List<Object[]> productList = q.getResultList();
             * productList.forEach(object -> {
             * System.out.println(object[0]+"____"+object[1]);
             * });
             */

            /*
             * String jpql = "SELECT p.name, AVG(p.price) FROM Product p GROUP BY p.name";
             * TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
             * List<Object[]> productList = q.getResultList();
             * productList.forEach(object -> {
             * System.out.println(object[0]+"____"+object[1]);
             * });
             */

            // handling null value when using getSingleResult()
            /*
             * String jpql = "SELECT p FROM Product p WHERE p.price < 0";
             * TypedQuery<Product> q = em.createQuery(jpql, Product.class);
             * Optional<Product> p;
             * try {
             * p = Optional.of(q.getSingleResult());
             * } catch (NoResultException e) {
             * p = Optional.empty();
             * }
             * p.ifPresentOrElse(System.out::println, () ->
             * System.out.println("not found"));
             */

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}