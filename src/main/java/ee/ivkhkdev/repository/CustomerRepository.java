package ee.ivkhkdev.repositories;

import ee.ivkhkdev.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Spring Data JPA автоматически реализует основные методы, такие как findAll, save, delete и т.д.
}
