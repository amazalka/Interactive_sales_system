package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.util.*;
public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        FileHandler file = new FileHandler();
        try {
           List<Order> orders = file.readFile("C:\\Users\\Admin\\IdeaProjects\\Java2\\discount_day.txt");
            List<OrderReport> orderReports = orderProcessor.sum(orders);
           file.writeFile("C:\\Users\\Admin\\IdeaProjects\\Java2\\result.txt", orderReports);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}