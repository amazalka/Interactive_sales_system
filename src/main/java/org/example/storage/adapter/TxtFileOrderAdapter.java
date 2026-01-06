package org.example.storage.adapter;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TxtFileOrderAdapter implements FileOrderAdapter {
    @Override
    public List<Order> read(String file) {
        List<Order> orders;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            orders = new ArrayList<>(bufferedReader.lines()
                    .map(s -> s.split("\\|"))
                    .map(strings -> new Order(LocalDateTime.parse(strings[0]), strings[1], Integer.parseInt(strings[2])))
                    .toList());
        } catch (IOException e) {
            throw new IORuntimeException("Ошибка чтения файла");
        }
        return orders;
    }
}
