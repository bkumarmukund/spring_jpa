package com.freemyip.c0de;

import java.util.HashMap;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Employee;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {

        // grab data from database

        // persistence using programatic approach no xml
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(), new HashMap<>());

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Employee employee = em.find(Employee.class, 2);

            // employee.setName("thanda pani"); the data in database is also changed due to context
            /*
            employee.setName("gurmeet");
            employee.setName("thanda pani");
            // here no database query is executed as the context is aware that the entity instance is the original instance after modifying it twice, hence no need to update in database.
            */
            System.out.println(employee);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}