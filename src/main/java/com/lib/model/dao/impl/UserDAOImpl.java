package com.lib.model.dao.impl;

import com.lib.model.dao.interfaces.UserDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean getUserByNameAndPassword(String userName, String password) {
        boolean isValid = false;

        System.out.println("USER NAME: " + userName);
        String query = "SELECT name, pass FROM users WHERE name = ? AND pass =?;";

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, password);

            System.out.println("HERE IS STATEMENt:" + statement);
            ResultSet resultSet = statement.executeQuery();

            isValid = resultSet.next();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    public boolean addUser(String userName, String password) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            if (!getUserByNameAndPassword(userName, password)) {
                String query = "INSERT into users (name, pass) VALUES ('" + userName + "', '" + password + "')";
                System.out.println("QUERY:" + query);
                PreparedStatement ps = connection.prepareStatement(query);
                ps.executeUpdate();
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
