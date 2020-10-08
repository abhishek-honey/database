package com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.server.dto.Person;
import com.server.repository.CustomRepository;
import com.server.repository.PersonRepository;

@SpringBootApplication(scanBasePackages = { "com" })
@ComponentScan({ "com" })
@EntityScan("com")
@EnableMongoRepositories("com.server.repository")
public class MongoAtlasDemoApplication2 implements CommandLineRunner {

	@Autowired
	PersonRepository repository;

	@Autowired
	CustomRepository crepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoAtlasDemoApplication2.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		findFirst();
		findByRegex();
		findcrepo();
	}

	private void findcrepo() {
		crepo.updateUser("London", 10000000000.0);
	}

	public void deleteAll() {
		System.out.println("Deleting all records..");
		repository.deleteAll();
	}

	public void addSampleData() {
		System.out.println("Adding sample data");
		repository.save(new Person("Jack Bauer", "New York", 11111d));
		repository.save(new Person("Harvey Spectre", "London", 22222d));
		repository.save(new Person("Mike Ross", "New Jersey", 333333d));
		repository.save(new Person("Louise Litt", "Kathmandu", 44444d));
	}

	public void listAll() {
		System.out.println("Listing sample data");
		repository.findAll().forEach(u -> System.out.println(u));
	}

	public void findFirst() {
		System.out.println("Finding first by Name");
		Person u = repository.findFirstByName("Louise Litt");
		System.out.println(u);
	}

	public void findByRegex() {
		System.out.println("Finding by Regex - All with address starting with ^New");
		repository.findCustomByRegExAddress("^New").forEach(u -> System.out.println(u));
	}
}
