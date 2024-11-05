package Input;

import java.util.Scanner;

public class InputHelper {
    private static Scanner scanner = new Scanner(System.in); // Статический экземпляр Scanner для чтения ввода с консоли

    // Метод для получения строки от пользователя
    public static String getString(String prompt) {
        System.out.print(prompt); // Вывод подсказки
        return scanner.nextLine(); // Чтение строки из консоли
    }

    // Метод для получения целого числа от пользователя
    public static int getInt(String prompt) {
        System.out.print(prompt);  // Вывод подсказки
        return Integer.parseInt(scanner.nextLine()); // Чтение строки и преобразование в целое число
    }

    // Метод для получения дробного числа от пользователя
    public static double getDouble(String prompt) {
        System.out.print(prompt); // Вывод подсказки
        return Double.parseDouble(scanner.nextLine()); // Чтение строки и преобразование в дробное число
        }
}


