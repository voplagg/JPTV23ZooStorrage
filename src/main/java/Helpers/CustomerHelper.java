package Helpers;

import Magazin.Customer;
import Magazin.CustomerManager;

public class CustomerHelper {
    private CustomerManager customerManager;

    public CustomerHelper(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void addCustomer(String name, String phone) {
        Customer customer = new Customer(name, phone);
        customerManager.addCustomer(customer);
    }

    public Customer findCustomerByName(String name) {
        return customerManager.getCustomerByName(name);
    }
}

