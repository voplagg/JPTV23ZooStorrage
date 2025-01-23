package ee.ivkhkdev.repository;

import ee.ivkhkdev.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Вы можете добавить кастомные методы, если нужно
}
