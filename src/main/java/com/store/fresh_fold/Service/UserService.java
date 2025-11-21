package com.store.fresh_fold.Service;

import com.store.fresh_fold.DAO.UserDAO;
import com.store.fresh_fold.Model.User;

public class UserService {
    UserDAO userDAO;

    public UserService () {
        userDAO = new UserDAO();
    }

    public boolean userLogin(String userName, String password) {
        return userDAO.checkUser(userName,password);
    }

    public boolean addUser(User user) {
        return userDAO.createUser(user);
    }

    public User getUserByUserName(String userName) {
        return userDAO.getUserByUserName(userName);
    }
}




