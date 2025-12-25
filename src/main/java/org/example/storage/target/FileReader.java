package org.example.storage.target;

import org.example.model.Order;
import java.util.List;

public interface FileReader {
    List<Order> read(String file);
}

