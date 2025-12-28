package org.example.storage.adapter;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TxtFileOrderAdapterTest {
    private TxtFileOrderAdapter file = new TxtFileOrderAdapter();

    @Test
    void readTxtFileOrderTest() {
        Order order = new Order(LocalDateTime.of(2021, 2, 9, 16, 0, 22), "Industrial", 8800);
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\discount_day.txt";
        Order orderTest = file.read(path).get(0);
        assertEquals(order.getName(), orderTest.getName());
        assertEquals(order.getTime(), orderTest.getTime());
        assertEquals(order.getAmountOfCement(), orderTest.getAmountOfCement());
    }

    @Test
    void readEmptyFileReturnsEmptyList() {
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\result.txt";
        List<Order> orders = file.read(path);
        assertTrue(orders.isEmpty(), "Список пустой, как и файл");
    }

    @Test
    void readFileWithIncorrectContentThrowsException() {
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\exception.txt";
        assertThrows(IORuntimeException.class, () -> file.read(path));
    }
}