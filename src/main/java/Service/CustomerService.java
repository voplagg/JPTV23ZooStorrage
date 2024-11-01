package Service;

import Magazin.Customer;
import Magazin.CustomerManager;
import Magazin.Order;
import Magazin.PetStore;

import java.util.List;

public class CustomerService {
    private CustomerManager customerManager;

    public CustomerService(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public void addCustomer(String name, String phone) {
        Customer customer = new Customer(name, phone);
        customerManager.addCustomer(customer);
        PetStore.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerManager.getCustomers();
    }

    public Customer findCustomerByName(String name) {
        return customerManager.getCustomerByName(name);
    }

    public List<Order> getOrdersByCustomer(Customer customer) {
        return customerManager.getOrdersByCustomer(customer);
    }
}

