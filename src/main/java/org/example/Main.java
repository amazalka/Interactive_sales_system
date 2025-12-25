package org.example;

import org.example.storage.FileHandler;
import org.example.util.OrderProcessor;
import org.example.util.OrderService;

public class Main {
    public static void main(String[] args) {
        FileHandler file = new FileHandler();
        OrderService orderService = new OrderService();
        OrderProcessor orderProcessor = new OrderProcessor(file, orderService);
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\discount_day.txt";
        String result = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\result.txt";
        orderProcessor.sum(path, 50, 500, 5, result);
    }
}