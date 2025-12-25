package org.example.util;

import org.example.Main;
import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.storage.FileHandler;
import java.util.List;

public class OrderProcessor {
    private FileHandler  file;
    private OrderService orderService;
    public OrderProcessor(FileHandler file, OrderService orderService) {
        this.file = file;
        this.orderService = orderService;
    }

    public List<OrderReport> sum(String path, int sale, double pricePerOneKg, int discountStep, String result) {
            List<Order> orders = file.readFile(path);
            List<OrderReport> orderReports = orderService.reports(orders, sale, pricePerOneKg,discountStep);
            file.writeFile(result, orderReports);
            return orderReports;
    }
}
