package com.revature.dux.Duck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuckRepository extends JpaRepository<Duck, Integer> {

}