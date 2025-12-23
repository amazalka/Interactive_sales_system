package org.example.util;

import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.storage.FileHandler;
import java.util.List;

public class OrderProcessor {
    public List<OrderReport> sum(String path, int sale, double pricePerOneKg, int discountStep, String result) {
            FileHandler file = new FileHandler();
            List<Order> orders = file.readFile(path);
            OrderService orderService = new OrderService();
            List<OrderReport> orderReports = orderService.reports(orders, sale, pricePerOneKg,discountStep);
            file.writeFile(result, orderReports);
            return orderReports;
    }
}
