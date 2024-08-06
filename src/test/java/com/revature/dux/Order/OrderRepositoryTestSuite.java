package com.revature.dux.Order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class OrderRepositoryTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository;

    @Test
}
