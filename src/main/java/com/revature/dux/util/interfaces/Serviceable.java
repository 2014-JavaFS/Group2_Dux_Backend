package com.revature.dux.util.interfaces;

import java.util.List;

public interface Serviceable<O> {
    List<O> findAll();
    O create(O newObject);
    O findById(int number);
}