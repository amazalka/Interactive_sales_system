package org.example.util;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime time;
    private String name;
    private int amountOfCement;

    public Order(LocalDateTime time, String name, int amountOfCement) {
        this.time = time;
        this.name = name;
        this.amountOfCement = amountOfCement;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfCement() {
        return amountOfCement;
    }
}