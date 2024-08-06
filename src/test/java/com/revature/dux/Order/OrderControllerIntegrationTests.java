package com.revature.dux.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrderControllerIntegrationTests {
    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderService orderService;

    @Autowired
    private OrderController orderController;

    @Autowired
    private MockMvc mockMvc;

    @Test

}
