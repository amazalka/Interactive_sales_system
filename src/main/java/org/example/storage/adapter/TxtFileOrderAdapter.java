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
        List<Order> orders = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String str;
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                String[] str1 = str.split("\\|");
                LocalDateTime time = LocalDateTime.parse(str1[0]);
                String name = str1[1];
                int amountOfCement = Integer.parseInt(str1[2]);
                orders.add(new Order(time, name, amountOfCement));
            }
        } catch (IOException e) {
            throw new IORuntimeException("Ошибка чтения файла");
        }
        return orders;
    }
}
