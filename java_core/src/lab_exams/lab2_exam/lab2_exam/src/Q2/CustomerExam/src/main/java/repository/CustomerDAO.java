package repository;

import exception.AppException;

public interface CustomerDAO {
    void addCustomer(Customer customer) throws AppException;
    Customer getCustomerById(int id) throws AppException;
}


