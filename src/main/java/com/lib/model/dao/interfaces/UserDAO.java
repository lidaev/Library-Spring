package com.lib.model.dao.interfaces;

import java.sql.SQLException;

public interface UserDAO {
    boolean getUserByNameAndPassword(String username, String password);
    boolean addUser(String userName, String password) throws SQLException;

}
