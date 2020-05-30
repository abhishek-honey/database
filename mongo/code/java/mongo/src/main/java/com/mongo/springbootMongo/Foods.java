package com.mongo.springbootMongo;

public class Foods {
    private String condiment;

    private String name;

    private String tasty;

    public Foods(String condiment, String name, String tasty) {
        this.condiment = condiment;
        this.name = name;
        this.tasty = tasty;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "condiment='" + condiment + '\'' +
                ", name='" + name + '\'' +
                ", tasty='" + tasty + '\'' +
                '}';
    }
}