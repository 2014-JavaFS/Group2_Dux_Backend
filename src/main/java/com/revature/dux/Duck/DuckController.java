package com.revature.dux.Duck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ducks")
public class DuckController {
    private final DuckService duckService;

    @Autowired
    public DuckController(DuckService duckService) {
        this.duckService = duckService;
    }

    @GetMapping
    private ResponseEntity<List<Duck>> findAllDucks() {
        return ResponseEntity.ok().body(duckService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Duck> findDuckById(@PathVariable int id) {
        return null;
    }

    @GetMapping("/{name}")
    private ResponseEntity<Duck> findDuckByName(@PathVariable String name) {
        return ResponseEntity.ok().body(duckService.findByName(name));
    }

    @PostMapping
    private ResponseEntity<Duck> postNewDuck(@RequestBody Duck newDuck) {
        return ResponseEntity.status(HttpStatus.CREATED).body(duckService.create(newDuck));
    }

    @PutMapping
    private ResponseEntity<Boolean> putUpdateDuck(@RequestBody Duck updateDuck) {
        return ResponseEntity.ok(duckService.update(updateDuck));
    }

    @DeleteMapping
    private ResponseEntity<Void> deleteDuck(@RequestBody Duck duck) {
        duckService.delete(duck);
        return ResponseEntity.noContent().build();
    }
}