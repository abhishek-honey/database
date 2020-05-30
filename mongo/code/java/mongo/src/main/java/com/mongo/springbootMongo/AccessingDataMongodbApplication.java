package com.mongo.springbootMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

    @Autowired
    private CountriesRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        Foods indianFoods_litti = new Foods("true","litti chokha", "true");
        Foods indianFoods_puri_sabji = new Foods("true","puri sabji", "true");

        Foods canadaFoods_bacon = new Foods("true","bacon", "false");
        Foods canadaFoods_syrup = new Foods("true","syrup", "true");

        repository.save(new Countries(new Exports(new Foods[]{indianFoods_litti, indianFoods_puri_sabji}), "India"));
        repository.save(new Countries(new Exports(new Foods[]{canadaFoods_bacon, canadaFoods_syrup}), "Canada"));

        // fetch all countries
        System.out.println("Countries found with findAll():");
        System.out.println("-------------------------------");
        for (Countries countries : repository.findAll()) {
            System.out.println(countries);
        }
        System.out.println();

        // fetch an individual Country
        System.out.println("Countries found with findByName('India'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("India"));
    }

}