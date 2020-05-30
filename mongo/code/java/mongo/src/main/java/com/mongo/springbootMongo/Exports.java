package com.mongo.springbootMongo;

import java.util.Arrays;

public class Exports {
    private Foods[] foods;

    public Exports(Foods[] foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "Exports{" +
                "foods=" + Arrays.toString(foods) +
                '}';
    }
}
