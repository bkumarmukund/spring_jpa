package com.freemyip.c0de;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Employee;
import com.freemyip.c0de.entities.Student;
import com.freemyip.c0de.entities.keys.EmployeeKey;
import com.freemyip.c0de.entities.keys.StudentKey;
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

            // working with employee data

            EmployeeKey empId = new EmployeeKey();
            empId.setId(1);
            empId.setSerialNumber(12);

            Employee emp = new Employee();
            emp.setId(empId);
            emp.setName("userA");
            emp.setAddress("madihalli");

            em.persist(emp);

            // working with student data
            Student student = new Student();
            student.setRollNumber(234);
            student.setUniversityId(2024);
            student.setName("pranav");

            em.persist(student);

            StudentKey key = new StudentKey();
            key.setRollNumber(234);
            key.setUniversityId(2024);

            Student s = em.find(Student.class, key);
            System.out.println("student is :" + s);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}