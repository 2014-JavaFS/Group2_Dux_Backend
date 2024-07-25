package com.revature.dux.Order;

import com.revature.dux.Order.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    @Override
    default void flush() {

    }

    @Override
    default <S extends Order> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    default void deleteAllInBatch(Iterable<Order> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default Order getOne(Integer integer) {
        return null;
    }

    @Override
    default Order getById(Integer integer) {
        return null;
    }

    @Override
    default Order getReferenceById(Integer integer) {
        return null;
    }

    @Override
    default <S extends Order> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    default <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    default <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    default List<Order> findAll() {
        return List.of();
    }

    @Override
    default List<Order> findAllById(Iterable<Integer> integers) {
        return List.of();
    }

    @Override
    default <S extends Order> S save(S entity) {
        return null;
    }

    @Override
    default Optional<Order> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Integer integer) {
        return false;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Integer integer) {

    }

    @Override
    default void delete(Order entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    default void deleteAll(Iterable<? extends Order> entities) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default List<Order> findAll(Sort sort) {
        return List.of();
    }

    @Override
    default Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}