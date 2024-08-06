package com.revature.dux.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.OffsetDateTime;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = new User();
        user.setUserId(1001);
        user.setUsername("test1");
        user.setEmail("tester1@test.test");
        user.setPassword("test12345");
        user.setRegistrationDate(OffsetDateTime.now());

        User savedUser = userRepository.save(user);
        Assertions.assertEquals(1001, savedUser.getUserId());
        Assertions.assertNotEquals("u1@mail.com", savedUser.getEmail());
    }

    @Test
    public void testFindAll() {

    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testFindByUsername() {

    }

    @Test
    public void testFindByEmailAndPassword() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }
}

/*
* findAll
* findById
* findByEmailAndPassword
* findByUsername
* authCheck
* create
* delete
* update
* */