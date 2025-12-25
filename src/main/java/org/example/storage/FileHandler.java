package org.example.storage;

import org.example.storage.adapter.AnotherFileHandler;
import org.example.exception.IORuntimeException;
import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.storage.adapter.TxtFileHandler;
import org.example.storage.target.FileReader;
import java.io.*;
import java.util.List;

public class FileHandler {
    public List<Order> readFile(String path)  {
        FileReader fileReader;
        if (path.endsWith(".txt")) {
            fileReader = new TxtFileHandler();
        } else{
            fileReader = new  AnotherFileHandler();
        }
        return fileReader.read(path);
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