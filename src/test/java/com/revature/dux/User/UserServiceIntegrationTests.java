package com.revature.dux.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class UserServiceIntegrationTests {
    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    private UserService sut;

    @Test

}
