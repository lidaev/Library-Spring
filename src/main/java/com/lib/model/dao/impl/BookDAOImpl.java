package com.lib.model.dao.impl;

import com.lib.model.dao.interfaces.BookDAO;
import com.lib.model.pojo.Book;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BookDAOImpl implements BookDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName()); //TODO ADD EXTERNAL LOGGER
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> getUserBooks(String username) {
        ArrayList<Book> books = new ArrayList<>();

        String sql = "select books.title, books.author from users " +
                "INNER JOIN userBooks on users.id=userBooks.userid " +
                "INNER JOIN books on books.id=userBooks.bookid " +
                "where users.name='"+username+"';";

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book(resultSet.getString(1), resultSet.getString(2));
                System.out.println("ADDING A BOOK: " + resultSet.getString(1) + " " + resultSet.getString(2));
                books.add(book);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL");
            e.printStackTrace();
            }

        return books;
    }

    @Override
    public List<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();

        String sql = "select * from books;";

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"));
                books.add(book);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL");
            e.printStackTrace();
        }

        return books;
    }

    public boolean addUserBook(String userName, int bookid) throws SQLException {
        String query = "insert into userBooks (userid, bookid) select users.id, " + bookid + " from users WHERE users.name='" + userName + "';";
        System.out.println("QUERY: " + query);

        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.executeUpdate();

        return true;
    }

    @Override
    public boolean removeUserBook(String username, String title) {
        return false;
    }
}
