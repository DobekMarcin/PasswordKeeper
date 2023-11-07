package md.programy.database.repository;

import md.programy.database.model.User;

import javax.persistence.*;

public class UserRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private EntityManager entityManager = factory.createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long getAllUserCount() {
        Long result= (Long) entityManager.createQuery("Select count(*) from User",Long.class).getSingleResult();
        return result;
    }


    public void createAdmin(String login, String password) {
        User admin = new User();
        admin.setLogin(login);
        admin.setPassword(password);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(admin);
        transaction.commit();
    }

    public Integer deleteAllUser() {
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        Integer result= entityManager.createQuery("Delete from User",Integer.class).executeUpdate();
        transaction.commit();
        return result;
    }

    public Long checkUser(String login,String password){
        Query query=entityManager.createQuery("Select count(*) from User where login= :userLogin and password=:userPassword",Long.class);
        query.setParameter("userLogin",login);
        query.setParameter("userPassword",password);
        Long result = (Long) query.getSingleResult();
        return result;
    }
}
