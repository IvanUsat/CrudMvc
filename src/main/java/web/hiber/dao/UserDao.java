package web.hiber.dao;

import web.hiber.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    void updateUser(User user);
    User getUserLastName(String lastname);
    int setUserAge(int age, Long id);
    List<User> getAllUsers();
    void removeUser(User user);
}
