package org.example.util;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderProcessor{
    private int sale = 50;
    public List<OrderReport> sum(String path, double pricePerOneKg,int discountStep, String result) throws IOException {
        FileHandler file = new FileHandler();
        List<Order> orders = file.readFile(path);
        List<OrderReport> orderReports = new ArrayList<>();
        orders.sort(Comparator.comparing(Order::getTime));
        for (Order order:orders) {
            int cement = order.getAmountOfCement();
            if (sale > 0) {
                double prsale = (double) (1 - sale / 100d);
                double sum = Math.round(((double) (cement / 50d) * pricePerOneKg) * prsale);
                orderReports.add(new OrderReport(order.getName(), sum));
                file.writeFile(result, orderReports);
                sale = sale - discountStep;
            }else {
                double sum = Math.round(((double) (cement / 50d) * pricePerOneKg));
                orderReports.add(new OrderReport(order.getName(), sum));
                file.writeFile(result, orderReports);
            }

        }
        return orderReports;
    }
}