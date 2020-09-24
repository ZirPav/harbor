package ru.zirpav.harbor.dao;

import org.springframework.stereotype.Repository;
import ru.zirpav.harbor.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        List<User> userList = entityManager.createQuery("SELECT u FROM User u").getResultList();
        return userList;
    }

    @Override
    public User findById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null){
            entityManager.remove(user);
        }
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUserForEmail(String email) {

        User user = null;
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=:email");
            query.setParameter("email", email);
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("User not found.");
        }

        return user;
    }

    @Override
    public User findByUserForNickname(String nickName) {

        User user = null;
        try {
            Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.nickName=:nickName");
            query.setParameter("nickName", nickName);
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            System.err.println("User not found.");
        }

        return user;

    }

}
