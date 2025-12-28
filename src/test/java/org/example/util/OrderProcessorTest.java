package org.example.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.example.model.Order;
import org.example.model.OrderReport;
import org.example.storage.adapter.FileOrderAdapter;
import org.example.storage.adapter.FileOrderAdapterFactory;
import java.time.LocalDateTime;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderProcessorTest {
    @Mock
    private OrderService orderService;
    @Mock
    private FileOrderAdapterFactory adapterFactory;
    @Mock
    private FileOrderAdapter fileAdapter;
    @InjectMocks
    private OrderProcessor orderProcessor;
    @Test
    void processOrders() {
        String path = "discount_day.txt";
        String result = "result.txt";
        List<Order> orders = List.of(
                new Order(LocalDateTime.of(2021, 2, 9, 16, 0, 22), "Industrial", 8800)
        );
        List<OrderReport> reports = List.of(
                new OrderReport("Industrial", 79200.0)
        );
        when(adapterFactory.getAdapter(path)).thenReturn(fileAdapter);
        when(fileAdapter.read(path)).thenReturn(orders);
        when(orderService.reports(orders,50,500.0,5)).thenReturn(reports);

        List<OrderReport> orderReports = orderProcessor.processOrders(path, 50,500,5, result);

        verify(adapterFactory).getAdapter(path);
        verify(fileAdapter).read(path);
        verify(orderService).reports(orders,50,500.0,5);
        verify(fileAdapter).writeFile(result, reports);
        assertEquals(reports, orderReports);
    }
}