package org.example.util;

public class OrderReport {
    private final String name;
    private final double sum;

    public OrderReport(String name,double sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }
}