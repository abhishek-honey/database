package com.mongo.springbootMongo;

import org.springframework.data.annotation.Id;

public class Countries {
    private Exports exports;

    private String name;

    @Id
    private String _id;


    public Countries(Exports exports, String name) {
        this.exports = exports;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "exports=" + exports +
                ", name='" + name + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
