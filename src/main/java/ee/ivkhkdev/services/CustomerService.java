package ee.ivkhkdev.services;

import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Customer;

import java.util.List;

public class CustomerService implements Service<Customer> {
    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean print() {
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public List<Customer> list() {
        return List.of();
    }
}
