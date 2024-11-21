package ee.ivkhkdev;


import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.model.Customer;
import ee.ivkhkdev.model.Product;

public class App {
    private final Service<Product> productService;
    private final Input input;
    private final Service<Customer> customerService;

    public App(Input input, Service<Product> productService, Service<Customer> customerService) {
        this.input = input;
        this.productService = productService;
        this.customerService = customerService;
    }

    public void run() {
        boolean repeat = true;
        do {
            System.out.println("\n--- Главное меню ---");
            System.out.println("1. Выход из программы");
            System.out.println("2. Добавить продукт");
            System.out.println("3. Список продаваемых продуктов");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Покупка покупателем продукта");
            System.out.println("7. Оборот магазина");
            System.out.println("8. Добавить денег покупателю");
            System.out.println("9. Рейтинг покупателей");
            System.out.println("10. Рейтинг товаров");
            System.out.println("11. Редактировать товар");
            System.out.println("12. Редактировать пользователя");
            System.out.print("Выберите действие: ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Выход из программы...");
                    repeat = false; // Завершаем программу
                case 2:
                    if(productService.add()){
                        System.out.println("Продукт добавлен");
                    }else{
                        System.out.println("Продукт добавить не удалось");
                    };
                    break;
                case 3:
                    if(productService.print()){
                        System.out.println("-------------------");
                    }else{
                        System.out.println("Продукт напечатать не удалось");
                    };
                    break;
                case 4:
                    if(customerService.add()){
                        System.out.println("Покупатель добавлен");
                    }else{
                        System.out.println("Покупателя добавить не удалось");
                    };
                    break;
                case 5:
                    listCustomers();
                    break;
                case 6:
                    createOrderProcess();
                    break;
                case 7:
                    showStoreTurnover();
                    break;
                case 8:
                    addMoneyToCustomer();
                    break;
                case 9:
                    showCustomerRating();
                    break;
                case 10:
                    showProductSalesRating();
                    break;
                case 11:
                    editProduct();
                    break;
                case 12:
                    editCustomer();
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }while (repeat);
        System.out.println("До свидания!");
    }




}





