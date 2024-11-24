package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerImpl implements ICustomer{
    private static Map<Integer,Customer> customers = new HashMap<>();
    static {
        customers.put(1,new Customer(1,"tuan anh1","anh@gmail.com","nghe an"));
        customers.put(2,new Customer(2,"tuan anh2","anh@gmail.com","nghe an"));
        customers.put(3,new Customer(3,"tuan anh3","anh@gmail.com","nghe an"));
        customers.put(4,new Customer(4,"tuan anh4","anh@gmail.com","nghe an"));
        customers.put(5,new Customer(5,"tuan anh5","anh@gmail.com","nghe an"));

    }

    public static Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(Map<Integer, Customer> customers) {
        CustomerImpl.customers = customers;
    }

    public void add(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public ArrayList<Customer> showAllCustomers() {
        ArrayList<Customer> customersList = new ArrayList<>();
        customersList.addAll(customers.values());
        return customersList;
    }

    @Override
    public Customer showCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if(customers.containsKey(id)){
                return customers.get(id);
            }
        }
        return null;
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
            if(customers.containsKey(id)){
                customers.replace(id,customers.get(id),customer);
            }
    }

    @Override
    public void deleteCustomer(int id) {
            if(customers.containsKey(id)){
                customers.remove(id);
            }
    }
}
