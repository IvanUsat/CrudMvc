package web.hiber.service;

import web.hiber.model.User;

import java.util.List;

public interface UserService {

     void saveUser(User user);
     void updateUser(User user);
     User getUserLastName(String lastname);
     boolean setUserAge(int age, Long id);
     List<User> getAllUsers();
     void removeUser(User user);



}
