package com.revature.dux.Order;

import com.revature.dux.User.User;
import com.revature.dux.User.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class OrderRepositoryTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Mock
    private UserRepository mockUserRepository;

    @Test
    public void testSaveValid() {
        User mockUser1 = Mockito.mock(User.class);
        User mockUser2 = Mockito.mock(User.class);
        Order order = new Order();
        order.setOrderId(1001);
        order.setBuyer(mockUser1);
        order.setSeller(mockUser2);
        order.setStatus(Order.OrderStatus.valueOf("PROCESSING"));
        order.setQuantity((short)1);

        Order savedOrder = orderRepository.save(order);
        Assertions.assertEquals(1001, savedOrder.getOrderId());
        Assertions.assertNotEquals("PROCESSING", savedOrder.getStatus().toString());
    }

    @Test
    public void testFindAllNotNull() {
        List<Order> orderList = orderRepository.findAll();
        Assertions.assertNotNull(orderList);
    }

    @Test
    public void testFindAllBySeller() {

    }
}
