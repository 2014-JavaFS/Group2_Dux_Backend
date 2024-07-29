package com.revature.dux.Duck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DuckRepository extends JpaRepository<Duck, Integer> {
    Optional<Duck> findByName(String name);
}