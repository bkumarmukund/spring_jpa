package com.freemyip.c0de;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.freemyip.c0de.entities.Comment;
import com.freemyip.c0de.entities.Post;
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
            
            // create a post 
            Post post = new Post();
            post.setTitle("ndtv owner changed");
            post.setContent("andani became the new owner!");

            Comment c1 = new Comment();
            c1.setPost(post);
            c1.setContent("not a very good news");
            
            Comment c2 = new Comment();
            c2.setPost(post);
            c2.setContent("ndtv is now managed by non media person");
            
            Comment c3 = new Comment();
            c3.setPost(post);
            c3.setContent("ndtv now on path of other media houses");

            post.setComments(List.of(c1,c2,c3));
            

            em.persist(c3);
            em.persist(c2);
            em.persist(c1);

            em.persist(post);


            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error connecting to DB: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}