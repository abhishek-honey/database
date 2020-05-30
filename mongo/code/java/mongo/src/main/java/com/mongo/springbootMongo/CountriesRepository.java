package com.mongo.springbootMongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountriesRepository extends MongoRepository<Countries, String> {

    public Countries findByName(String name);

}
