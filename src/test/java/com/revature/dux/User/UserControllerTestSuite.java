package com.revature.dux.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.OffsetDateTime;

@DataJpaTest
@ActiveProfiles("test")
public class UserControllerTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserController userController;

    @Test
    public void testUserSaved() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("test1");
        user.setEmail("test1@testmail.test");
        user.setPassword("test1234");
        user.setRegistrationDate(OffsetDateTime.now());
    }
}
