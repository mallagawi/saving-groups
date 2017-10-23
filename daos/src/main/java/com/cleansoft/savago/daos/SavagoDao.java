package com.cleansoft.savago.daos;

import com.cleansoft.savago.dbentities.Groups;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class SavagoDao {
    public EntityManager entityManager;
    EntityManagerFactory factory;

    public SavagoDao() {
        factory = Persistence.createEntityManagerFactory("savagodao");
        this.entityManager = factory.createEntityManager();
    }

    public static void main(String[] args) {
        SavagoDao dao = new SavagoDao();
        Groups groups = new Groups();
        dao.entityManager.persist(groups);

    }
}
