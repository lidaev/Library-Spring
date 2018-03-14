package com.lib.services.interfaces;

import java.sql.SQLException;

public interface UserService {
    boolean register(String userName, String password) throws SQLException;
    boolean authenticate(String userName, String password) throws SQLException;
}
