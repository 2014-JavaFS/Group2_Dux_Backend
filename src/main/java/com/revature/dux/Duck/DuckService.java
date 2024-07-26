package com.revature.dux.Duck;

import com.revature.dux.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuckService implements Serviceable<Duck> {
    private DuckRepository duckRepository;

    @Autowired
    public DuckService(DuckRepository duckRepository) {
        this.duckRepository = duckRepository;
    }

    @Override
    public List<Duck> findAll() {
        return List.of();
    }

    @Override
    public Duck create(Duck newObject) {
        return null;
    }

    @Override
    public Duck findById(int number) {
        return null;
    }

    public Duck findByName(String name) {
        return null;
    }

    public Boolean update(Duck updateDuck) {
        return false;
    }

    public void delete(Duck duck) {

    }
}