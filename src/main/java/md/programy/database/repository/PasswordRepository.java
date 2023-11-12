package md.programy.database.repository;

import md.programy.database.model.Password;
import md.programy.database.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PasswordRepository {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thePersistenceUnit");
    private EntityManager entityManager = factory.createEntityManager();

    public static EntityManagerFactory getFactory() {
        return factory;
    }

    public static void setFactory(EntityManagerFactory factory) {
        PasswordRepository.factory = factory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createDefaultPassword(String name, String link,String login,String password,String description) {
        Password pass = new Password();
        pass.setLink(link);
        pass.setName(name);
        pass.setLogin(login);
        pass.setPassword(password);
        pass.setDescription(description);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        this.entityManager.persist(pass);
        transaction.commit();
    }
    public List<Password> getAllPassword() {
        List<Password> passwordList;
        passwordList= entityManager.createQuery("Select p from Password p order by id").getResultList();
        return passwordList;
    }
}
