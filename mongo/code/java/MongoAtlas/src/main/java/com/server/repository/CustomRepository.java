package com.server.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository {
	long updateUser(String address, Double salary);
}
