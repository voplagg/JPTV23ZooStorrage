package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Здесь можно добавлять свои кастомные методы, если это необходимо
}

