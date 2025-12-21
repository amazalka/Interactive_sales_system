package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.util.*;
public class Main {

    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        String path = "C:\\Users\\Admin\\IdeaProjects\\Java2\\discount_day.txt";
        String result = "C:\\Users\\Admin\\IdeaProjects\\Java2\\result.txt";
        try {
            orderProcessor.sum(path, 500, 5, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}