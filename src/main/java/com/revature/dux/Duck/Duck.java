package com.revature.dux.Duck;

import java.math.BigDecimal;

public class Duck {

    private int duckId;
    private String duckName;
    private String description;
    private DuckRarity rarity;
    private short year;
    private DuckCondition condition;
    private BigDecimal price;

    public enum DuckRarity {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }

    public enum DuckCondition {
        MINT, NEARMINT, LP, HP, DAMAGED
    }

    public Duck() {
    }

    public Duck(int duckId, String duckName, String description, DuckRarity rarity, short year, DuckCondition condition, BigDecimal price) {
        this.duckId = duckId;
        this.duckName = duckName;
        this.description = description;
        this.rarity = rarity;
        this.year = year;
        this.condition = condition;
        this.price = price;
    }

    public int getDuckId() { return this.duckId; }

    public void setDuckId(int duckId) { this.duckId = duckId; }

    public String getDuckName() { return this.duckName; }

    public void setDuckName(String duckName) { this.duckName = duckName; }

    public String getDescription() { return this.description; }

    public void setDescription(String description) { this.description = description; }

    public DuckRarity getRarity() { return this.rarity; }

    public void setRarity(String rarity) { this.rarity = DuckRarity.valueOf(rarity); }

    public short getYear() { return this.year; }

    public void setYear(short year) { this.year = year; }

    public DuckCondition getCondition() { return this.condition; }

    public void setCondition(String condition) { this.condition = DuckCondition.valueOf(condition); }

    public BigDecimal getPrice() { return this.price; }

    public void setPrice(BigDecimal price) { this.price = price; }
}