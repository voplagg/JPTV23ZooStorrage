package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    // Конструктор для инъекции зависимостей
    @Autowired // Это может быть опционально, если вы используете конструктор для инъекции зависимостей
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    // Метод для получения всех клиентов
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    // Метод для добавления нового клиента
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Метод для обновления клиента
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Метод для удаления клиента по ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

