package com.lib.services.interfaces;

import com.lib.model.pojo.Book;
import com.lib.model.pojo.User;

import java.util.List;

public interface BookService {
    List<Book> getUserBooks(String username);
    List<Book> getAllBooks();
    boolean saveBookByUserName(String username, int bookId);
    boolean removeUserBook(String username, int bookId);
}
