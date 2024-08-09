package com.revature.dux.User;

import com.revature.dux.util.exceptions.DataNotFoundException;
import com.revature.dux.util.exceptions.InvalidInputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserServiceIntegrationTests {
    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService sut;

    @Test
    public void testFindAllNotNull() {
        List<User> mockUsers = Arrays.asList(new User(), new User(), new User(), new User(),
                                             new User(), new User(), new User(), new User());
        when(mockUserRepository.findAll()).thenReturn(mockUsers);

        List<User> resultingUsers = sut.findAll();

        assertFalse(resultingUsers.isEmpty());
        assertEquals(8, resultingUsers.size());
    }

    @Test
    public void testFindAllThrowsDataNotFoundException() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        Assertions.assertThrows(DataNotFoundException.class, userService::findAll);
    }

    @Test
    public void testFindUserByIdReturnsValidUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        int userId = 1002;
        User mockUser = new User(1002, "MockUser1", "mocktester1@test.mock", "mock12345", LocalDate.now());
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        boolean foundUser = sut.update(mockUser);

        Assertions.assertTrue(foundUser);
    }

    @Test
    public void testFindUserByUsernameReturnsValidUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        int userId = 1002;
        User mockUser = new User(1002, "MockUser2", "mocktester2@test.mock", "mock12345", LocalDate.now());
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        boolean foundUser = sut.update(mockUser);

        Assertions.assertTrue(foundUser);
    }

    @Test
    public void testFindUserByEmailAndPasswordReturnsValidUser() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        int userId = 1002;
        User mockUser = new User(1002, "MockUser3", "mocktester3@test.com", "mock12345*", LocalDate.now());
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        boolean foundUser = sut.update(mockUser);

        Assertions.assertTrue(foundUser);
    }

    @Test
    public void testInvalidCreateNullObject() {
        User mockUser = null;
        assertThrows(InvalidInputException.class, ()->sut.create(mockUserRepository.save(mockUser)));
    }

    @Test
    public void testInvalidCreateBadEmail() {
        User mockUser2 = new User();
        mockUser2.setUserId(4000);
        mockUser2.setEmail("ryan@tester.com");
        mockUser2.setPassword("test12345*");
        mockUser2.setRegistrationDate(LocalDate.now());
        assertThrows(InvalidInputException.class, ()->sut.create(mockUserRepository.save(mockUser2)));

        mockUser2.setEmail("ryan.tester.org");
        assertThrows(InvalidInputException.class, ()->sut.create(mockUserRepository.save(mockUser2)));
    }

    @Test
    public void testInvalidCreateBadPassword() {
        User mockUser2 = new User();
        mockUser2.setUserId(4000);
        mockUser2.setEmail("ryan@tester.test");
        mockUser2.setPassword("test12345");
        mockUser2.setRegistrationDate(LocalDate.now());
        assertThrows(InvalidInputException.class, ()->sut.create(mockUserRepository.save(mockUser2)));

        mockUser2.setPassword("testaaaaa*");
        assertThrows(InvalidInputException.class, ()->sut.create(mockUserRepository.save(mockUser2)));
    }

    @Test
    public void testValidCreate() {
        User mockUser = new User(1003, "MockUser4", "mocktester4@test.com", "mock12345*", LocalDate.now());
        User createdUser = sut.create(mockUserRepository.save(mockUser));
        assertNotNull(createdUser);
        assertEquals(1003, createdUser.getUserId());
    }

    @Test
    public void testInvalidDelete() {
        User mockUser = new User(1003, "MockUser5", "mocktester5@test.com", "mock12345*", LocalDate.now());
        boolean deleteResult = sut.delete(mockUser);
        assertFalse(deleteResult);
    }

    @Test
    public void testValidDelete() {
        User mockUser = new User(1004, "MockUser6", "mocktester6@test.com", "mock12345*", LocalDate.now());
        User createdUser = sut.create(mockUserRepository.save(mockUser));
        assertNotNull(createdUser);

        boolean deleteResult = sut.delete(mockUser);
        assertTrue(deleteResult);
    }

    @Test
    public void testInvalidUpdateOfExistingProduct() {
        User mockUser = new User(1005, "MockUser7", "mocktester7@test.com", "mock12345*", LocalDate.now());
        User createdUser = sut.create(mockUserRepository.save(mockUser));
        assertNotNull(createdUser);

        mockUser.setUsername("FlyingPurplePeopleEater");
        createdUser = sut.create(mockUserRepository.save(mockUser));
        assertEquals("MockUser7", createdUser.getUsername());
    }

    @Test
    public void testValidUpdateOfExistingProduct() {
        User mockUser = new User(1006, "MockUser8", "mocktester8@test.com", "mock12345*", LocalDate.now());
        User createdUser = sut.create(mockUserRepository.save(mockUser));
        assertNotNull(createdUser);

        mockUser.setUsername("FlyingPurplePeopleEater");
        createdUser = sut.create(mockUserRepository.save(mockUser));
        assertEquals("FlyingPurplePeopleEater", createdUser.getUsername());
    }
}
