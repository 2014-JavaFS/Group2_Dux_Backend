package com.revature.dux.Duck;

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
public class DuckControllerIntegrationTests {
    @MockBean
    private DuckRepository duckRepository;

    @MockBean
    private DuckService duckService;

    @Autowired
    private DuckController duckController;

    @Autowired
    private MockMvc mockMvc;

    @Test

}
