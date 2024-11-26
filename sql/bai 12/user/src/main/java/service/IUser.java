package service;

import model.User;

import java.util.Collection;
import java.util.List;

public interface IUser {
    User findUserId(int id);
    List<User> showAllUser();
    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    List<User> searchUserName(String name);
    List<User> sortUserName();
}
