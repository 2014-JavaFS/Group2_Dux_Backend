package com.revature.dux.Duck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class DuckServiceIntegrationTest {
    @Mock
    private DuckRepository mockDuckRepository;

    @InjectMocks
    private DuckService sut;

}
