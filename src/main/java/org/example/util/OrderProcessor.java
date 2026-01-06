package org.example.util;

import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.storage.adapter.FileOrderAdapter;
import org.example.storage.adapter.FileOrderAdapterFactory;

import java.util.List;

public class OrderProcessor {
    private OrderService orderService;
    private FileOrderAdapterFactory fileOrder;
    public OrderProcessor(FileOrderAdapterFactory fileOrder, OrderService orderService) {
        this.orderService = orderService;
        this.fileOrder = fileOrder;
    }

    public List<OrderReport> processOrders(String path, int sale, double pricePerOneKg, int discountStep, String result) {
        FileOrderAdapter file = fileOrder.getAdapter(path);
        List<Order> orders = file.read(path);
        List<OrderReport> orderReports = orderService.reports(orders, sale, pricePerOneKg,discountStep);
        file.writeFile(result, orderReports);
        return orderReports;
    }
}
