package service;

import model.User;
import repository.ImplUser;

import java.util.Collections;
import java.util.List;

public class ServiceUser implements IServiceUser {
    // laay ket qua tu co so du lieu ve
    ImplUser impl = new ImplUser();

    @Override
    public List<User> showAllUser() {

        List<User> users = impl.showAllUser();
        return users;
    }

    @Override
    public User findUserId(int id) {
        User user = impl.findUserId(id);
        return user;
    }

    @Override
    public void createUser(User user) {
         impl.createUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        boolean result  = impl.updateUser(user);
        return result;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean result  = impl.deleteUser(id);
        return result;
    }
    public void createTransaction(User user,List<Integer> permision){
        impl.createTransaction(user,permision);
    };
}
