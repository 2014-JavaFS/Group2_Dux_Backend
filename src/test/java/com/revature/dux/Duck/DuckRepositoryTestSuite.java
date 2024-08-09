package com.revature.dux.Duck;

import com.revature.dux.User.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class DuckRepositoryTestSuite {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DuckRepository duckRepository;

    @Test
    public void testSaveValid() {
        Duck duck = new Duck();
        duck.setDuckId(13);
        duck.setName("spooky");
        duck.setDescription("Boo!");
        duck.setRarity(Duck.DuckRarity.valueOf("UNCOMMON"));
        duck.setCondition(Duck.DuckCondition.valueOf("NM"));
        duck.setPrice(BigDecimal.valueOf(69.420));

        Duck savedDuck = duckRepository.save(duck);
        Assertions.assertEquals(13, savedDuck.getDuckId());
        Assertions.assertNotEquals("scary", savedDuck.getName());
    }

    @Test
    public void testFindAllNotNull() {
        List<Duck> duckList = duckRepository.findAll();
        Assertions.assertNotNull(duckList);
    }

    @Test
    public void testFindByIdValid() {
        Optional<Duck> duck = duckRepository.findById(13);
        Assertions.assertTrue(duck.toString().contains("spooky"));
    }

    @Test
    public void testFindByNameValid() {
        Optional<Duck> duck = duckRepository.findByName("pirate");
        Assertions.assertTrue(duck.toString().contains("pirate"));
    }

    @Test
    public void testDeleteValid() {
        duckRepository.deleteById(13);
        Optional<Duck> deletedDuck = duckRepository.findById(13);
        Assertions.assertFalse(deletedDuck.isPresent());
    }
}
