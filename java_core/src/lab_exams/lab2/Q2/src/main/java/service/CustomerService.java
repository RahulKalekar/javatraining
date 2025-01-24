package service;

import exception.AppException;
import repository.Customer;
import repository.CustomerDAO;
import repository.CustomerDAOImpl;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService() {
        customerDAO = new CustomerDAOImpl();
    }

    public void addCustomer(Customer customer) throws AppException {
        try {
            customerDAO.addCustomer(customer);
        } catch (AppException e) {
            throw new AppException("at seervice Failed to add customer", e);
        }
    }

    public Customer getCustomerById(int id) throws AppException {
        try {
            return customerDAO.getCustomerById(id);
        } catch (AppException e) {
            throw new AppException("at service Failed to fetch customer by ID", e);
        }
    }
}
