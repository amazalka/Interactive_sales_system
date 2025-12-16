package org.example.util;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderProcessor{
    private int sale = 50;
    public List<OrderReport> sum(List<Order> orders){
        List<OrderReport> orderReports = new ArrayList<>();
        orders.sort(Comparator.comparing(Order::getTime));
        for (Order order:orders){
            int cement = order.getAmountOfCement();
            if (sale > 0) {
                double prsale = (double) (1 - sale / 100d);
                double sum = Math.round(((double) (cement / 50d) * 500) * prsale);
                orderReports.add(new OrderReport(order.getName(), sum));
                sale = sale - 5;
            }else {
                double sum = Math.round(((double) (cement / 50d) * 500));
                orderReports.add(new OrderReport(order.getName(), sum));
            }
        }
        return orderReports;
    }
}