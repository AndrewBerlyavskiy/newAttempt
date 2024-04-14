package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Component
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void userRemoval(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }
    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser (User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById (Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> listOfUsers () {
        try {
            return entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }
}
