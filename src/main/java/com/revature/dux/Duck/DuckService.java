package com.revature.dux.Duck;

import com.revature.dux.util.exceptions.DataNotFoundException;
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
        return duckRepository.findAll();
    }

    @Override
    public Duck findById(int id) {
        return duckRepository.findById(id).orElseThrow(() -> new DataNotFoundException("no duck with that id"));
    }

    public Duck findByName(String name) {
        return duckRepository.findByName(name).orElseThrow(() -> new DataNotFoundException("no duck with that name"));
    }

    @Override
    public Duck create(Duck newDuck) {
        return duckRepository.save(newDuck);
    }

    public Boolean update(Duck updateDuck) {
        duckRepository.save(updateDuck);
        return true;
    }

    public boolean delete(Duck dyingDuck) {
        duckRepository.delete(dyingDuck);
        return true;
    }
}