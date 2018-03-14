package com.lib.model.dao.interfaces;

import com.lib.model.pojo.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
    List<Book> getUserBooks(String userName);
    List<Book> getAllBooks();
    boolean removeUserBook(String userName, String title);
    boolean addUserBook(String userName, int bookid) throws SQLException;
}
