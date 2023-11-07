package md.programy.database.repository;

import javax.persistence.EntityManager;

public class UserRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
