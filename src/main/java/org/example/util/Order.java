package org.example.util;

import java.time.LocalDateTime;

public class Order {
    private final LocalDateTime dateTime;
    private final String name;
    private final int amountOfCement;

    public Order(LocalDateTime dateTime, String name, int amountOfCement) {
        this.dateTime = dateTime;
        this.name = name;
        this.amountOfCement = amountOfCement;
    }

    public LocalDateTime getTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfCement() {
        return amountOfCement;
    }
}