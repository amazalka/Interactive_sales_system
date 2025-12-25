package org.example;

import org.example.storage.adapter.FileOrderAdapter;
import org.example.storage.adapter.FileOrderAdapterFactory;
import org.example.util.OrderProcessor;
import org.example.util.OrderService;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\discount_day.txt";
        String result = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\result.txt";
        FileOrderAdapterFactory file = new FileOrderAdapterFactory();
        FileOrderAdapter fileOrder = file.getAdapter(path);
        OrderService orderService = new OrderService();
        OrderProcessor orderProcessor = new OrderProcessor(fileOrder, orderService);
        orderProcessor.processOrders(path, 50, 500, 5, result);
    }
}