package com.marcelocastro.springmongopoc;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerMongoRepository extends MongoRepository<Customer, String> {

  Optional<Customer> findCustomerByEmail(String email);
}
