package org.example.util;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public List<Order> readFile(String path) throws IOException {
        List<Order> orders = new ArrayList<>();
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                String[] str1 = str.split("\\|");
                LocalDateTime time = LocalDateTime.parse(str1[0]);
                String name = str1[1];
                int amountOfCement = Integer.parseInt(str1[2]);
                orders.add(new Order(time, name, amountOfCement));
            }
        return orders;
    }

    public void writeFile(String result, List<OrderReport> orderReports) throws IOException {
        FileWriter fileWriter = new FileWriter(result);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(OrderReport orderReport:orderReports) {
            String str = orderReport.getName() + " - " + orderReport.getSum();
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}