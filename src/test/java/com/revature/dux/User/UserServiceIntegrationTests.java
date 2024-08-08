package com.revature.dux.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

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

    }
}
