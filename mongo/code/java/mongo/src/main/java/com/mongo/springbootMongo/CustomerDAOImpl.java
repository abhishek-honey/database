package com.mongo.springbootMongo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAOImpl {

	@Autowired
	private MongoTemplate mongoTemplate;

	protected Class<Customer> getEntityClass() {
		return Customer.class;
	}

	public Customer insert(Customer entity) {
		return mongoTemplate.save(entity);
	}

	public List<Customer> findWithFields(Query query) {
		return mongoTemplate.find(query, getEntityClass());
	}

	public Customer getCustomerById(String id) {
		if (StringUtils.isEmpty(id))
			return null;

		Customer findById = mongoTemplate.findById(id, getEntityClass());
		System.out.println(findById);
		return findById;
	}

	public List<Customer> getCustomerByEmail(String email) {
		Query query = new Query(Criteria.where("email").is(email));
		return findWithFields(query);
	}

}
