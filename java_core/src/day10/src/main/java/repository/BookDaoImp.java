package repository;

import exceptions.DaoException;
import factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BookDaoImp implements BookDao {

    @Override
    public List<Book> getAllBooks() throws DaoException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching books", e);
        }
        return books;
    }

    @Override
    public Book addBook(Book book) throws DaoException {
        String query = "INSERT INTO books (isbn, title, author, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
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
            throw new DaoException("Error adding book", e);
        }
        return book;
    }

    @Override
    public void deleteBook(int id) throws DaoException {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error deleting book", e);
        }
    }

    @Override
    public void updateBook(int id, Book book) throws DaoException {
        String query = "UPDATE books SET isbn = ?, title = ?, author = ?, price = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setDouble(4, book.getPrice());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error updating book", e);
        }
    }

    @Override
    public Book getBookById(int id) throws DaoException {
        String query = "SELECT * FROM books WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error fetching book by id", e);
        }
        return null;
    }
}