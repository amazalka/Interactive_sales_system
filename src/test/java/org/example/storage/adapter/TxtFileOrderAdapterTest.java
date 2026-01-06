package org.example.storage.adapter;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.model.OrderReport;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TxtFileOrderAdapterTest {

    private TxtFileOrderAdapter file = new TxtFileOrderAdapter();

    @Test
    void readTxtFileOrderTest() throws URISyntaxException {
        Order order = new Order(LocalDateTime.of(2021, 2, 9, 16, 0, 22), "Industrial", 8800);
        URL resourceUrl = getClass().getClassLoader().getResource("discount_day.txt");
        if (resourceUrl != null) {
            Path path = Paths.get(resourceUrl.toURI());
            Order orderTest = file.read(String.valueOf(path)).get(0);
            assertEquals(order.getName(), orderTest.getName());
            assertEquals(order.getTime(), orderTest.getTime());
            assertEquals(order.getAmountOfCement(), orderTest.getAmountOfCement());
        }
    }

    @Test
    void readEmptyFileReturnsEmptyList() throws URISyntaxException {
        URL resourceUrl = getClass().getClassLoader().getResource("result.txt");
        if (resourceUrl != null) {
            Path path = Paths.get(resourceUrl.toURI());
            List<Order> orders = file.read(String.valueOf(path));
            assertTrue(orders.isEmpty(), "Список пустой, как и файл");
        }
    }

    @Test
    void readFileWithIncorrectContentThrowsException() throws URISyntaxException {
        URL resourceUrl = getClass().getClassLoader().getResource("excep.txt");
        if (resourceUrl != null) {
            Path path = Paths.get(resourceUrl.toURI());
            assertThrows(IORuntimeException.class, () -> file.read(String.valueOf(path)));
        }
    }

    @Test
    void writeTxtFileOrderTest() throws IOException, URISyntaxException {
        URL resourceUrl = getClass().getClassLoader().getResource("resultWrite.txt");
        if (resourceUrl != null) {
            Path path = Paths.get(resourceUrl.toURI());
            List<OrderReport> reports = List.of(new OrderReport("Industrial", 79200.0));
            try {
                file.writeFile(String.valueOf(path), reports);
                List<String> reportTest = Files.readAllLines(path);
                assertEquals("Industrial - 79200.0", reportTest.get(0));
            } finally {
                Files.deleteIfExists(path);
            }
        }
    }
}