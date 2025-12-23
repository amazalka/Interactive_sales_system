package org.example.storage;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.model.OrderReport;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<Order> readFile(String path)  {
        List<Order> orders = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path);
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

    public void writeFile(String result, List<OrderReport> orderReports) {
        try (FileWriter fileWriter = new FileWriter(result);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (OrderReport orderReport : orderReports) {
                String str = orderReport.getName() + " - " + orderReport.getSum();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e){
            throw new IORuntimeException("Ошибка записи файла");
        }
    }
}