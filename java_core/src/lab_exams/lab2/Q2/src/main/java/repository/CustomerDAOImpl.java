package repository;


import exception.AppException;
import factory.ConnectionFactory;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {

    private ConnectionFactory connectionFactory;

    public CustomerDAOImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public void addCustomer(Customer customer) throws AppException {
        String sql = "INSERT INTO customer (name, address, phone_number) VALUES (?, ?, ?)";

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getAddress());
            ps.setString(3, customer.getPhoneNumber());

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        customer.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customer failed, no ID obtained.");
                    }
                }
            }

        } catch (SQLException e) {
            throw new AppException("Error adding customer", e);
        }
    }

    @Override
    public Customer getCustomerById(int id) throws AppException {
        String sql = "SELECT * FROM customer WHERE id = ?";
        Customer customer = null;

        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setPhoneNumber(rs.getString("phone_number"));
            }

        } catch (SQLException e) {
            // Wrapping SQLException into AppException before rethrowing
            throw new AppException("Error fetching customer by ID", e);
        }

        return customer;
    }
}
