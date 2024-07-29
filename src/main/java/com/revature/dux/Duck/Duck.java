package com.revature.dux.Duck;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data //getters & setters
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="ducks")
public class Duck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int duckId;

    private String name;
    private String description;

    /*@Column(name="release_year", columnDefinition = "smallint", nullable = false)
    private short release_year;*/

    @Column(name="rarity", columnDefinition = "varchar(9) default 'COMMON'", nullable = false)
    @Enumerated(EnumType.STRING)
    private DuckRarity rarity;

    @Column(name="condition", columnDefinition = "varchar(4) default 'NM'", nullable = false)
    @Enumerated(EnumType.STRING)
    private DuckCondition condition;

    @Column(name = "price", precision=9, scale=2)
    private BigDecimal price;

    public enum DuckRarity {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }

    public enum DuckCondition {
        MINT, NM, LP, HP, DMG
    }
}