package org.example;

import org.example.util.OrderProcessor;

public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\discount_day.txt";
        String result = "C:\\Users\\Admin\\IdeaProjects\\Java2\\src\\main\\java\\org\\example\\files\\result.txt";
        orderProcessor.sum(path, 50, 500, 5, result);
    }
}