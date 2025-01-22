package web;

import exception.AppException;
import repository.Customer;
import service.CustomerService;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer();
        customer.setName("Rahul");
        customer.setAddress("Kalaburagi");
        customer.setPhoneNumber("7022395345");

        try {
            customerService.addCustomer(customer);
            System.out.println("Customer added successfully with ID: " + customer.getId());
        } catch (AppException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            Customer fetchedCustomer = customerService.getCustomerById(2);
            if (fetchedCustomer != null) {
                System.out.println("Customer found: " + fetchedCustomer.getName());
            } else {
                System.out.println("Customer not found.");
            }
        } catch (AppException e) {
            System.err.println("error:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
