package org.example.util;

import org.example.model.Order;
import org.example.model.OrderReport;
import java.util.*;

public class OrderService {
    private static final double kg = 50;
    public List<OrderReport> reports (List<Order> orders, int sale, double pricePerOneKg, int discountStep) {
        List<OrderReport> orderReports = new ArrayList<>();
        Map<String, Double> ordersMap = new LinkedHashMap<>();
        orders.sort(Comparator.comparing(Order::getTime));
        double sum;
        for (Order order : orders) {
            int cement = order.getAmountOfCement();
            if (sale > 0) {
                double prsale = (double) (1 - sale / 100d);
                sum = Math.round(((double) (cement / kg) * pricePerOneKg) * prsale);
                sale = sale - discountStep;
            } else {
                sum = Math.round(((double) (cement / kg) * pricePerOneKg));
            }
            ordersMap.merge(order.getName(), sum, (oldValue, newValue) -> oldValue + newValue);
        }
        for (Map.Entry<String,Double> orderMap : ordersMap.entrySet()){
            orderReports.add(new OrderReport(orderMap.getKey(),orderMap.getValue()));
        }
        return orderReports;
    }
}
