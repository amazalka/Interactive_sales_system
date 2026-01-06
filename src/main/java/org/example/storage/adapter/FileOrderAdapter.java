package org.example.storage.adapter;

import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.model.OrderReport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface FileOrderAdapter {
    List<Order> read(String file);
    default void writeFile(String result, List<OrderReport> orderReports){
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
