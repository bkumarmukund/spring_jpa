package com.freemyip.c0de;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Employee;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

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

            // how find works vs getReference
            // var emp1 = em.find(Employee.class, 2);

            Employee emp = new Employee();
            emp.setName("userA");
            emp.setAddress("madihalli");

            em.persist(emp);
            
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}