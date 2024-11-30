package repository;

import model.User;

import java.util.List;

public interface IUser {
    List<User> showAllUser();
    User findUserId(int id);
    void createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    void createTransaction(User user,List<Integer> permision);
}
