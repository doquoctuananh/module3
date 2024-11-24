package service;

import model.Customer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface ICustomer {

    void add(Customer customer);
    List<Customer> showAllCustomers();
    Customer showCustomer(int id);
    void updateCustomer(int id,Customer customer);
    void deleteCustomer(int id);
}
