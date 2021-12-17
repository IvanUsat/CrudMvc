package web.hiber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.hiber.dao.UserDao;
import web.hiber.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
         userDao.updateUser(user);
    }

    @Override
    public User getUserLastName(String lastname) {
        return userDao.getUserLastName(lastname);
    }

    @Override
    public boolean setUserAge(int age, Long id) {
        return userDao.setUserAge(age, id) > 0;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void removeUser(User user) {
        userDao.removeUser(user);
    }
}

