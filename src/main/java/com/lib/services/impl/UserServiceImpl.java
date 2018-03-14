package com.lib.services.impl;

import com.lib.model.dao.impl.UserDAOImpl;
import com.lib.model.dao.interfaces.BookDAO;
import com.lib.model.dao.interfaces.UserDAO;
import com.lib.model.pojo.User;
//import com.lib.model.utils.DataSourceFactory;
import com.lib.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;


    @Override
    public boolean register(String userName, String password) throws SQLException {
        return userDAO.addUser(userName, password);
    }

    @Override
    public boolean authenticate(String userName, String password) throws SQLException {
        return userDAO.getUserByNameAndPassword(userName, password);
    }
}
