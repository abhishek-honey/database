package com.server;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class MongoAtlas {

	@Value("${jdbc.url}")
	private String jdbcUrl;

	private MongoClient mongoClient;
	private Map<String, MongoDatabase> databases = new HashMap<>();
	private static final Logger logger = LoggerFactory.getLogger(MongoAtlas.class);

	@PreDestroy
	public void closeConnection() {
		if (null != mongoClient) {
			mongoClient.close();
			logger.info("[MONGO ATLAS] Successfully closed the connection");
		}
	}

//	@PostConstruct
	public void initMongoAtlas() {
		System.out.println("+++++++ JDBC URL: " + jdbcUrl);

		mongoClient = MongoClients.create(jdbcUrl);

		initDatabaseByName("sample_airbnb");
		MongoCollection<Document> collection = getCollection("sample_airbnb", "listingsAndReviews");
		System.out.println(collection.countDocuments());

//		MongoDatabase database = mongoClient.getDatabase("sample_airbnb");
//		MongoCollection<Document> collection = database.getCollection("listingsAndReviews");
//		System.out.println(collection);

		MongoDatabase mongoDatabase = databases.get("sample_airbnb");

		Map<String, Object> map = new HashMap<>();
		map.put("honey", "anjali");
		map.put("ana", "duke");
		map.put("berry", "goose");
		map.put("santa", "supply");

		Document document = new Document(map);
		mongoDatabase.getCollection("honey_collection").insertOne(document);
		System.out.println("Successfully inserted.");

	}

	public void initDatabaseByName(String databaseName) {
		MongoDatabase database = mongoClient.getDatabase(databaseName);
		databases.put(databaseName, database);
	}

	public MongoCollection<Document> getCollection(String database, String collectionName) {
		MongoDatabase mongoDatabase = databases.get(database);
		MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
		logger.info("Successfully retrieved the collection from mongo atlas size: [{}]", collection.countDocuments());
		return collection;
	}

}
