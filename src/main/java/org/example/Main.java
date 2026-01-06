package org.example;

import org.example.storage.adapter.FileOrderAdapterFactory;
import org.example.util.OrderProcessor;
import org.example.util.OrderService;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\discount_day.txt";
        String result = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\result.txt";
        FileOrderAdapterFactory factory = new FileOrderAdapterFactory();
        OrderService orderService = new OrderService();
        OrderProcessor orderProcessor = new OrderProcessor(factory, orderService);
        orderProcessor.processOrders(path, 50, 500, 5, result);
    }
}