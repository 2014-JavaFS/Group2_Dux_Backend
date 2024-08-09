package com.revature.dux.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveValid() {
        User user = new User();
        user.setUserId(1001);
        user.setUsername("test1");
        user.setEmail("tester1@test.com");
        user.setPassword("test12345*");
        user.setRegistrationDate(LocalDate.now());

        User savedUser = userRepository.save(user);
        Assertions.assertEquals(1001, savedUser.getUserId());
        Assertions.assertNotEquals("u1@mail.com", savedUser.getEmail());
    }

    @Test
    public void testFindAllNotNull() {
        List<User> userList = userRepository.findAll();
        Assertions.assertNotNull(userList);
    }

    @Test
    public void testFindByIdValid() {
        Optional<User> user = userRepository.findById(1001);
        Assertions.assertTrue(user.toString().contains("test1"));
    }

    @Test
    public void testFindByUsernameValid() {
        Optional<User> user = userRepository.findByUsername("test1");
        Assertions.assertTrue(user.toString().contains("1001"));
    }

    @Test
    public void testFindByEmailAndPasswordValid() {
        Optional<User> user = userRepository.findByEmailAndPassword("tester1@test.com", "test12345");
        Assertions.assertTrue(user.toString().contains("1001"));
    }

    @Test
    public void testDeleteValid() {
        userRepository.deleteById(1001);
        Optional<User> deletedUser = userRepository.findById(1001);
        Assertions.assertFalse(deletedUser.isPresent());
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