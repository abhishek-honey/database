package com.server.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mongodb.annotations.Beta;
import com.server.dto.Person;

//@Service
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

	Person findFirstByName(String name);

	@Query("{address:'?0'}")
	List<Person> findCustomByAddress(String address);

	@Query("{address : { $regex: ?0 } }")
	List<Person> findCustomByRegExAddress(String domain);
}
