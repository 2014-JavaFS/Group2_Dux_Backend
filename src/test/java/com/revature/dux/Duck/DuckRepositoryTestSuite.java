package com.revature.dux.Duck;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class DuckRepositoryTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DuckRepository duckRepository;

    @Test
}
