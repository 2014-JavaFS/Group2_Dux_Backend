package com.revature.dux.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    //this function needs to find all orders that have the same seller id
    @Query("SELECT o FROM Order o WHERE buyer.userId = :userId")
    Optional<List<Order>> findAllBySeller(@Param("userId") int userId);

    @Query("SELECT o FROM Order o WHERE buyer.userId = :userId")
    Optional<List<Order>> findAllByBuyer(@Param("userId") int userId);

    @Modifying //for updates and deletes
    @Transactional //apparently very important for updates to be properly committed
    @Query("UPDATE Order o SET o.orderDate = :now, o.status = 'PROCESSING' WHERE buyer = (SELECT u FROM User u WHERE userId = :userId) AND status = 'CART'")
    Optional<Integer> checkout(@Param("userId") int userId, @Param("now") LocalDateTime now);

    @Query("SELECT o FROM Order o WHERE buyer.userId = :userId AND status = 'CART'")
    Optional<List<Order>> findCart(@Param("userId") int userId);

    @Query("SELECT o FROM Order o WHERE buyer.userId = :userId AND NOT status = 'CART'")
    Optional<List<Order>> findHistory(@Param("userId") int userId);

    @Query(value = "INSERT INTO orders VALUES (default, :buyer, :seller, :duck, default, :quantity, default)",
            nativeQuery = true)
    Optional<Boolean> generateOrder(@Param("buyer") int buyer, @Param("seller") int seller, @Param("duck") int duck, @Param("quantity") int quantity);
}