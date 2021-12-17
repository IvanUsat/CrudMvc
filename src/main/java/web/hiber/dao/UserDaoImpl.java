package web.hiber.dao;


import org.springframework.stereotype.Repository;
import web.hiber.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceUnit
    private EntityManagerFactory em;

    public UserDaoImpl() {
    }

    @Override
    public void saveUser(User user) {
        EntityManager emf = em.createEntityManager();
        emf.getTransaction().begin();
        emf.merge(user);
        emf.getTransaction().commit();
        emf.close();
    }

    @Override
    public void updateUser(User user) {
        EntityManager emf = em.createEntityManager();
        emf.getTransaction().begin();
        emf.find(User.class, user.getId());
        emf.merge(user);
        emf.getTransaction().commit();
        emf.close();
    }

    @Override
    public User getUserLastName(String lastname) {
        EntityManager emf = em.createEntityManager();
        List<User> user = emf.createQuery("SELECT u FROM users u WHERE u.lastname =: secondname", User.class).
                setParameter("secondname", lastname).
                getResultList();
        emf.close();
        return user.get(0);
    }


    @Override
    public int setUserAge(int age, Long id) {
        EntityManager emf = em.createEntityManager();
        int ser = 0;
        try {
            emf.getTransaction().begin();
            ser =  emf.createQuery("UPDATE users u SET  u.age = : age WHERE u.id = : id").
                    setParameter("age", age).
                    setParameter("id", id).
                    executeUpdate();
            emf.getTransaction().commit();
        } catch (Exception e) {
            emf.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            emf.close();
        }
        return ser;
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager emf = em.createEntityManager();
        List<User> users = emf.createQuery("SELECT a FROM users a", User.class).getResultList();
        emf.close();
        return users;
    }

    @Override
    public void removeUser(User user) {
        EntityManager emf = em.createEntityManager();
        emf.getTransaction().begin();
        emf.find(User.class, user.getId());
        emf.remove(emf.contains(user) ? user : emf.merge(user));;
        emf.getTransaction().commit();
        emf.close();
    }
}
