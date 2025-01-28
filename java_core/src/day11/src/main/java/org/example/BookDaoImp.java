package org.example;

import java.io.*;
import java.sql.*;
import java.util.*;


// DAO Implementation
class BookDaoImp implements BookDao {
    private final String url;
    private final String user;
    private final String password;

    public BookDaoImp() {
        try {
            Properties properties = new Properties();
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties")) {
                if (input == null) {
                    throw new RuntimeException("Sorry, unable to find database.properties");
                }
                properties.load(input);
            }

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

            Class.forName(properties.getProperty("db.driver"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

        @Override
        public List<Book> getAllBooks() throws DaoException {
            String query = "SELECT * FROM book_table";
            List<Book> books = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    Book book = new Book(
                            rs.getString("isbn"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getDouble("price")
                    );
                    books.add(book);
                }
            } catch (SQLException e) {
                throw new DaoException("Error retrieving books");
            }

            return books;
        }

        @Override
        public void addBook(Book book) throws DaoException {
            String query = "INSERT INTO book_table (isbn, title, author, price) VALUES (?, ?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setString(1, book.getIsbn());
                pstmt.setString(2, book.getTitle());
                pstmt.setString(3, book.getAuthor());
                pstmt.setDouble(4, book.getPrice());
                pstmt.executeUpdate();

                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        book.setId(keys.getInt(1));
                    }
                }
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }

        }

        @Override
        public void deleteBook(int id) throws DaoException {
            String query = "DELETE FROM book_table WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException("Error deleting book");
            }
        }

        @Override
        public void updateBook(int id, Book book) throws DaoException {
            String query = "UPDATE book_table SET isbn = ?, title = ?, author = ?, price = ? WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, book.getIsbn());
                pstmt.setString(2, book.getTitle());
                pstmt.setString(3, book.getAuthor());
                pstmt.setDouble(4, book.getPrice());
                pstmt.setInt(5, id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException("Error updating book");
            }
        }

        @Override
        public Book getBookById(int id) throws DaoException {
            String query = "SELECT * FROM book_table WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setInt(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return new Book(
                                rs.getString("isbn"),
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getDouble("price")
                        );
                    }
                }
            } catch (SQLException e) {
                throw new DaoException("Error retrieving book by ID");
            }

            return null;
        }
    }
