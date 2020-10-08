package com.rest.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.controller.impl.MongoAtlasControllerImpl;
import com.rest.dto.Greeting;

@RestController
public class MongoAtlasController {

	@Autowired
	MongoAtlasControllerImpl serviceImpl;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/getSizeOfCollection")
	public Map<String, String> getSizeOfCollection(@RequestParam(value = "dbName", defaultValue = "") String name,
			@RequestParam(value = "collection", defaultValue = "") String collection) {
		return null;
	}

}
