package ee.ivkhkdev;

import ee.ivkhkdev.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static final String URL = "jdbc:mariadb://localhost:3306/shopdb";  // Замените на вашу базу данных
    private static final String USER = "root";  // Имя пользователя для MariaDB
    private static final String PASSWORD = "новый_пароль";  // Ваш пароль для MariaDB

    // Метод для получения соединения с базой данных
    private Connection getConnection() throws SQLException {
        try {
            // Загрузка драйвера MariaDB (не обязательно с Java 6 и выше, но можно оставить для совместимости)
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Добавление продукта в базу данных
    public void saveProduct(Product product) {
        String query = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Получение всех продуктов из базы данных
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}



