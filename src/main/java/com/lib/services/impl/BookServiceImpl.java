package com.lib.services.impl;

import com.lib.model.dao.interfaces.BookDAO;
import com.lib.model.pojo.Book;
import com.lib.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;

    public List<Book> getUserBooks(String userName) {
        return bookDAO.getUserBooks(userName);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public boolean saveBookByUserName(String userName, int bookId) {
        try {
            return bookDAO.addUserBook(userName, bookId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeUserBook(String userName, int bookId) {
        return false;
    }
}
