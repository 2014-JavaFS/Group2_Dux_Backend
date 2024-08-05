package com.revature.dux.Order;

import com.revature.dux.Order.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

    //this function needs to find all orders that have the same seller id
    Optional<List<Order>> findBySeller_UserId(int userId);
}