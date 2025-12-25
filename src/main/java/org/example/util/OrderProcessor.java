package org.example.util;

import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.storage.adapter.FileOrderAdapter;

import java.util.List;


public class OrderProcessor {
    private FileOrderAdapter file;
    private OrderService orderService;
    public OrderProcessor(FileOrderAdapter file, OrderService orderService) {
        this.file = file;
        this.orderService = orderService;
    }

    public List<OrderReport> processOrders(String path, int sale, double pricePerOneKg, int discountStep, String result) {
        List<Order> orders = file.read(path);
        List<OrderReport> orderReports = orderService.reports(orders, sale, pricePerOneKg,discountStep);
        file.writeFile(result, orderReports);
        return orderReports;
    }

}
