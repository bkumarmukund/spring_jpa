package com.freemyip.c0de;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.dto.EnrolledStudent;
import com.freemyip.c0de.entities.Student;
import com.freemyip.c0de.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none");

        // grab data from database

        // persistence using programatic approach no xml
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // joins and inner queries
            // ---joins---
            // inner join
            /*
             * String jpql = """
             * SELECT s, e FROM Student s INNER JOIN s.enrollments e
             * """;
             * TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
             * q.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));
             */

            // join
            /*
             * String jpql = """
             * SELECT s, e FROM Student s, Enrollment e WHERE s.id = e.student.id
             * """;
             * TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
             * q.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));
             */

            // join
            /*
             * String jpql = """
             * SELECT s, e FROM Student s, Enrollment e WHERE s = e.student
             * """;
             * TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
             * q.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));
             */

            // using dto for projection instead of object array
            /*
             * String jpql = """
             * SELECT NEW com.freemyip.c0de.dto.EnrolledStudent(s, e) FROM Student s LEFT
             * JOIN s.enrollments e
             * """;
             * TypedQuery<EnrolledStudent> q = em.createQuery(jpql, EnrolledStudent.class);
             * q.getResultList().forEach(o -> System.out.println(o.student() + " " +
             * o.enrollment()));
             */

            // ---inner query---
            // using dto for projection
            // student who are enrolled in more than one course
            /*
             * String jpql = """
             * SELECT s FROM Student s WHERE
             * (SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = s.id)
             * > 1
             * """;
             * TypedQuery<Student> q = em.createQuery(jpql, Student.class);
             * q.getResultList().forEach(System.out::println);
             */

            // student with number of courses enrolled
            /* String jpql = """
                    SELECT s,(SELECT count(e) FROM Enrollment e WHERE e.student = s)
                    FROM Student s
                    """;
            TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
            q.getResultList().forEach(o -> System.out.println(o[0] + "\n\t number of course:" + o[1])); */

            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("\nerror from query: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}