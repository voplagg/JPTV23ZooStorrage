package ee.ivkhkdev.input;

import ee.ivkhkdev.input.ConsoleInput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsoleInputTest {

    @Test
    void testNextLine() {
        String input = "Hello, World!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in); // подменяем стандартный поток ввода

        ConsoleInput consoleInput = new ConsoleInput();
        String result = consoleInput.nextLine();

        assertEquals(input, result, "Введенная строка должна быть равна заданной строке");

        // Восстановить стандартный поток ввода
        System.setIn(System.in);
    }
}
